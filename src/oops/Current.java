package oops;

public class Current extends Account {
    public Current(double balance){
        super(balance);
    }

    public void withdraw(double amount){
        balance=balance-amount;
    }
    public void deposit(double amount){
        balance = balance+amount;
    }
    public void printBalance(){
        System.out.println(balance);
    }
}
