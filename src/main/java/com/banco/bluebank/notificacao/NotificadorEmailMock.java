package com.banco.bluebank.notificacao;

import com.banco.bluebank.model.Correntista;
import com.banco.bluebank.utils.ContentIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.util.Random;

@Profile("dev")
@Component
public class NotificadorEmailMock implements NotificadorEmail {

    int numero = random().nextInt(9999);
    int emailProtocolo = 1 + numero;

    public static Random random() {
        return new Random();
    }

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void notificar(Correntista correntista, String mensagem) throws ClassNotFoundException, MessagingException {

        if (correntista.getEmailValidacao() == null) return;

        String contentId = ContentIdGenerator.getContentId();

        String htmlText = (
                "Prezado Cliente<br><br>" + correntista.getNome() + "<br><br>O BlueBank 6Devs se preocupa com a seguranca da " +
                        "sua conta e notifica o seguinte:<br><br>" +
                        "<b>" + mensagem + "</b><br><br>" +
                        "Estamos a sua disposicao para maiores esclarecimentos por meio do email bluebank6devs@betiol.dev ou se preferir entre em contato com o gerente da sua conta!\"\n" +
                        "<br><br><br><br>Atenciosamente,<br><br><br><br>" +
                        "<a href=\"https://github.com/FiveDevsSquad7\">BlueBank 6Devs" +
                        "<td style=\"width:114px;padding-top:19px>\"" +
                        "<img src=\"cid:" + contentId + "</td>" +
                        "</a>");

        System.out.println("Notificacão email MOCK:" + htmlText);

    }
}