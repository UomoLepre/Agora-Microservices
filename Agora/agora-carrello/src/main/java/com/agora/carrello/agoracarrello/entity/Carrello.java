package com.agora.carrello.agoracarrello.entity;

import javax.persistence.*;
import java.util.Iterator;
import java.util.List;

@Entity
@Table(name = "carrello")
public class Carrello {

    @Id
    private Integer idCarrello;

    @ManyToMany (targetEntity = Prodotto.class, mappedBy = "idCarrello", fetch = FetchType.EAGER)
    private List<Prodotto> carrelloProdotti;

    @Column (name = "idUtente")
    private Integer idUtente;
    @Column (name = "totaleCarrello")
    private int totaleCarrello;


    public Carrello(){}
    public Carrello(Integer idCarrello, Integer idUtente, List<Prodotto> carrelloProdotti, int totaleCarrello){
        super();
        this.idCarrello=idCarrello;
        this.idUtente=idUtente;
        this.carrelloProdotti=carrelloProdotti;
        this.totaleCarrello=totaleCarrello;
    }

    public int getTotaleCarrello() {
        return totaleCarrello;
    }
    public Integer getIdCarrello() {
        return idCarrello;
    }
    public Integer getIdUtente() {
        return idUtente;
    }
    public List<Prodotto> getCarrelloProdotti() {
        return carrelloProdotti;
    }

    public void setCarrelloProdotti(List<Prodotto> carrelloProdotti) {
        this.carrelloProdotti = carrelloProdotti;
    }
    public void setIdCarrello(Integer idCarrello) {
        this.idCarrello = idCarrello;
    }
    public void setIdUtente(Integer idUtente) {
        this.idUtente = idUtente;
    }
    public void setTotaleCarrello(int totaleCarrello) {
        this.totaleCarrello = totaleCarrello;
    }

    @Override
    public String toString() {
        return "EmployeeEntity [idCarrello= " + idCarrello + " , idUtente= " +  idUtente +
                " , totaleCarrello= " + totaleCarrello +  "]";
    }
}
