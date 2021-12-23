package com.banco.bluebank.listener;

import com.banco.bluebank.notificacao.NotificadorEmail;
import com.banco.bluebank.notificacao.NotificadorSms;
import com.banco.bluebank.service.MovimentacaoRealizadaEvent;
import com.banco.bluebank.utils.DigitoVerificadorLuhn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;


@Component
public class NotificacaoCorrentistaService {

    @Autowired
    private NotificadorEmail notificadorEmail;

    @Autowired
    private NotificadorSms notificadorSMS;

    @Autowired
    private DigitoVerificadorLuhn dv;

    @Async
    @EventListener
    public void enviarSmsContaDebitoMovimentacaoRealizadaListener(MovimentacaoRealizadaEvent event) {

        notificadorSMS.notificar(event.getMovimentacao().getContaDebito().getCorrentista(),
                String.format("6Devs: Sua conta %d%s sofreu uma movimentação de débito no valor de R$ %.2f.",
                        event.getMovimentacao().getContaDebito().getNumeroConta(),
                        dv.calculaDigitoVerificador(event.getMovimentacao().getContaDebito().getNumeroConta().toString()),
                        event.getMovimentacao().getValor()));

    }

    @Async
    @EventListener
    public void enviarSmsContaCreditoMovimentacaoRealizadaListener(MovimentacaoRealizadaEvent event) {

        notificadorSMS.notificar(event.getMovimentacao().getContaCredito().getCorrentista(),
                String.format("6Devs: Sua conta %d%s sofreu uma movimentação de crédito no valor de R$ %.2f.",
                        event.getMovimentacao().getContaCredito().getNumeroConta(),
                        dv.calculaDigitoVerificador(event.getMovimentacao().getContaCredito().getNumeroConta().toString()),
                        event.getMovimentacao().getValor()));

    }

    @Async
    @EventListener
    public void enviarEmailContaDebitoMovimentacaoRealizadaListener(MovimentacaoRealizadaEvent event) throws ClassNotFoundException, MessagingException {

        notificadorEmail.notificar(event.getMovimentacao().getContaDebito().getCorrentista(),
                String.format("Sua conta %d%s sofreu uma movimentacao de debito no valor de R$ %.2f.",
                        event.getMovimentacao().getContaDebito().getNumeroConta(),
                        dv.calculaDigitoVerificador(event.getMovimentacao().getContaDebito().getNumeroConta().toString()),
                        event.getMovimentacao().getValor()));

    }

    @Async
    @EventListener
    public void enviarEmailContaCreditoMovimentacaoRealizadaListener(MovimentacaoRealizadaEvent event) throws ClassNotFoundException, MessagingException {

        notificadorEmail.notificar(event.getMovimentacao().getContaCredito().getCorrentista(),
                String.format("Sua conta %d%s sofreu uma movimentacao de credito no valor de R$ %.2f.",
                        event.getMovimentacao().getContaCredito().getNumeroConta(),
                        dv.calculaDigitoVerificador(event.getMovimentacao().getContaCredito().getNumeroConta().toString()),
                        event.getMovimentacao().getValor()));

    }
}
