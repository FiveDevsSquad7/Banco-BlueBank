package com.banco.bluebank.service;

import com.banco.bluebank.model.Correntista;
import com.banco.bluebank.notificacao.Notificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class NotificacaoCorrentistaService {

    @Autowired
    private List<Notificador> notificadores;

    public void notificar(Correntista correntista, BigDecimal valor) {

        for (Notificador notificador : notificadores) {
            notificador.notificar(correntista, String.format("Sua conta acabou de sofrer uma movimentacao no valor de %f",valor));
        }

    }
}
