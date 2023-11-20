package com.crud_es.demo.model;

import java.time.LocalDate;
import java.util.List;

import com.crud_es.demo.model.endereco.EnderecoModel;
import com.crud_es.demo.model.enuns.Genero;
import com.crud_es.demo.model.enuns.StatusCliente;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonValue;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class UserModel extends EntidadeDominioModel {

    public UserModel() {
        super();
    }

    @Column(nullable = true, length = 50)
    private String nomeCliente;

    
    @Enumerated(EnumType.STRING)
    @Column(nullable = true, length = 9)
    private Genero generoCliente;

    @Column(nullable = true, length = 8)
    @Temporal(TemporalType.DATE)
    private LocalDate dataNascimentoCliente;

    @Column(nullable = true, length = 11)
    private String cpfCliente;

    @Column(nullable = true, length = 50)
    private String emailCliente;

    @Column(nullable = true, length = 50)
    private String senhaCliente1;

    @Column(nullable = true, length = 50)
    private String senhaCliente2;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private StatusCliente statusCliente;

    @Embedded
    private TelefoneModel telefoneCliente;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<EnderecoModel> enderecosCliente;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<CartaoDeCreditoModel> cartoesCliente;

    public String getNomeCliente() {
        return this.nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Genero getGeneroCliente() {
        return this.generoCliente;
    }

    public void setGeneroCliente(Genero generoCliente) {
        this.generoCliente = generoCliente;
    }

    public LocalDate getDataNascimentoCliente() {
        return this.dataNascimentoCliente;
    }

    public void setDataNascimentoCliente(LocalDate dataNascimentoCliente) {
        this.dataNascimentoCliente = dataNascimentoCliente;
    }

    public String getCpfCliente() {
        return this.cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public TelefoneModel getTelefoneCliente() {
        return this.telefoneCliente;
    }

    public void setTelefoneCliente(TelefoneModel telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getEmailCliente() {
        return this.emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getSenhaCliente1() {
        return this.senhaCliente1;
    }

    public void setSenhaCliente1(String senhaCliente) {
        this.senhaCliente1 = senhaCliente;
    }

    public String getSenhaCliente2() {
        return this.senhaCliente2;
    }

    public void setSenhaCliente2(String senhaCliente) {
        this.senhaCliente2 = senhaCliente;
    }

    public StatusCliente getStatusCliente() {
        return this.statusCliente;
    }

    public void setStatusCliente(StatusCliente statusCliente) {
        this.statusCliente = statusCliente;
    }

    public List<EnderecoModel> getEnderecosCliente() {
        return this.enderecosCliente;
    }

    public void setEnderecosCliente(List<EnderecoModel> enderecosCliente) {
        this.enderecosCliente = enderecosCliente;
    }

    public List<CartaoDeCreditoModel> getCartoesCliente() {
        return this.cartoesCliente;
    }

    public void setCartoesCliente(List<CartaoDeCreditoModel> cartoesCliente) {
        this.cartoesCliente = cartoesCliente;
    }

}
