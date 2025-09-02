package br.com.mariojp.solid.lspaccounts;

public abstract class Account {
    protected double balance;

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}