package com.banco.bluebank.notificacao;

import com.banco.bluebank.model.Correntista;
import org.springframework.stereotype.Component;

@Component
public class NotificadorEmail implements Notificador {

    @Override
    public void notificar(Correntista correntista, String mensagem) {
        if (correntista.getEmailValidacao() != null) {
            System.out.printf("Notificando %s através do e-mail %s: %s\n",
                    correntista.getNome(), correntista.getEmailValidacao(), mensagem);
        }
    }
}
