package dp;

public class EggDroppingPuzzle {
    public static void main(String[] args) {
        int floors = 100;
        int eggs = 3;

        EggDroppingPuzzle edp = new EggDroppingPuzzle();
        System.out.println(edp.findMinAttempts(floors, eggs));
    }

    public int findMinAttempts(int floors, int eggs) {
        int[][] dp = new int[eggs + 1][floors + 1];
        for (int j = 1; j <= floors; j++) {
            dp[1][j] = j;
        }

        for (int i = 2; i <= eggs; i++) {
            for (int j = 1; j <= floors; j++) {
                if (j < i) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }

                int min = Integer.MAX_VALUE;
                for (int k = 1; k <= j; k++) {
                    min = Math.min(min, 1 + Math.max(dp[i - 1][k - 1], dp[i][j - k]));
                }
                dp[i][j] = min;
            }
        }

        return dp[eggs][floors];
    }
}
