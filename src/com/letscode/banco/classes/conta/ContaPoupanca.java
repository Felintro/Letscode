package com.letscode.banco.classes.conta;

import java.math.BigDecimal;

public class ContaPoupanca extends Conta {

    public ContaPoupanca() {
        super();
    }

    public ContaPoupanca(int nrConta, BigDecimal saldo, BigDecimal taxaSaqueTransferencia) {
        super(nrConta, saldo, taxaSaqueTransferencia);
    }

    @Override
    protected void emitirReciboDepositoInvestimento(BigDecimal valorDeposito) {

        System.out.println("Depósito efetuado com sucesso!");
        System.out.println(">>>> Recibo: <<<<");
        System.out.println("Valor depositado: " + valorDeposito);
        System.out.println("Conta: " + this.nrConta);
        System.out.println(consultaSaldo());
        System.out.println(">>>> =========================== <<<<\n");

    }

    @Override
    public void depositarInvestir(BigDecimal valorDeposito) {
        this.saldo = this.saldo.add(valorDeposito);
        this.emitirReciboDepositoInvestimento(valorDeposito);
    }

    @Override
    public String toString() {
        return "\nContaPoupanca {" +
                "nrConta= " + nrConta +
                ", saldo= " + saldo +
                ", taxaSaqueTransferencia= " + taxaSaqueTransferencia +
                "}";
    }
}
