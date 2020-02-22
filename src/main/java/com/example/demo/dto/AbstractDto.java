package com.example.demo.dto;

public abstract class AbstractDto <D>{

    private D id;

    public D getId() {
        return id;
    }

    public void setId(D id) {
        this.id = id;
    }
}
