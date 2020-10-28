package com.agora.carrello.agoracarrello.service;

import com.agora.carrello.agoracarrello.RecordNotFoundException;
import com.agora.carrello.agoracarrello.entity.Carrello;
import com.agora.carrello.agoracarrello.entity.Prodotto;
import com.agora.carrello.agoracarrello.repository.CarrelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CarrelloService {

    @Autowired
    CarrelloRepository carrelloRepository;


    public List<Carrello> getAllCarrello() {
        List<Carrello> carrelloList= carrelloRepository.findAll();
        if(carrelloList.size() > 0) {
            return carrelloList;
        } else {
            return new ArrayList<Carrello>();
        }
    }
    public Carrello getCarelloByIdCarrello(Integer idCarrello) throws RecordNotFoundException {
        Optional<Carrello> carrello = carrelloRepository.findById(idCarrello);
        if(carrello.isPresent()) {
            return carrello.get();
        } else {
            throw new RecordNotFoundException("Non esiste un carrello con questo id");
        }
    }


    public Carrello createOrUpdateCarrello(Carrello entity) {
        Optional<Carrello> carrello = carrelloRepository.findById(entity.getIdCarrello());
        if(carrello.isPresent()) {
            Carrello newEntity = carrello.get();
            newEntity.setIdUtente(entity.getIdUtente());
            newEntity.setTotaleCarrello(entity.getTotaleCarrello());
            newEntity = carrelloRepository.save(newEntity);
            return newEntity;
        } else {
            entity = carrelloRepository.save(entity);

            return entity;
        }
    }

    public void deleteCarrelloByIdCarrello(Integer idCarrello) throws RecordNotFoundException {
        Optional<Carrello> carrello= carrelloRepository.findById(idCarrello);
        if(carrello.isPresent()) {
           carrelloRepository.deleteById(idCarrello);
        } else {
            throw new RecordNotFoundException("Non esiste un carrello con questo id");
        }
    }

    public void updateTotaleCarrelloByIdCarrello(Integer idCarrello,int prezzo,float quantita) throws RecordNotFoundException{
        Optional<Carrello> carrello = carrelloRepository.findById(idCarrello);
        if(carrello.isPresent()) {
            Carrello newEntity = carrello.get();
            int newTot=(int)(newEntity.getTotaleCarrello()+(prezzo*quantita));
            newEntity.setTotaleCarrello(newTot);
            carrelloRepository.save(newEntity);
        } else {
            throw new RecordNotFoundException("Non esiste un carrello con questo id");
        }
    }
}
