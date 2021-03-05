package dp;

public class WildcardMatching {
    public static void main(String[] args) {
        String str = "xaylmz";
        String ptn = "x?y*z";
        WildcardMatching wm = new WildcardMatching();
        System.out.println(wm.isWildcardMatching(str, ptn));
    }

    private boolean isWildcardMatching(String str, String ptn) {
        boolean[][] dp = new boolean[str.length()+1][ptn.length()+1];
        dp[0][0] = true;

        for(int i = 1; i <= str.length(); i++) {
            for(int j = 1; j <= ptn.length(); j++) {
                if(str.charAt(i-1) == ptn.charAt(j-1) || ptn.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (ptn.charAt(j-1) == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }

        return dp[str.length()][ptn.length()];
    }
}
