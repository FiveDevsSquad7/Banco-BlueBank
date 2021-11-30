package com.banco.bluebank.notificacao;

import com.banco.bluebank.model.Correntista;
import org.springframework.stereotype.Component;

@Component
public class NotificadorSMS implements Notificador {

    @Override
    public void notificar(Correntista correntista, String mensagem) {
        if (correntista.getSms() != null) {
            System.out.printf("Notificando %s por SMS através do telefone %s: %s\n",
                    correntista.getNome(), correntista.getSms(), mensagem);
        }
    }
}
