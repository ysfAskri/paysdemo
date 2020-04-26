package com.example.demo.builder;

import com.example.demo.dto.PaysDTO;
import com.example.demo.model.Pays;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class PaysBuilder {

    public static List<PaysDTO> getListDTO() {
        List<PaysDTO> paysDTOS = new ArrayList<>();
        paysDTOS.add(getDTO());
        paysDTOS.add(getDTO());
        return paysDTOS;
    }

    public static List<Pays> getListEntities() {
        List<Pays> paysList = new ArrayList<>();
        paysList.add(getEntity());
        paysList.add(getEntity());
        return paysList;
    }

    public static PaysDTO getDTO() {
        PaysDTO paysDTO = new PaysDTO();
        paysDTO.setId("1");
        paysDTO.setLibelle("Tun");
        paysDTO.setSubPays(new Pays());
        paysDTO.setDepartementList(Lists.newArrayList());

        return paysDTO;
    }

    public static Pays getEntity() {
        Pays pays = new Pays();
        pays.setId("1");
        pays.setLibelle("Tun");
        pays.setSubPays(new Pays());
        pays.setDepartementList(Lists.newArrayList());

        return pays;
    }
}
