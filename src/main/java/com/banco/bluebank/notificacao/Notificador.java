package com.banco.bluebank.notificacao;

import com.banco.bluebank.model.Correntista;

import javax.mail.MessagingException;

public interface Notificador {

    void notificar(Correntista correntista, String mensagem) throws ClassNotFoundException, MessagingException;

}
