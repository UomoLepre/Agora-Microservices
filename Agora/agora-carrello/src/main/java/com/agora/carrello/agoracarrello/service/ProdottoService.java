package com.agora.carrello.agoracarrello.service;

import com.agora.carrello.agoracarrello.ProdottoProxy;
import com.agora.carrello.agoracarrello.RecordNotFoundException;
import com.agora.carrello.agoracarrello.entity.Prodotto;
import com.agora.carrello.agoracarrello.repository.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdottoService {

    @Autowired
    ProdottoRepository repository;
    @Autowired
    ProdottoProxy proxy;

    public List<Prodotto> getAllProdotto() {
        List<Prodotto> prodottoList = repository.findAll();
        if(prodottoList.size() > 0) {
            return prodottoList;
        } else {
            return new ArrayList<Prodotto>();
        }
    }
    public Prodotto getProdottoById(Integer id) throws RecordNotFoundException {
        Optional<Prodotto> prodotto = repository.findById(id);
        if(prodotto.isPresent()) {
            return prodotto.get();
        } else {
            throw new RecordNotFoundException("Non esiste un prodotto con questo id");
        }
    }
    public List<Prodotto> getByIdCarrello(Integer idCarrello){
        return repository.getByIdCarrello(idCarrello);
    }

    public float createOrUpdateProdotto(Prodotto entity){
        Optional<Prodotto> prodotto = repository.findById(entity.getId());
        if(prodotto.isPresent()) {
            Prodotto newEntity = prodotto.get();
            int oldQuantita=newEntity.getQuantita();
            newEntity.setQuantita(entity.getQuantita());
            newEntity = repository.save(newEntity);
            float varQuantita=newEntity.getQuantita()-oldQuantita;
            return varQuantita;
        } else {
            entity = repository.save(entity);
            float varQuantita=entity.getQuantita();
            return varQuantita;
        }
    }

    public Prodotto importFromCatalogo(Integer idProdotto,Integer idCarrello,int quantita){
        Prodotto prodotto=proxy.recuperaProdotto(idProdotto);
        String newId= idProdotto.toString()+idCarrello.toString();
        prodotto.setId(Integer.parseInt(newId));
        prodotto.setIdCarrello(idCarrello);
        prodotto.setIdProdotto(idProdotto);
        prodotto.setQuantita(quantita);
        return prodotto;
    }

    public void deleteProdottoById(Integer id) throws RecordNotFoundException {
        Optional<Prodotto> prodotto = repository.findById(id);
        if(prodotto.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("Non esiste un prodotto con questo id");
        }
    }







}
