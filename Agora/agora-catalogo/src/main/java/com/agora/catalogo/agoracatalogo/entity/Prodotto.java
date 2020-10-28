package com.agora.catalogo.agoracatalogo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="prodotto")
public class Prodotto {


    @Id
    private Integer id;


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


    public Prodotto(){}
    public Prodotto(Integer id, String nomeProdotto, int prezzo, Integer partitaIva , String descrizione , String immagine){
        super();
        this.id=id;
        this.nomeProdotto=nomeProdotto;
        this.prezzo=prezzo;
        this.partitaIva=partitaIva;
        this.descrizione=descrizione;
        this.immagine=immagine;
    }

    public Integer getId() {
        return id;
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


    public void setId(Integer id) {
        this.id = id;
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


    @Override
    public String toString() {
        return "EmployeeEntity [id= " + id + " , nome prodotto= " +  nomeProdotto +
                " , prezzo= " + prezzo +  "]";
    }
}
