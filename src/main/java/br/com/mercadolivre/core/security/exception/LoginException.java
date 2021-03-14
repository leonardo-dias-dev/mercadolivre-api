package br.com.mercadolivre.core.security.exception;

import org.springframework.security.core.AuthenticationException;

public class LoginException extends AuthenticationException {

    public LoginException(String message) {
        super(message);
    }

}
