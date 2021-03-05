package dp;

public class SubsetPartition {
    public static void main(String[] args) {
        int[] array = {2,2,4,4,2,1,1};
        SubsetPartition sp = new SubsetPartition();
        System.out.println(sp.isSubsetPartition(array));
    }

    public boolean isSubsetPartition(int[] array) {
        int sum = 0;
        for(int v : array)
            sum += v;

        if (sum % 2 != 0)
            return false;

        int reqSum = sum/2;

        boolean[][] dp = new boolean[array.length+1][reqSum+1];
        for(int i = 0; i <= array.length; i++) {
            dp[i][0] = true;
        }

        for(int j = 1; j <= reqSum; j++) {
            dp[0][j] = false;
        }

        for(int i = 1; i <= array.length; i++) {
            for(int j = 1; j <= reqSum; j++) {
                if (j < array[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-array[i-1]];
                }
            }
        }
        return dp[array.length][reqSum];
    }

}
