package com.crud_es.demo.model;

import com.crud_es.demo.model.enuns.TipoTelefone;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class TelefoneModel {

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private TipoTelefone tipoTelefone;

    @Column(nullable = true, length = 3)
    private String ddi;

    @Column(nullable = true, length = 2)
    private String ddd;

    @Column(nullable = true, length = 9)
    private String numero;

    public TipoTelefone getTipoTelefone() {
        return this.tipoTelefone;
    }

    public void setTipoTelefone(TipoTelefone tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public String getDdi() {
        return this.ddi;
    }

    public void setDdi(String ddi) {
        this.ddi = ddi;
    }

    public String getDdd() {
        return this.ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
