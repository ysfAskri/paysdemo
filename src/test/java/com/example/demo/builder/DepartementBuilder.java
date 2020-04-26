package com.example.demo.builder;

import com.example.demo.dto.DepartementDTO;
import com.example.demo.model.Departement;

import java.util.ArrayList;
import java.util.List;

public class DepartementBuilder {
    public static List<DepartementDTO> getListDTO() {
        List<DepartementDTO> departementDTOS = new ArrayList<>();

        departementDTOS.add(getDTO());
        departementDTOS.add(getDTO());
        return departementDTOS;
    }

    public static DepartementDTO getDTO() {
        DepartementDTO departementDTO = new DepartementDTO();
        departementDTO.setId(1L);
        departementDTO.setNom("PH");

        return departementDTO;
    }

    public static List<Departement> getListEntities() {
        List<Departement> departements = new ArrayList<>();

        departements.add(getEntity());
        departements.add(getEntity());
        return departements;
    }

    public static Departement getEntity() {
        Departement departement = new Departement();
        departement.setId(1L);
        departement.setNom("PH");

        return departement;
    }
}
