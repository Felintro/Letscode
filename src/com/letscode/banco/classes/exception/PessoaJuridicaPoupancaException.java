package com.letscode.banco.classes.exception;

public class PessoaJuridicaPoupancaException extends RuntimeException {


    public PessoaJuridicaPoupancaException(Throwable t) {
        super(t);
    }

    public PessoaJuridicaPoupancaException() {
        super("Cliente incompatível com a conta do tipo poupança!");
    }
}
