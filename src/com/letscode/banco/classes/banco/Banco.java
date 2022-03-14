package com.letscode.banco.classes.banco;

import com.letscode.banco.classes.cliente.Cliente;
import com.letscode.banco.classes.cliente.ClientePessoaFisica;
import com.letscode.banco.classes.cliente.ClientePessoaJuridica;
import com.letscode.banco.classes.conta.Conta;
import com.letscode.banco.classes.conta.ContaCorrente;
import com.letscode.banco.classes.conta.ContaInvestimento;
import com.letscode.banco.classes.conta.ContaPoupanca;
import com.letscode.banco.classes.exception.ClienteJaCadastradoException;
import com.letscode.banco.classes.exception.IdInvalidoException;
import com.letscode.banco.classes.exception.PessoaJuridicaPoupancaException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Banco {

    private List<Cliente> clientesCadastrados = new ArrayList<>();
    private int contadorContas;


    public Banco() {
        System.out.println("Bem-vindo ao banco!");
    }


    public List<Cliente> getClientesCadastrados() {
        return clientesCadastrados;
    }

    public int getContadorContas() {
        return contadorContas;
    }

    public Cliente getClienteById(String idCliente) {
        for (Cliente cliente: clientesCadastrados) {
            if(cliente.getIdCliente().equals(idCliente))
                return cliente;
        }

        throw new IdInvalidoException();

    }

    public Conta getContaById(int nrConta) {
        for (Cliente cliente: clientesCadastrados) {
            for (Conta conta: cliente.getContas()) {
                if(conta.getNrConta() == nrConta)
                    return conta;
            }

        }

        throw new IdInvalidoException();

    }

    public Conta abrirConta(Cliente cliente, int tipoConta, BigDecimal depositoInicial) {

        BigDecimal taxaSaqueTransferencia, rendimento;

        if (cliente instanceof ClientePessoaJuridica) {
            taxaSaqueTransferencia = BigDecimal.valueOf(0.005);
            rendimento = BigDecimal.valueOf(1.04);
        } else {
            taxaSaqueTransferencia = BigDecimal.valueOf(0.0);
            rendimento = BigDecimal.valueOf(1.02);
        }

        Conta conta;

        if(tipoConta == 3) {
            conta = inicializarConta(cliente, tipoConta, depositoInicial, taxaSaqueTransferencia, rendimento);
        } else {
            conta = inicializarConta(cliente, tipoConta, depositoInicial, taxaSaqueTransferencia, BigDecimal.valueOf(0.0));
        }

        contadorContas++;
        cliente.getContas().add(conta);
        return conta;

    }

    public Cliente cadastrarCliente(int tipoCliente, String idCliente, String nome) {

        if(!isClienteCadastrado(idCliente)) {

            Cliente cliente = new ClientePessoaFisica();

            switch (tipoCliente) {
                case 1:
                    cliente = new ClientePessoaFisica(idCliente, nome);
                    break;

                case 2:
                    cliente = new ClientePessoaJuridica(idCliente, nome);
                    break;
            }

            clientesCadastrados.add(cliente);
            return cliente;

        } else
            throw new ClienteJaCadastradoException();


    }


    private Conta inicializarConta(Cliente cliente, int tipoConta, BigDecimal depositoInicial,
                                   BigDecimal taxaSaqueTransferencia, BigDecimal rendimento) {

        Conta conta = new ContaCorrente();

        switch (tipoConta) {
            case 1:
                conta = new ContaCorrente(contadorContas, depositoInicial, taxaSaqueTransferencia);
                break;

            case 2:
                if(cliente instanceof ClientePessoaJuridica) {
                    conta = null;
                    throw new PessoaJuridicaPoupancaException();
                } else {
                    conta = new ContaPoupanca(contadorContas, depositoInicial, taxaSaqueTransferencia);
                }
                break;

            case 3:
                conta = new ContaInvestimento(contadorContas, depositoInicial, taxaSaqueTransferencia, rendimento);
                break;
        }

        return conta;

    }
    
    private boolean isClienteCadastrado(String idCliente) {

        for (Cliente cliente: clientesCadastrados) {
            if (cliente.getIdCliente().equals(idCliente))
                return true;
        }

        return false;

    }

}