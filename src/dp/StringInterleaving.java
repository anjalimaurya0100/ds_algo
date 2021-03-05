package dp;

public class StringInterleaving {
    public static void main(String[] args) {
        String a = "aabcc";
        String b = "dbbca";
        String c = "aadbbbaccc";
        StringInterleaving si = new StringInterleaving();
        System.out.println(si.checkIfInterleaved(a,b,c));
    }

    public boolean checkIfInterleaved(String a, String b, String c) {
        int m = a.length();
        int n = b.length();
        boolean[][] dp = new boolean[m+1][n+1];

        dp[0][0] = true;
        for(int i = 0; i <=m; i++) {
            for(int j = 0; j <=n; j++) {
                if(i != 0 && j != 0 && a.charAt(i-1) == c.charAt(i+j-1) && b.charAt(j-1) == c.charAt(i+j-1)) {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                } else if (j != 0 && b.charAt(j-1) == c.charAt(i+j-1)) {
                    dp[i][j] = dp[i][j-1];
                } else if (i != 0 && a.charAt(i-1) == c.charAt(i+j-1)) {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }
}
