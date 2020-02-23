package com.example.demo.dto;

public class PaysDTO extends AbstractDTO<String> {

    private String libelle;

    private PaysDTO subPays;

    public PaysDTO() {
        super();
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public PaysDTO getSubPays() {
        return subPays;
    }

    public void setSubPays(PaysDTO subPays) {
        this.subPays = subPays;
    }
}
