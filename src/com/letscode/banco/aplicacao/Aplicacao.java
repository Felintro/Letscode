package com.letscode.banco.aplicacao;

import com.letscode.banco.classes.banco.Banco;
import com.letscode.banco.classes.cliente.Cliente;
import com.letscode.banco.classes.conta.Conta;


import java.math.BigDecimal;

public class Aplicacao {

    public static void main(String[] args) {

        Banco banco = new Banco();
        Cliente cliente;
        Conta conta;
        int i;

        /* Cadastro de clientes do tipo ClientePessoaFisica */

        for(i=1; i<=4; i++) {

            cliente = banco.cadastrarCliente(1, "0010020030" + i, "Allan " + i);
            conta = banco.abrirConta(cliente, 1, BigDecimal.valueOf(100).multiply(BigDecimal.valueOf(i)));
            conta = banco.abrirConta(cliente, 2, BigDecimal.valueOf(1000).multiply(BigDecimal.valueOf(i)));
            conta = banco.abrirConta(cliente, 3, BigDecimal.valueOf(10000).multiply(BigDecimal.valueOf(i)));

            System.out.println(">>>> =========================== <<<<");
            System.out.println(">>>> Cliente: " + cliente.getNome() + " <<<<");
            System.out.println(cliente.toString());
            System.out.println(">>>> =========================== <<<<");

        }

        /* Cadastro de clientes do tipo ClientePessoaJuridica */

        do {

            cliente = banco.cadastrarCliente(2, "0010020030" + i, "Talita " + i);
            conta = banco.abrirConta(cliente, 1, BigDecimal.valueOf(100).multiply(BigDecimal.valueOf(i)));
            conta = banco.abrirConta(cliente, 3, BigDecimal.valueOf(10000).multiply(BigDecimal.valueOf(i)));

            System.out.println(">>>> =========================== <<<<");
            System.out.println(">>>> Cliente: " + cliente.getNome() + " <<<<");
            System.out.println(cliente.toString());
            System.out.println(">>>> =========================== <<<<\n\n");
            i++;

        } while (i<=8);

        /* Exceções (descomente uma por vez para verificar seu funcionamento) */

//      cliente = banco.cadastrarCliente(2, "00100200304" , "Talita"); /* ClienteJaCadastradoException */
//      conta = banco.abrirConta(cliente, 2, BigDecimal.valueOf(100).multiply(BigDecimal.valueOf(1))); /* PessoaJuridicaPoupancaException */
//      System.out.println(banco.getClienteById("0010020")); /* IdInvalidoException */
//      conta.transferir(conta, banco.getContaById(4), BigDecimal.valueOf(100000000)); /* SaldoInsuficienteException */


        /* método consultaSaldo */
        System.out.println("Conta: " + conta.getNrConta());
        System.out.println(conta.consultaSaldo());
        System.out.println(">>>> =========================== <<<<\n");


        /* Operações Bancárias */

        conta.sacar(BigDecimal.valueOf(8000.00)); /* Saque de pessoa fisica (sem taxa) */
        conta = banco.getContaById(1);

        conta = banco.getContaById(18);
        conta.consultaSaldo();
        conta.sacar(BigDecimal.valueOf(10000)); /* Saque de pessoa juridica (com taxa) */
        conta.consultaSaldo();

        conta.transferir(conta, banco.getContaById(4), BigDecimal.valueOf(400));
        conta = banco.getContaById(6);

        System.out.println(conta);
        conta.depositarInvestir(BigDecimal.valueOf(1000));
        System.out.println(conta);

    }
}