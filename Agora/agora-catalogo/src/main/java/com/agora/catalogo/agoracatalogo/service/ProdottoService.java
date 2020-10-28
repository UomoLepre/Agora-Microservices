package com.agora.catalogo.agoracatalogo.service;

import com.agora.catalogo.agoracatalogo.RecordNotFoundException;
import com.agora.catalogo.agoracatalogo.entity.Prodotto;
import com.agora.catalogo.agoracatalogo.repository.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdottoService {


    @Autowired
    ProdottoRepository repository;


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
    public List<Prodotto> getByStore(Integer partitaIva){
        return repository.getByPartitaIva(partitaIva);
    }


    public Prodotto createOrUpdateProdotto(Prodotto entity) {
        Optional<Prodotto> prodotto = repository.findById(entity.getId());
        if(prodotto.isPresent()) {
            Prodotto newEntity = prodotto.get();
            newEntity.setNomeProdotto(entity.getNomeProdotto());
            newEntity.setPrezzo(entity.getPrezzo());
            newEntity.setDescrizione(entity.getDescrizione());
            newEntity.setImmagine(entity.getImmagine());
            newEntity = repository.save(newEntity);
            return newEntity;
        }else {
            entity = repository.save(entity);
            return entity;
        }
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
