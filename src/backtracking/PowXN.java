package backtracking;

public class PowXN {

    public static double findPow(double x, int n) {
        double result;

        if ( n == 0)
            return 1;

        result = findPow(x, n / 2);
        if (n % 2 == 0) {
            return result*result;
        }else{
            return x*result*result;
        }

    }
    public static void main(String[] args) {
        double x = 2;
        int n = 10;
        System.out.println(findPow(x,n));
    }
}
