package com.agora.catalogo.agoracatalogo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="store")
public class Store {

    @Id
    private Integer partitaIva;


    @OneToMany(targetEntity = Prodotto.class, mappedBy = "partitaIva", fetch = FetchType.EAGER)
    private List<Prodotto> prodotti ;


    @Column (name = "nomeStore")
    private String nomeStore;
    @Column (name = "categoria")
    private String categoria;
    @Column (name = "descrizione")
    private String descrizione;
    @Column (name = "immagine")
    private  String immagine;


    public Store(){}
    public Store(Integer partitaIva, String nomeStore, String categoria, String descrizione, String immagine){
        super();
        this.partitaIva=partitaIva;
        this.nomeStore=nomeStore;
        this.categoria=categoria;
        this.descrizione=descrizione;
        this.immagine=immagine;
    }


    public Integer getPartitaIva() {
        return partitaIva;
    }
    public List<Prodotto> getProdotti() {
        return prodotti;
    }
    public String getNomeStore() {
        return nomeStore;
    }
    public String getCategoria() {
        return categoria;
    }
    public String getDescrizione() {
        return descrizione;
    }
    public String getImmagine() {
        return immagine;
    }


    public void setPartitaIva(Integer partitaIva) {
        this.partitaIva = partitaIva;
    }
    public void setProdotti(List<Prodotto> prodotti) {
        this.prodotti = prodotti;
    }
    public void setNomeStore(String nomeStore) {
        this.nomeStore = nomeStore;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }


    @Override
    public String toString() {
        return "EmployeeEntity [partitaIva= " + partitaIva + " , nome Store= " +  nomeStore +
                " , Categoria= " + categoria +  "]";
    }
}
