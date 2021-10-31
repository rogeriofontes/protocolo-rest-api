package br.com.unipac.protocolorestapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type User not found exception.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Erro ao cadastrar usuário")
public class UserException extends Exception {
    private static final long serialVersionUID = -6469007988060422304L;

    /**
     * Instantiates a new User not found exception.
     *
     * @param message the message
     */
    public UserException(String message) {
        super(message);
    }
}
