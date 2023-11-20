package com.crud_es.demo.service.validacoes;

import java.util.regex.Pattern;

import com.crud_es.demo.model.EntidadeDominioModel;
import com.crud_es.demo.model.UserModel;
import com.crud_es.demo.service.interfaces.IStrategy;

public class ValidaSenha implements IStrategy {

    @Override
    public boolean processar(EntidadeDominioModel entidadeDominio) {
        if (entidadeDominio instanceof UserModel) {
            UserModel usuario = (UserModel) entidadeDominio; 
            return validarSenha(usuario.getSenhaCliente1(), usuario.getSenhaCliente2());
        } else {
            return false;
        }
    }


    public static boolean validarSenha(String senha1, String senha2) {
        if (!senha1.equals(senha2)) {
            return false;
        }

        if (senha1.length() < 8) {
            return false;
        }

        // Regex para verificar a presença de pelo menos uma letra maiúscula, uma minúscula e um caractere especial.
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[^a-zA-Z0-9]).+$";

        return Pattern.matches(regex, senha1);
    }
}
