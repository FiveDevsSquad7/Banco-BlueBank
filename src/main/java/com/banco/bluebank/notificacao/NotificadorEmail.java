package com.banco.bluebank.notificacao;

import com.banco.bluebank.model.Correntista;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class NotificadorEmail implements Notificador {

    HtmlEmail email = new HtmlEmail();

    @Value("${bluebank.emailpassword}")
    private String emailPassword;


    @Override
    public void notificar(Correntista correntista, String mensagem) {


        try {



            File file1=new File("");
            List<File> files=new ArrayList<>();
            files.add(file1);

            if (correntista.getEmailValidacao() != null && files.size() > 0) {

                //sending one or more attachments
                EmailAttachment attachment = new EmailAttachment();
                attachment.setDisposition(EmailAttachment.ATTACHMENT);

                //for each in files
                for(File fileIn:files){
                    if(fileIn != null && fileIn.isFile()){
                        int indexOfExtension=fileIn.getName().indexOf(".");
                        indexOfExtension=indexOfExtension == -1 ? 0 :indexOfExtension;
                        attachment.setDescription(fileIn.getName().substring(indexOfExtension));//extenção
                        attachment.setName(fileIn.getName());
                        attachment.setURL(fileIn.toURI().toURL());//set file local, convert in URL
                        email.attach(attachment);
                    }
                }

                //show log
                email.setDebug(true);
                //set port
                email.setSmtpPort(587);
                //check this rules for security
                email.setStartTLSEnabled(true);
                //email.setSSLCheckServerIdentity(true);

                email.setHostName("smtp.gmail.com");//server SMTP for Hotmail, alter other
                email.setAuthentication("fivedevssq7@gmail.com", emailPassword);
                email.setFrom("fivedevssq7@gmail.com", "BlueBank 6Devs");

                email.addTo(correntista.getEmailValidacao());
                email.setSubject("BlueBank 6Devs - Notificação de movimentação em conta bancária");
                String texto = String.format(" %s da conta cujo numero %s houve movimentacao ",
                        correntista.getNome(), mensagem);
                email.setTextMsg(texto);

                String cid = email.embed(new File("resources\\static\\image\\logo-6devs.png"));
                //javaMailSender.send(simpleMailMessage);

                String txtHtml =
                        "<html>"
                                + "Prezado Cliente<br><br>Primando qualidade em seguranca, julga-se necessario que Sr(a):<br><br>" +
                                "O(a) gestor"+texto
                                + "<br><br>Estamos a sua disposicao para maiores esclarecimentos por meio do email fivedevssq7@gmail.com ou se preferir entre em contato com o gerente da sua conta!"
                                + " <br><br><br><br>Atenciosamente, BlueBank 6Devs.<br><br><br><br>"
                                + "<a href=\"https://bluebank.6devs.com.br\">"
                                + "<img src=\"cid:"+cid+ "style=\"width:30000px;height:20000px;\">"
                                + "</a>"
                                + "</html>";
                // set the html message
                email.setHtmlMsg(txtHtml);
                // send the email
                email.send();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}