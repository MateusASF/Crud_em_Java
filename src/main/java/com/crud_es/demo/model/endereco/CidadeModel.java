package com.crud_es.demo.model.endereco;

import jakarta.persistence.Embeddable;

@Embeddable
public class CidadeModel{

    
    private String nomeCidade;

    public CidadeModel(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public CidadeModel() {
    }

    public String getNomeCidade() {
        return this.nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }
}
