package com.banco.bluebank.security;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

public @interface CheckSecurity {

    public @interface Agencias {

        @PreAuthorize("hasAuthority('ADMIN')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeEditar { }

        @PreAuthorize("hasAuthority('ADMIN')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeConsultar { }

    }

    public @interface Contas {

        @PreAuthorize("hasAuthority('ADMIN')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeEditar { }

        @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CUSTOMER')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeConsultar { }

        @PreAuthorize("hasAuthority('ADMIN') or (hasAuthority('CUSTOMER') and @sysSecurity.proprioExtrato(#id))")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeConsultarExtrato { }

    }

    public @interface Correntistas {

        @PreAuthorize("hasAuthority('ADMIN')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeEditar { }

        @PreAuthorize("hasAuthority('ADMIN')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeConsultar { }

    }

    public @interface Movimentacoes {

        @PreAuthorize("hasAuthority('ADMIN') or (hasAuthority('CUSTOMER') and @sysSecurity.propriaContaDeDebito(#movimentacao))")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeTransferir { }

        @PreAuthorize("hasAuthority('ADMIN') or (hasAuthority('CUSTOMER') and @sysSecurity.propriaContaSaque(#movimentacaoInput))")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeSacar { }

        @PreAuthorize("hasAuthority('ADMIN')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeConsultar { }

        @PreAuthorize("hasAuthority('ADMIN')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeDepositar { }

    }

}
