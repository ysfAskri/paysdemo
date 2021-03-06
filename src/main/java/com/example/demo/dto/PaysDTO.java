package com.example.demo.dto;

import com.example.demo.model.Departement;
import com.example.demo.model.Pays;

import java.util.List;

public class PaysDTO extends AbstractDTO<String> {
    private String id;
    private String libelle;
    private Pays subPays;
    private List<Departement> departementList;

    public PaysDTO() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Pays getSubPays() {
        return this.subPays;
    }

    public void setSubPays(Pays subPays) {
        this.subPays = subPays;
    }

    public java.util.List<com.example.demo.model.Departement> getDepartementList() {
        return this.departementList;
    }

    public void setDepartementList(java.util.List<com.example.demo.model.Departement> departementList) {
        this.departementList = departementList;
    }
}
