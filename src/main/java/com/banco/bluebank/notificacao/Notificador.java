package com.banco.bluebank.notificacao;

import com.banco.bluebank.model.Correntista;

public interface Notificador {

    void notificar(Correntista correntista, String mensagem);

}
