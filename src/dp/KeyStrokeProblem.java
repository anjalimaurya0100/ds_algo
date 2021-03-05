package dp;

public class KeyStrokeProblem {
    public static void main(String[] args) {
        int n = 7;
        KeyStrokeProblem ksp = new KeyStrokeProblem();
        System.out.println(ksp.maxLength(7));
    }

    public int maxLength(int n) {
        int[] dp = new int[n + 1];
        if (n <= 3) {
            return n;
        }
        for (int i = 0; i <= 3; i++) {
            dp[i] = i;
        }

        for (int i = 4; i <= n; i++) {
            int factor = 2;
            int max = Integer.MIN_VALUE;
            for (int j = i - 3; j >= 0; j--) {
                max = Math.max(max, factor * dp[j]);
                factor++;
            }
            dp[i] = max;
        }

        return dp[n];
    }
}
