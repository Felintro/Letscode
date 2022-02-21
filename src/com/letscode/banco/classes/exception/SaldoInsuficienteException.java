package com.letscode.banco.classes.exception;

public class SaldoInsuficienteException extends RuntimeException {

    public SaldoInsuficienteException(Throwable t) {
        super(t);
    }

    public SaldoInsuficienteException() {
        super("Saldo insuficiente para efetuar a transação!");
    }

}
