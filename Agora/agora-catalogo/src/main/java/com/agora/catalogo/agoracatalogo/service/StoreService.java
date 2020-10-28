package com.agora.catalogo.agoracatalogo.service;

import com.agora.catalogo.agoracatalogo.RecordNotFoundException;
import com.agora.catalogo.agoracatalogo.entity.Store;
import com.agora.catalogo.agoracatalogo.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StoreService {

    @Autowired
    StoreRepository storeRepository;


    public List<Store> getAllStore() {
        List<Store> storelist= storeRepository.findAll();
        if(storelist.size() > 0) {
            return storelist;
        } else {
            return new ArrayList<Store>();
        }
    }
    public Store getStorebyPartitaIva(Integer partitaIva)throws RecordNotFoundException {
        Optional<Store> store = storeRepository.findById(partitaIva);
        if(store.isPresent()) {
            return store.get();
        } else {
            throw new RecordNotFoundException("Non esiste un Store con questa partita iva");
        }
    }
    public List<Store> getByCategoria(String categoria){
        return storeRepository.getByCategoria(categoria);
    }

    public Store createOrUpdateStore(Store entity) {
        Optional<Store> store = storeRepository.findById(entity.getPartitaIva());
        if(store.isPresent()) {
            Store newEntity = store.get();
            newEntity.setNomeStore(entity.getNomeStore());
            newEntity.setCategoria(entity.getCategoria());
            newEntity.setDescrizione(entity.getDescrizione());
            newEntity.setImmagine(entity.getImmagine());
            newEntity = storeRepository.save(newEntity);
            return newEntity;
        } else {
            entity = storeRepository.save(entity);
            return entity;
        }
    }

    public void deleteStoreByPartitaIva(Integer partitaIva) throws RecordNotFoundException {
        Optional<Store> store = storeRepository.findById(partitaIva);
        if(store.isPresent()) {
            storeRepository.deleteById(partitaIva);
        } else {
            throw new RecordNotFoundException("Non esiste uno Store con questa partitaIva");
        }
    }



}
