package oops;

abstract public class Account {
    protected double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    abstract public void withdraw(double amount);

    public void deposit(double amount) {

    }

    public void printBalance() {
    }
}
