package com.example.demo.dto;

public class PaysDTO extends AbstractDto<String> {

    private String libelle;

    public PaysDTO() {
        super();
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return this.libelle;
    }
}
