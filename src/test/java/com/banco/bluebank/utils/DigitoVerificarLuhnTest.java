package com.banco.bluebank.utils;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Component
public class DigitoVerificarLuhnTest {

    @Test
    public void VerificaCalculoDigitoVerificador() {

        DigitoVerificadorLuhn dv = new DigitoVerificadorLuhn();
        Long[] numerosSemDigito = new Long[] {1L,2L,3L,4L,5L};
        Long[] respostasEsperadas = new Long[] {18L,26L,34L,42L,59L};

        Long numeroComDigito,numeroSemDigito;
        for(int i=0;i<=numerosSemDigito.length-1;i++){
            numeroSemDigito = numerosSemDigito[i];
            numeroComDigito = Long.parseLong(numeroSemDigito.toString() +
                    dv.calculaDigitoVerificador(numeroSemDigito.toString()));
            Assert.assertEquals(numeroComDigito, respostasEsperadas[i]);
        }

    }
}
