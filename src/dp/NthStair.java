package dp;

public class NthStair {
    public static void main(String[] args) {
        int m = 3; // max 4 steps
        int n = 5; // stairs
        NthStair ns = new NthStair();
        System.out.println(ns.nthStair(m, n));
    }

    public int nthStair(int m, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int s = i - m - 1;
            int e = i - 1;
            if (s >= 0) {
                sum = sum - dp[s];
            }
            sum = sum + dp[e];
            dp[i] = sum;
        }
        return dp[n];
    }
}
