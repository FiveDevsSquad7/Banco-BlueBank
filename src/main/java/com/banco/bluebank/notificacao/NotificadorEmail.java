package com.banco.bluebank.notificacao;

import com.banco.bluebank.model.Correntista;
import com.banco.bluebank.utils.ContentIdGenerator;
import com.sun.istack.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Random;

@Component
public class NotificadorEmail implements Notificador {

    int numero = random().nextInt(9999);
    int emailProtocolo = 1 + numero;

    public static Random random(){
        return new Random();
    }

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void notificar(Correntista correntista, String mensagem) throws ClassNotFoundException, MessagingException {

        String filename = "logo-6devs.png";
        BodyPart image = new MimeBodyPart();
        image.setDisposition(MimeBodyPart.INLINE);
        image.setFileName(filename);
        image.setHeader("Content-ID", "<"+filename+">");

        MimeMessage mimeMessage;
        try {
                InternetAddress from = new InternetAddress("fivedevssq7@gmail.com", "BlueBank 6Devs");

                mimeMessage = javaMailSender.createMimeMessage();
                mimeMessage.setSubject("BlueBank 6Devs - Notificação de movimentação em conta bancária - Protocolo: "+ emailProtocolo);

                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

                helper.setValidateAddresses(!correntista.getEmailValidacao().isEmpty());
                helper.setSentDate(new Date());
                helper.setFrom(from);
                helper.setTo(correntista.getEmailValidacao());

                String contentId = ContentIdGenerator.getContentId();

                String texto = String.format(" %s da conta cujo numero %s  ", correntista.getNome(), mensagem);
                helper.setText(texto);

                String htmlText = (
                        "Prezado Cliente<br><br>Primando qualidade em seguranca, julga-se necessario que Sr(a):<br><br>" +
                        "O(a) gestor"+texto+
                        "<br><br>Estamos a sua disposicao para maiores esclarecimentos por meio do email fivedevssq7@gmail.com ou se preferir entre em contato com o gerente da sua conta!\"\n" +
                        "<br><br><br><br>Atenciosamente,<br><br><br><br> BlueBank 6Devs." +
                        "<a href=\"https://bluebank.6devs.com.br\">"+
                        "<td style=\"width:114px;padding-top:19px>\""+
                        "<img src=\"cid:"+ contentId + "</td>"+
                        "</a>");
                helper.setText(htmlText, true);
                ClassPathResource classPathResource = new ClassPathResource("static\\image\\logo-6devs.png");
                helper.addInline(contentId, classPathResource);
                javaMailSender.send(mimeMessage);

        }
        catch (Exception e) {
            Logger.getLogger(Class.forName(e.getMessage()));
        }
    }
}