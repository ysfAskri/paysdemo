package com.example.demo.dto;

public class DepartementDTO extends AbstractDTO<Long> {
    private long id;
    private String nom;

    public DepartementDTO() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
