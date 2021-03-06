package com.banco.bluebank.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Properties;


@Component
public class JavaMailSender {

    @Value("${bluebank.emailpassword}")
    private String emailPassword;

    @Bean
    public JavaMailSenderImpl getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.sendgrid.net");
        mailSender.setPort(587);
        mailSender.setUsername("apikey");
        mailSender.setPassword(emailPassword);
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", emailPassword);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.debug", "false");
        mailSender.setJavaMailProperties(props);
        return mailSender;
    }
}
