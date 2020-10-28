package com.agora.carrello.agoracarrello.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="prodotto")
public class Prodotto {

    @Id
    private Integer id;

    @Column(name = "idProdotto")
    private Integer idProdotto;
    @Column(name = "idCarrello")
    private Integer idCarrello;
    @Column (name = "nomeProdotto")
    private String nomeProdotto;
    @Column (name = "prezzo")
    private int prezzo;
    @Column (name = "partitaIva")
    private Integer partitaIva;
    @Column (name = "descrizione")
    private String descrizione;
    @Column (name = "immagine")
    private  String immagine;
    @Column (name="quantita")
    private int quantita;

    public Prodotto(){}
    public Prodotto(Integer id,Integer idProdotto, Integer idCarrello, String nomeProdotto, int prezzo, Integer partitaIva , String descrizione , String immagine,int quantita){
        super();
        this.id=id;
        this.idProdotto=idProdotto;
        this.idCarrello=idCarrello;
        this.nomeProdotto=nomeProdotto;
        this.prezzo=prezzo;
        this.partitaIva=partitaIva;
        this.descrizione=descrizione;
        this.immagine=immagine;
        this.quantita=quantita;

    }

    public Integer getId() {
        return id;
    }
    public Integer getIdProdotto() {
        return idProdotto;
    }
    public Integer getIdCarrello() {
        return idCarrello;
    }
    public String getNomeProdotto() {
        return nomeProdotto;
    }
    public int getPrezzo() {
        return prezzo;
    }
    public Integer getPartitaIva() {
        return partitaIva;
    }
    public String getDescrizione() {
        return descrizione;
    }
    public String getImmagine() {
        return immagine;
    }
    public int getQuantita() {
        return quantita;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setIdProdotto(Integer idProdotto) {
        this.idProdotto = idProdotto;
    }
    public void setIdCarrello(Integer idCarrello) {
        this.idCarrello = idCarrello;
    }
    public void setNomeProdotto(String nomeProdotto) {
        this.nomeProdotto = nomeProdotto;
    }
    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }
    public void setPartitaIva(Integer partitaIva) {
        this.partitaIva = partitaIva;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }
    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }


    @Override
    public String toString() {
        return "EmployeeEntity [id= " + id + " , nome prodotto= " +  nomeProdotto +
                " , prezzo= " + prezzo +  "]";
    }
}
