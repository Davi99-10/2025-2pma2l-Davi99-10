package br.com.mariojp.solid.lspaccounts;

public class CheckingAccount extends Account implements Withdrawable {

    @Override
    public void withdraw(double amount) {
        if (this.balance < amount) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        this.balance -= amount;
    }
}