package br.com.unipac.protocolorestapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Recurso já existe")
public class ResourceAlreadyExistsException extends Exception {

    public ResourceAlreadyExistsException() {
    }

    public ResourceAlreadyExistsException(String message) {
        super(message);
    }
}
