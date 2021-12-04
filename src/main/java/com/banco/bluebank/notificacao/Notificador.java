package com.banco.bluebank.notificacao;

import com.banco.bluebank.model.Correntista;
import org.springframework.stereotype.Component;

public interface Notificador {

    void notificar(Correntista correntista, String mensagem);

}
