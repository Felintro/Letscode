package com.letscode.banco.classes.cliente;

public class ClientePessoaFisica extends Cliente {

    public ClientePessoaFisica() {
        super();
    }

    public ClientePessoaFisica(String idCliente, String nome) {
        super(idCliente, nome);
    }

    @Override
    public String toString() {
        return "ClientePessoaFisica {" +
                "idCliente= " + idCliente +
                ", nome= " + nome +
                ", contas= " + contas +
                "}";
    }
}