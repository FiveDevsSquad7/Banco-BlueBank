package com.banco.bluebank.notificacao;

import com.banco.bluebank.model.Correntista;
import com.nimbusds.jose.shaded.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class NotificadorSMS implements Notificador {

    @Override
    public void notificar(Correntista correntista, String mensagem) {
        if (correntista.getSms() != null ) {
            if(correntista.getSms().charAt(0) == '+') {

                System.out.printf("Notificando %s por SMS através do telefone %s: %s\n",
                        correntista.getNome(), correntista.getSms(), mensagem);

                post(correntista, mensagem);

            }

        }
    }

    private void post(Correntista correntista,String mensagem) {
        String url = "https://dd1bo43607.execute-api.us-east-2.amazonaws.com/notify";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        JSONObject json = new JSONObject();
        json.put("message", "[" +correntista.getSms()+"]"+mensagem.trim());

        HttpEntity<String> httpEntity = new HttpEntity <String> (json.toString(), httpHeaders);
        RestTemplate restTemplate = new RestTemplate();

        String response = restTemplate.postForObject(url, httpEntity, String.class);

        System.out.println(response.toString());

    }
}
