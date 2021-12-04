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
            String texto = String.format("Notificando %s através do e-mail %s: %s\n",
                    correntista.getNome(), correntista.getEmailValidacao(), mensagem);
            simpleMailMessage.setText(texto);
            simpleMailMessage.setSubject("Notificação referente conta");
            javaMailSender.send(simpleMailMessage);

            System.out.println(texto);
        }
    }
}
