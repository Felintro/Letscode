package com.letscode.banco.classes.cliente;

import java.math.BigDecimal;

public class ClientePessoaJuridica extends Cliente{

    public ClientePessoaJuridica() {
        super();
    }

    public ClientePessoaJuridica(String idCliente, String nome) {
        super(idCliente, nome);
    }

    @Override
    public String toString() {
        return "ClientePessoaJuridica {" +
                "idCliente= " + idCliente +
                ", nome= " + nome +
                ", contas= " + contas +
                "}";
    }
}