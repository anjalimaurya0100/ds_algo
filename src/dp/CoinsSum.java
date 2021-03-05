package dp;

public class CoinsSum {

    public static int coinsUsed(int[] coin, int sum) {
        int[] dp = new int[sum+1];

        dp[0] = 1;
        for (int k : coin) {
            for (int j = k; j <= sum; j++) {
                dp[j] += dp[j - k];
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        int[] coin = {1, 2, 5};

        System.out.println(coinsUsed(coin, 7));
    }
}
