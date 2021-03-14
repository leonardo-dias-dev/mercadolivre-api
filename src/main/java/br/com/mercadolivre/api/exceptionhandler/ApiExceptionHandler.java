package br.com.mercadolivre.api.exceptionhandler;

import br.com.mercadolivre.core.security.exception.LoginException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(LoginException.class)
    public ResponseEntity<?> loginException(LoginException e, WebRequest request) {
        HttpStatus httpStatus = HttpStatus.UNAUTHORIZED;

        ProblemDetail problemDetail = ProblemDetail.builder()
                .status(httpStatus.value())
                .error(httpStatus.getReasonPhrase())
                .message(e.getMessage())
                .build();

        return handleExceptionInternal(e, problemDetail, new HttpHeaders(), httpStatus, request);
    }

}
