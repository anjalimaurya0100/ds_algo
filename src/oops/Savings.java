package oops;

public class Savings extends Account {
    private final double interestRate = 0.8;

    public Savings(double balance) {
        super(balance);
    }

    public void withdraw(double amount) {
        balance = balance - amount * (1 + interestRate);
    }

    public void deposit(double amount) {
        balance = balance + amount * (1 + interestRate);
    }

    public void printBalance() {
        System.out.println(balance);
    }
}
