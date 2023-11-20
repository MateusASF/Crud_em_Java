package com.crud_es.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.crud_es.demo.model.EntidadeDominioModel;
import com.crud_es.demo.service.interfaces.IStrategy;
import com.crud_es.demo.service.validacoes.GerarLog;
import com.crud_es.demo.service.validacoes.ValidaSenha;
import com.crud_es.demo.service.validacoes.ValidarCpf;

public class FachadaService {
    private List<IStrategy> estrategiasDeValidacao;

    public FachadaService() {
        estrategiasDeValidacao = new ArrayList<>();
        estrategiasDeValidacao.add(new ValidarCpf());
        estrategiasDeValidacao.add(new GerarLog());
        estrategiasDeValidacao.add(new ValidaSenha());
    }

    public boolean salvar(EntidadeDominioModel entidade) {
        boolean validacaoSucesso = true;
        
        for (IStrategy estrategia : estrategiasDeValidacao) {
            boolean resultado = estrategia.processar(entidade);
            if (!resultado) {
                validacaoSucesso = false;
            }
        }

        return validacaoSucesso;
    }
}