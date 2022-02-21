package com.letscode.banco.classes.conta;

import java.math.BigDecimal;

public class ContaInvestimento extends Conta {

    private BigDecimal taxaRendimento;

    public ContaInvestimento(int nrConta, BigDecimal saldo, BigDecimal taxaSaqueTransferencia, BigDecimal taxaRendimento) {
        super(nrConta, saldo.multiply(taxaRendimento), taxaSaqueTransferencia);
        this.taxaRendimento = taxaRendimento;
    }

    public ContaInvestimento() {
        super();
    }

    @Override
    public void depositarInvestir(BigDecimal valorDeposito) {
        valorDeposito = valorDeposito.multiply(taxaRendimento);
        this.saldo = this.saldo.add(valorDeposito);
        this.emitirReciboDepositoInvestimento(valorDeposito);
    }

    @Override
    protected void emitirReciboDepositoInvestimento(BigDecimal valorDeposito) {

        System.out.println("Depósito efetuado com sucesso!");
        System.out.println(">>>> Recibo: <<<<");
        System.out.println("Valor depositado: " + valorDeposito);
        System.out.println("Conta: " + this.nrConta);
        System.out.println("Rendimento: " + this.taxaRendimento.multiply(valorDeposito));
        System.out.println(consultaSaldo());
        System.out.println(">>>> =========================== <<<<\n");

    }

    @Override
    public String toString() {
        return "\nContaInvestimento {" +
                "nrConta= " + nrConta +
                ", saldo= " + saldo +
                ", taxaSaqueTransferencia= " + taxaSaqueTransferencia +
                ", taxaRendimento= " + taxaRendimento +
                '}';
    }
}