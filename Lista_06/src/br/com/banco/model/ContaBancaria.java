package br.com.banco.model;

import java.util.Objects;

public class ContaBancaria {
    private final String numeroConta;
    private double saldo;
    private final Cliente titular;

    public ContaBancaria(String numeroConta, Cliente titular, double saldoInicial) {
        if (!Double.isFinite(saldoInicial) || saldoInicial < 0) {
            throw new IllegalArgumentException("Saldo inicial inválido.");
        }
        this.numeroConta = Objects.requireNonNull(numeroConta);
        this.titular = Objects.requireNonNull(titular);
        this.saldo = saldoInicial;
        Agencia.registrarNovaConta();
    }

    public String getNumeroConta() { return numeroConta; }
    public double getSaldo() { return saldo; }
    public Cliente getTitular() { return titular; }

    public void depositar(double valor) {
        if (!Double.isFinite(valor) || valor <= 0 || !Double.isFinite(saldo + valor)) {
            throw new IllegalArgumentException("Depósito deve ter valor positivo e finito.");
        }
        saldo += valor;
    }

    public boolean sacar(double valor) {
        if (!Double.isFinite(valor) || valor <= 0) return false;
        double total = valor + Agencia.TAXA_SAQUE;
        if (saldo >= total) {
            saldo -= total;
            return true;
        }
        return false;
    }
}
