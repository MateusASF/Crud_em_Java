package com.crud_es.demo.service.validacoes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.crud_es.demo.model.EntidadeDominioModel;
import com.crud_es.demo.model.UserModel;
import com.crud_es.demo.service.interfaces.IStrategy;

public class GerarLog implements IStrategy {

    @Override
    public boolean processar(EntidadeDominioModel entidadeDominio) {
        if (entidadeDominio instanceof UserModel) {
            UserModel usuario = (UserModel) entidadeDominio; 
            gerarLog(usuario);
            return true;
        } else {
            return false;
        }
    }

    public static void gerarLog(UserModel usuario) {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dataFormatada = agora.format(formatter);

        System.out.println("Log: Cliente '" + usuario.getNomeCliente() + "' acessou em " + dataFormatada);
    }
    
}
