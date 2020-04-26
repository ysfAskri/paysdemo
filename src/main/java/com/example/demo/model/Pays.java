package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pays implements AbstractEntity<String> {
    @Id
    private String id;

    private String libelle;

    @OneToOne(cascade = CascadeType.ALL)
    private Pays subPays;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Departement> departementList;

    @Override
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

    public List<Departement> getDepartementList() {
        return departementList;
    }

    public void setDepartementList(List<Departement> departementList) {
        this.departementList = departementList;
    }
}
