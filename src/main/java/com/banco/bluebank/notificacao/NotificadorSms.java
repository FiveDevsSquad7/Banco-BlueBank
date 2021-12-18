package com.banco.bluebank.notificacao;

import com.banco.bluebank.model.Correntista;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

public interface NotificadorSms {

    void notificar(Correntista correntista, String mensagem);

}
