package com.letscode.banco.classes.conta;

import com.letscode.banco.classes.exception.SaldoInsuficienteException;

import java.math.BigDecimal;

public abstract class Conta {

    protected int nrConta;
    protected BigDecimal saldo;
    protected BigDecimal taxaSaqueTransferencia;

    public Conta() {
    }

    public Conta(int nrConta, BigDecimal depositoInicial, BigDecimal taxaSaqueTransferencia) {
        this.nrConta = nrConta;
        this.saldo = depositoInicial;
        this.taxaSaqueTransferencia = taxaSaqueTransferencia;
    }

    public int getNrConta() {
        return nrConta;
    }

    public void setNrConta(int nrConta) {
        this.nrConta = nrConta;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getTaxaSaqueTransferencia() {
        return taxaSaqueTransferencia;
    }

    public void setTaxaSaqueTransferencia(BigDecimal taxaSaqueTransferencia) {
        this.taxaSaqueTransferencia = taxaSaqueTransferencia;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public String consultaSaldo() {
        return "Seu saldo é: " + saldo;
    }

    public void sacar(BigDecimal valorSaque) {

        if(possuiSaldoSuficiente(this, valorSaque)) {
            this.saldo = calcularSaldoNovo(valorSaque);
            emitirReciboSaque(valorSaque);
        } else
            throw new SaldoInsuficienteException();

    }

    public void transferir(Conta contaOrigem, Conta contaDestino, BigDecimal valorTransferencia) {

        if(possuiSaldoSuficiente(contaOrigem, valorTransferencia)) {
            contaOrigem.saldo = contaOrigem.calcularSaldoNovo(valorTransferencia);
            contaDestino.saldo = contaDestino.saldo.add(valorTransferencia);
            emitirReciboTransferencia(contaOrigem, contaDestino, valorTransferencia);
        } else
            throw new SaldoInsuficienteException();

    }

    public abstract void depositarInvestir(BigDecimal valorDeposito);

    protected abstract void emitirReciboDepositoInvestimento(BigDecimal valorDeposito);


    private boolean possuiSaldoSuficiente(Conta conta, BigDecimal valorOperacao) {

        if(conta.calcularSaldoNovo(valorOperacao).compareTo(BigDecimal.valueOf(0.0)) >= 0)
            return true;
        else
            return false;
    }


    protected void emitirReciboTransferencia(Conta contaOrigem, Conta contaDestino, BigDecimal valorTransferencia) {

        System.out.println("Transferência efetuada com sucesso!\n");
        System.out.println(">>>> Recibo: <<<<");
        System.out.println("Valor transferido: " + valorTransferencia);
        System.out.println("Taxa de operação: " + contaOrigem.taxaSaqueTransferencia.multiply(valorTransferencia));
        System.out.println("Conta de origem: " + contaOrigem.nrConta);
        System.out.println("Conta de destino: " + contaDestino.nrConta);
        System.out.println(contaOrigem.consultaSaldo());
        System.out.println(">>>> =========================== <<<<\n");

    }

    protected void emitirReciboSaque(BigDecimal valorSaque) {

        System.out.println("Saque efetuado com sucesso!");
        System.out.println(">>>> Recibo: <<<<");
        System.out.println("Valor sacado: " + valorSaque);
        System.out.println("Conta: " + this.nrConta);
        System.out.println("Taxa de operação: " + this.taxaSaqueTransferencia.multiply(valorSaque));
        System.out.println(consultaSaldo());
        System.out.println(">>>> =========================== <<<<\n");

    }


    private BigDecimal calcularSaldoNovo(BigDecimal valorOperacao) {

        BigDecimal saldoNovo;
        BigDecimal valorTaxaSaqueTransferencia = BigDecimal.valueOf(0.0);

        valorTaxaSaqueTransferencia = valorTaxaSaqueTransferencia
                                      .add(valorOperacao)
                                      .multiply(taxaSaqueTransferencia);

        saldoNovo = saldo
                    .subtract(valorTaxaSaqueTransferencia)
                    .subtract(valorOperacao);

        return saldoNovo;

    }

    @Override
    public String toString() {
        return "\nConta {" +
                "nrConta= " + nrConta +
                ", saldo= " + saldo +
                ", taxaSaqueTransferencia= " + taxaSaqueTransferencia +
                '}';
    }
}