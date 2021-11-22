package com.banco.bluebank.exceptionhandler.exceptions.agencia;

public class AgenciaVaziaException extends RuntimeException {
    private Integer status = 200;
    private String descricaoStatus = "OK";
    private String tipoDeErro = "Nenhuma agencia cadastrada!";

    public AgenciaVaziaException(String message) {
        super(message);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescricaoStatus() {
        return descricaoStatus;
    }

    public void setDescricaoStatus(String descricaoStatus) {
        this.descricaoStatus = descricaoStatus;
    }

    public String getTipoDeErro() {
        return tipoDeErro;
    }

    public void setTipoDeErro(String tipoDeErro) {
        this.tipoDeErro = tipoDeErro;
    }
}
