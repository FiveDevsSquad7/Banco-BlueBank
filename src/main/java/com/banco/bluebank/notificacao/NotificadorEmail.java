package com.banco.bluebank.notificacao;

import com.banco.bluebank.model.Correntista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class NotificadorEmail implements Notificador {

    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public void notificar(Correntista correntista, String mensagem) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        if (correntista.getEmailValidacao() != null) {

            simpleMailMessage.setTo(correntista.getEmailValidacao());
            simpleMailMessage.setSubject("BlueBank 6Devs - Notificação de movimentação em conta bancária");
            String texto = String.format("Prezado(a) %s,\n\nPor motivo de segurança informamos que: %s\n",
                    correntista.getNome(), mensagem);
            simpleMailMessage.setText(texto);
            javaMailSender.send(simpleMailMessage);

        }
    }
}