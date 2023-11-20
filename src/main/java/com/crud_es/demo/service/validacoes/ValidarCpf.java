package com.crud_es.demo.service.validacoes;

import com.crud_es.demo.model.EntidadeDominioModel;
import com.crud_es.demo.model.UserModel;
import com.crud_es.demo.service.interfaces.IStrategy;

public class ValidarCpf implements IStrategy {

    @Override
    public boolean processar(EntidadeDominioModel entidadeDominio) {
        if (entidadeDominio instanceof UserModel) {
            UserModel usuario = (UserModel) entidadeDominio; 
            return validarCPF(usuario.getCpfCliente());
        } else {
            return false;
        }
    }

    private boolean validarCPF(String cpf) {
        cpf = cpf.replaceAll("\\D", ""); 

        if (!cpf.matches("\\d{11}") || cpf.matches(cpf.charAt(0) + "{11}")) {
            return false;
        }

        return verificarDigitos(cpf);
    }

    private boolean verificarDigitos(String cpf) {
        int d1 = calcularDigito(cpf.substring(0, 9), new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2});
        int d2 = calcularDigito(cpf.substring(0, 9) + d1, new int[]{11, 10, 9, 8, 7, 6, 5, 4, 3, 2});

        return cpf.equals(cpf.substring(0, 9) + d1 + d2);
    }

    private int calcularDigito(String str, int[] pesos) {
        int soma = 0;
        for (int i = 0; i < str.length(); i++) {
            int digito = Integer.parseInt(str.substring(i, i + 1));
            soma += digito * pesos[i];
        }
        int resto = soma % 11;
        return resto < 2 ? 0 : 11 - resto;
    }
}
