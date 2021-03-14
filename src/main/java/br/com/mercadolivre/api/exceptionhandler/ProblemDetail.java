package br.com.mercadolivre.api.exceptionhandler;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProblemDetail {

    private int status;

    private String error;

    private String message;

}
