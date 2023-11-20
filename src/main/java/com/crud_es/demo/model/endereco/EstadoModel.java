package com.crud_es.demo.model.endereco;

import jakarta.persistence.Embeddable;

@Embeddable
public class EstadoModel  {

    private String nomeEstado;

    public String getNomeEstado() {
        return this.nomeEstado;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

}
