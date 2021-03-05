package oops;

public class CalculatorDemo {
    public static void main(String[] args) {
        Calculator c1 = new Calculator();
        double x = 10;
        double y = 11;
        double z = 12;

        int a = 6;
        int b = 7;

        System.out.println(c1.product(x, y));
        System.out.println(c1.product(x, y, z));
        System.out.println(c1.product(a, b));
    }
}
