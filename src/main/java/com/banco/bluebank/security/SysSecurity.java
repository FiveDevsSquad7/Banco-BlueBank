package com.banco.bluebank.security;

import com.banco.bluebank.model.Movimentacao;
import com.banco.bluebank.model.MovimentacaoInput;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Component
public class SysSecurity {

    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public String getUsuario() {
        Jwt jwt = (Jwt) getAuthentication().getPrincipal();

        String username = jwt.getClaim("user_name");

        return username.substring(0, username.length() - 1 );
    }

    public String getUsuarioOriginal() {
        Jwt jwt = (Jwt) getAuthentication().getPrincipal();

        return jwt.getClaim("user_name");

    }

    public boolean proprioExtrato(Long numeroConta) {
        return numeroConta == Long.parseLong(getUsuarioOriginal());
    }

    public boolean propriaContaDeDebito(Movimentacao movimentacao) {
        return movimentacao.getNumeroContaDebito() == Long.parseLong(getUsuarioOriginal());
    }

    public boolean propriaContaSaque(MovimentacaoInput movimentacaoInput) {
        return movimentacaoInput.getNumeroConta() == Long.parseLong(getUsuarioOriginal());
    }
}

