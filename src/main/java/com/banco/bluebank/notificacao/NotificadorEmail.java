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
            simpleMailMessage.setSubject("Esse email automático informa movimentação na conta atrelada a essa conta de e-mail");
            String texto = String.format("Prezado(a) %s ,\n\n Conforme nosso cadstro, informa por meio desse %s (PREVIAMENTE CERTICADO!) que: %s\n",
                    correntista.getNome(), correntista.getEmailValidacao(), mensagem);
            simpleMailMessage.setText(texto);
            javaMailSender.send(simpleMailMessage);

            System.out.println(texto);
        }
    }
}