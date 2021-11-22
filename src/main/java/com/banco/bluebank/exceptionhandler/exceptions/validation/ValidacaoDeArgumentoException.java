package com.banco.bluebank.exceptionhandler.exceptions.validation;


import java.util.List;

public class ValidacaoDeArgumentoException {
    private String tipoValidacao;
    private Integer codigoStatus;
    private String motivo;
    private List<CampoErro> campoErros;

    public ValidacaoDeArgumentoException() {
    }

    public ValidacaoDeArgumentoException(String tipoValidacao, Integer codigoStatus, String motivo, List<CampoErro> campoErros) {
        this.tipoValidacao = tipoValidacao;
        this.codigoStatus = codigoStatus;
        this.motivo = motivo;
        this.campoErros = campoErros;
    }

    public String getTipoValidacao() {
        return tipoValidacao;
    }

    public void setTipoValidacao(String tipoValidacao) {
        this.tipoValidacao = tipoValidacao;
    }

    public Integer getCodigoStatus() {
        return codigoStatus;
    }

    public void setCodigoStatus(Integer codigoStatus) {
        this.codigoStatus = codigoStatus;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public List<CampoErro> getCampoErros() {
        return campoErros;
    }

    public void setCampoErros(List<CampoErro> campoErros) {
        this.campoErros = campoErros;
    }
}