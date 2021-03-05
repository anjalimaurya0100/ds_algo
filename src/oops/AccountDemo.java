package oops;

public class AccountDemo {
    public static void main(String[] args) {
        Account savings = new Savings(50000);
        savings.deposit(1000);
        savings.printBalance();

        savings.withdraw(3000);
        savings.printBalance();

        System.out.println();

        Account current = new Current(50000);
        current.deposit(1000);
        current.printBalance();

        current.withdraw(3000);
        current.printBalance();
    }
}
