package com.banco.bluebank.listener;

import com.banco.bluebank.notificacao.NotificadorEmail;
import com.banco.bluebank.notificacao.NotificadorSMS;
import com.banco.bluebank.service.MovimentacaoRealizadaEvent;
import com.banco.bluebank.utils.DigitoVerificadorLuhn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoCorrentistaService {

    @Autowired
    private NotificadorEmail notificadorEmail;

    @Autowired
    private NotificadorSMS notificadorSMS;

    @Autowired
    private DigitoVerificadorLuhn dv;

    @Async
    @EventListener
    public void enviarSmsContaDebitoMovimentacaoRealizadaListener(MovimentacaoRealizadaEvent event) {

        notificadorSMS.notificar(event.getMovimentacao().getContaDebito().getCorrentista(),
                    String.format("Sua conta %d%s acabou de sofrer uma movimentacao no valor de %f",
                            event.getMovimentacao().getContaDebito().getNumeroConta(),
                            dv.calculaDigitoVerificador(event.getMovimentacao().getContaDebito().toString()),
                            event.getMovimentacao().getValor()));

    }

    @Async
    @EventListener
    public void enviarSmsContaCreditoMovimentacaoRealizadaListener(MovimentacaoRealizadaEvent event) {

        notificadorSMS.notificar(event.getMovimentacao().getContaCredito().getCorrentista(),
                String.format("Sua conta %d%s acabou de sofrer uma movimentacao no valor de %f",
                        event.getMovimentacao().getContaCredito().getNumeroConta(),
                        dv.calculaDigitoVerificador(event.getMovimentacao().getContaCredito().toString()),
                        event.getMovimentacao().getValor()));

    }

    @Async
    @EventListener
    public void enviarEmailContaDebitoMovimentacaoRealizadaListener(MovimentacaoRealizadaEvent event) {

        notificadorEmail.notificar(event.getMovimentacao().getContaDebito().getCorrentista(),
                String.format("Sua conta %d%s acabou de sofrer uma movimentacao no valor de %f",
                        event.getMovimentacao().getContaDebito().getNumeroConta(),
                        dv.calculaDigitoVerificador(event.getMovimentacao().getContaDebito().toString()),
                        event.getMovimentacao().getValor()));

    }

    @Async
    @EventListener
    public void enviarEmailContaCreditoMovimentacaoRealizadaListener(MovimentacaoRealizadaEvent event) {

        notificadorEmail.notificar(event.getMovimentacao().getContaCredito().getCorrentista(),
                String.format("Sua conta %d%s acabou de sofrer uma movimentacao no valor de %f",
                        event.getMovimentacao().getContaCredito().getNumeroConta(),
                        dv.calculaDigitoVerificador(event.getMovimentacao().getContaCredito().toString()),
                        event.getMovimentacao().getValor()));

    }

}
