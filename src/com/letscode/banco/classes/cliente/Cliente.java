package com.letscode.banco.classes.cliente;

import com.letscode.banco.classes.conta.Conta;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {

    protected String idCliente;
    protected String nome;
    protected List<Conta> contas = new ArrayList<>();

    public Cliente() {

    }

    public Cliente(String idCliente, String nome) {
        this.idCliente = idCliente;
        this.nome = nome;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    @Override
    public String toString() {
        return "Cliente {" +
                "idCliente= " + idCliente +
                ", nome= " + nome +
                ", contas= " + contas +
                "}";
    }


}
