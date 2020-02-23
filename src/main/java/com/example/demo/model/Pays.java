package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pays {
    @Id
    private String id;

    private String libelle;

    @OneToOne(cascade = CascadeType.ALL)
    private Pays subPays;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Pays getSubPays() {
        return subPays;
    }

    public void setSubPays(Pays subPays) {
        this.subPays = subPays;
    }
}
