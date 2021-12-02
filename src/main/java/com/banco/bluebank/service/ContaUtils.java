package com.banco.bluebank.service;

import com.banco.bluebank.exceptionhandler.exceptions.DigitoVerificadorInvalidoException;
import com.banco.bluebank.utils.DigitoVerificadorLuhn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContaUtils {

    @Autowired
    private DigitoVerificadorLuhn dv;

    public Long verificaNumeroConta(Long numeroConta) {
        if (! dv.verificaDigitoVerificador(numeroConta.toString())) {
            throw new DigitoVerificadorInvalidoException(numeroConta);
        }
        String stringNumeroConta = numeroConta.toString();
        return Long.parseLong(stringNumeroConta.substring(0, stringNumeroConta.length() - 1));
    }

}
