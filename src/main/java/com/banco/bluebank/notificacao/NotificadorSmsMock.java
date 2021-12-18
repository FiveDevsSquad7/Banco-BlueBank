package com.banco.bluebank.notificacao;

import com.banco.bluebank.model.Correntista;
import com.nimbusds.jose.shaded.json.JSONObject;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Profile("dev")
public class NotificadorSmsMock implements NotificadorSms {

    @Override
    public void notificar(Correntista correntista, String mensagem) {
        if (correntista.getSms() != null ) {
            if(correntista.getSms().charAt(0) == '+') {

                System.out.printf("Notificador SMS MOCK: Notificando %s por SMS através do telefone %s: %s\n",
                        correntista.getNome(), correntista.getSms(), mensagem);

            }

        }
    }

}
