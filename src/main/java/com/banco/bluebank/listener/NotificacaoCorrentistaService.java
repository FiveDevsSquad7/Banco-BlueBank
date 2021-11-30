package com.banco.bluebank.listener;

import com.banco.bluebank.model.Correntista;
import com.banco.bluebank.notificacao.Notificador;
import com.banco.bluebank.service.MovimentacaoRealizadaEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class NotificacaoCorrentistaService {

    @Autowired
    private List<Notificador> notificadores;

    @EventListener
    public void movimentacaoRealizadaListener(MovimentacaoRealizadaEvent event) {

        for (Notificador notificador : notificadores) {
            notificador.notificar(event.getMovimentacao().getContaDebito().getCorrentista(),
                    String.format("Sua conta acabou de sofrer uma movimentacao no valor de %f",event.getMovimentacao().getValor()));
            notificador.notificar(event.getMovimentacao().getContaCredito().getCorrentista(),
                    String.format("Sua conta acabou de sofrer uma movimentacao no valor de %f",event.getMovimentacao().getValor()));
        }

    }
}
