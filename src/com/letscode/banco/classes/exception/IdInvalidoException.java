package com.letscode.banco.classes.exception;

public class IdInvalidoException extends RuntimeException {

    public IdInvalidoException(Throwable t) {
        super(t);
    }

    public IdInvalidoException() {
        super("O ID informado é inválido!");
    }

}
