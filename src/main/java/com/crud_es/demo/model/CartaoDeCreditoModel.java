package com.crud_es.demo.model;

import com.crud_es.demo.model.enuns.BandeirasCartaoDeCredito;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CartaoDeCreditoModel extends EntidadeDominioModel {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    @Column(nullable = true, length = 50)
    private String numeroCartao;

    @Column(nullable = true, length = 50)
    private String nomeTitularCartao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private BandeirasCartaoDeCredito bandeiraCartao;

    @Column(nullable = true)
    private Boolean preferencial;

    @Column(nullable = true, length = 50)
    private String codigoSegurancaCartao;

    public String getNumeroCartao() {
        return this.numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getNomeTitularCartao() {
        return this.nomeTitularCartao;
    }

    public void setNomeTitularCartao(String nomeTitularCartao) {
        this.nomeTitularCartao = nomeTitularCartao;
    }

    public BandeirasCartaoDeCredito getBandeiraCartao() {
        return this.bandeiraCartao;
    }

    public void setBandeiraCartao(BandeirasCartaoDeCredito bandeiraCartao) {
        this.bandeiraCartao = bandeiraCartao;
    }

    public boolean getPreferencial() {
        return this.preferencial;
    }

    public void setPreferencial(boolean preferencial) {
        this.preferencial = preferencial;
    }

    public String getCodigoSegurancaCartao() {
        return this.codigoSegurancaCartao;
    }

    public void setCodigoSegurancaCartao(String codigoSegurancaCartao) {
        this.codigoSegurancaCartao = codigoSegurancaCartao;
    }

    public UserModel getUser() {
        return this.user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
