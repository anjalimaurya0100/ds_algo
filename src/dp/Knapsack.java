package dp;

public class Knapsack {
    public static void main(String[] args) {
        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};
        int maxWeight = 7;
        Knapsack ks = new Knapsack();
        System.out.println(ks.maxValue(weights, values, maxWeight));
    }

    public int maxValue(int[] weights, int[] values, int maxWeight) {
        int[][] dp = new int[weights.length][maxWeight + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 1; j <= maxWeight; j++) {
                if (weights[i] <= j && i == 0) {
                    dp[i][j] = values[i];
                    continue;
                }

                if (weights[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], values[i] + dp[i - 1][j - weights[i]]);
                }
            }
        }
        return dp[weights.length - 1][maxWeight];
    }


}
