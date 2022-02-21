package com.letscode.banco.classes.exception;

public class ClienteJaCadastradoException extends RuntimeException {

    public ClienteJaCadastradoException(Throwable t) {
        super(t);
    }

    public ClienteJaCadastradoException() {
        super("Cliente já está cadastrado!");
    }
}
