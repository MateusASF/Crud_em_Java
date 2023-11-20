package com.crud_es.demo.model.endereco;

import com.crud_es.demo.model.EntidadeDominioModel;
import com.crud_es.demo.model.UserModel;
import com.crud_es.demo.model.enuns.TipoEndereco;
import com.crud_es.demo.model.enuns.TipoLogradouro;
import com.crud_es.demo.model.enuns.TipoResidencia;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class EnderecoModel extends EntidadeDominioModel {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private UserModel user;

    @Column(nullable = true, length = 30)
    private String nomeEndereco;

    @Column(nullable = true, length = 5)
    private String numero;

    @Column(nullable = true, length = 50)
    private String complemento;

    @Column(nullable = true, length = 50)
    private String bairro;

    @Column(nullable = true, length = 10)
    private String cep;

    @Embedded
    private PaisModel pais;

    @Embedded
    private EstadoModel estado;

    @Embedded
    private CidadeModel cidade;

    @Column(nullable = true, length = 50)
    private String observacao;

    @Column(nullable = true, length = 50)
    private TipoEndereco tipoEndereco;

    @Column(nullable = true, length = 50)
    private TipoResidencia tipoResidencia;

    @Column(nullable = true, length = 50)
    private TipoLogradouro tipoLogradouro;

    @Column(nullable = true, length = 50)
    private String logradouro;

    public UserModel getUser() {
        return this.user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public String getNomeEndereco() {
        return this.nomeEndereco;
    }

    public void setNomeEndereco(String nomeEndereco) {
        this.nomeEndereco = nomeEndereco;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return this.complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public PaisModel getPais() {
        return this.pais;
    }

    public void setPais(PaisModel pais) {
        this.pais = pais;
    }

    public EstadoModel getEstado() {
        return this.estado;
    }

    public void setEstado(EstadoModel estado) {
        this.estado = estado;
    }

    public CidadeModel getCidade() {
        return this.cidade;
    }

    public void setCidade(CidadeModel cidade) {
        this.cidade = cidade;
    }

    public String getObservacao() {
        return this.observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public TipoEndereco getTipoEndereco() {
        return this.tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public TipoResidencia getTipoResidencia() {
        return this.tipoResidencia;
    }

    public void setTipoResidencia(TipoResidencia tipoResidencia) {
        this.tipoResidencia = tipoResidencia;
    }

    public TipoLogradouro getTipoLogradouro() {
        return this.tipoLogradouro;
    }

    public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getLogradouro() {
        return this.logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
}
