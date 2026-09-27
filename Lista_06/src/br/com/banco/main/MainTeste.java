package br.com.banco.main;

import br.com.banco.model.Agencia;
import br.com.banco.model.Cliente;
import br.com.banco.model.ContaBancaria;

public class MainTeste {
    public static void main(String[] args) {
        Cliente c1 = new Cliente("12345678900", "Lucas", "lucas@example.com");
        Cliente c2 = new Cliente("12345678900", "Lucas Marinho", "outro@example.com");
        if (c1.equals(c2)) {
            System.out.println("Os clientes são iguais pelo CPF.");
        }
        System.out.println(c1);
        ContaBancaria conta = new ContaBancaria("001", c1, 50.0);
        System.out.println("Saque de 50: " + conta.sacar(50.0));
        System.out.println("Saldo preservado: " + conta.getSaldo());
        System.out.println("Total de contas abertas: " + Agencia.getTotalContasAbertas());
        conta.depositar(10.0);
        System.out.println("Saque após depósito: " + conta.sacar(50.0));
        System.out.println("Saldo final: " + conta.getSaldo());
    }
}
