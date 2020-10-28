package com.agora.carrello.agoracarrello.controller;

import com.agora.carrello.agoracarrello.RecordNotFoundException;
import com.agora.carrello.agoracarrello.entity.Carrello;
import com.agora.carrello.agoracarrello.entity.Prodotto;
import com.agora.carrello.agoracarrello.service.CarrelloService;
import com.agora.carrello.agoracarrello.service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class CarrelloController {

    @Autowired
    CarrelloService carrelloService;
    @Autowired
    ProdottoService prodottoService;

    @GetMapping("/Admin/carrelli")
    public ResponseEntity<List<Carrello>> getAllCarrello(){
        List<Carrello> carrelli= carrelloService.getAllCarrello();
        return new ResponseEntity<List<Carrello>>(carrelli,new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/protected/{id}")
    public ResponseEntity<Carrello> getCarrelloByIdCarrello(@PathVariable("id")Integer id)
            throws RecordNotFoundException {
        Carrello entity = carrelloService.getCarelloByIdCarrello(id);

        return new ResponseEntity<Carrello>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/protected/byIdCarrello")
    public ResponseEntity<List<Prodotto>> getProductOfCarrello(Integer idCarrello){
        List<Prodotto> carrello = prodottoService.getByIdCarrello(idCarrello);
        return new ResponseEntity<List<Prodotto>>(carrello,new HttpHeaders(),HttpStatus.OK);
    }


    @PostMapping("/protected/creaCarrello")
    public ResponseEntity<Carrello> createOrUpdateCarrello(Carrello carrello) {
        Carrello updated = carrelloService.createOrUpdateCarrello(carrello);
        return new ResponseEntity<Carrello>(updated, new HttpHeaders(), HttpStatus.OK);
    }
    @PostMapping("/protected/aggiungiProdotto/{idProdotto}/{idCarrello}/{quantita}")
    public ResponseEntity<Prodotto> createOrUpdateProdotto(@PathVariable Integer idProdotto, @PathVariable Integer idCarrello, @PathVariable int quantita)
            throws RecordNotFoundException{
        Prodotto updated=prodottoService.importFromCatalogo(idProdotto,idCarrello,quantita);
        float varQuantita=prodottoService.createOrUpdateProdotto(updated);
        carrelloService.updateTotaleCarrelloByIdCarrello(idCarrello,updated.getPrezzo(),varQuantita);
        return new ResponseEntity<Prodotto>(updated, new HttpHeaders(), HttpStatus.OK);
    }



    @DeleteMapping("/protected/{idCarrello}")
    public HttpStatus deleteCarrelloById(@PathVariable("idCarrello")Integer idCarrello)
        throws  RecordNotFoundException{
        carrelloService.deleteCarrelloByIdCarrello(idCarrello);
        return  HttpStatus.FORBIDDEN;
    }

}
