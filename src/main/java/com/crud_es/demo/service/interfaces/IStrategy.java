package com.crud_es.demo.service.interfaces;

import com.crud_es.demo.model.EntidadeDominioModel;

public interface IStrategy {
    
    public boolean processar(EntidadeDominioModel entidadeDominio);

}
