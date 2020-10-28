package com.agora.catalogo.agoracatalogo.controller;

import com.agora.catalogo.agoracatalogo.RecordNotFoundException;
import com.agora.catalogo.agoracatalogo.entity.Prodotto;
import com.agora.catalogo.agoracatalogo.entity.Store;
import com.agora.catalogo.agoracatalogo.service.ProdottoService;
import com.agora.catalogo.agoracatalogo.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class StoreController {

    @Autowired
    StoreService service;
    @Autowired
    ProdottoService prodottoService;

    @GetMapping("/public/home")
    public ResponseEntity<List<Store>> getAllStore(){
        List<Store> home= service.getAllStore();
        return new ResponseEntity<List<Store>>(home,new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping("/public/byCategoria")
    public ResponseEntity<List<Store>> byCategoria( String categoria){
        List<Store> home= service.getByCategoria(categoria);
        return new ResponseEntity<List<Store>>(home,new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping("/public/store/{partitaIva}")
    public ResponseEntity<Store> getStoreByPartitaIva(@PathVariable("partitaIva") Integer partitaIva)
            throws RecordNotFoundException {
        Store entity = service.getStorebyPartitaIva(partitaIva);

        return new ResponseEntity<Store>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/protected/creaStore")
    public ResponseEntity<Store> createOrUpdateStore(Store store , HttpServletRequest request) {

        Store updated = service.createOrUpdateStore(store);
        return new ResponseEntity<Store>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/protected/{partitaIva}")
    public HttpStatus deleteStoreById(@PathVariable("partitaIva") Integer partitaIva)
            throws RecordNotFoundException {
        service.deleteStoreByPartitaIva(partitaIva);
        return HttpStatus.FORBIDDEN;
    }



    //Controller prodotti
    @GetMapping("/public/lista")
    public ResponseEntity<List<Prodotto>> getAllProdotto() {
        List<Prodotto> list = prodottoService.getAllProdotto();

        return new ResponseEntity<List<Prodotto>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping("/public/byStore")
    public ResponseEntity<List<Prodotto>> getProductOfStore(Integer partitaIva){
        List<Prodotto> store = prodottoService.getByStore(partitaIva);
        return new ResponseEntity<List<Prodotto>>(store,new HttpHeaders(),HttpStatus.OK);
    }
    @GetMapping("/public/prodotto/{id}")
    public ResponseEntity<Prodotto> getProdottoById(@PathVariable("id") Integer id)
            throws RecordNotFoundException {
        Prodotto entity = prodottoService.getProdottoById(id);

        return new ResponseEntity<Prodotto>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/protected/creaProdotto")
    public ResponseEntity<Prodotto> createOrUpdateProdotto(Prodotto prodotto) {
        Prodotto updated = prodottoService.createOrUpdateProdotto(prodotto);
        return new ResponseEntity<Prodotto>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/protected/eliminaProdotto/{id}")
    public HttpStatus deleteProdottoById(@PathVariable("id") Integer id)
            throws RecordNotFoundException {
        prodottoService.deleteProdottoById(id);
        return HttpStatus.FORBIDDEN;
    }
}
