package oops;

public class Calculator implements Addition {
    public double product(double x, double y) {
        return x * y;
    }

    public double product(double x, double y, double z) {
        return x * y * z;
    }

    public int product(int x, int y) {
        return x * y;
    }

    public int add(int num1, int num2) {
        return num1 + num2;
    }
}
