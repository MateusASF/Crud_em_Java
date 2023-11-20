package com.crud_es.demo.model.endereco;

import jakarta.persistence.Embeddable;

@Embeddable
public class PaisModel {

    private String nomePais;

    public PaisModel() {
    }

    public PaisModel(String nomePais) {
        this.nomePais = nomePais;
    }

    public String getNomePais() {
        return this.nomePais;
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }
}
