package dp;

public class LongestPalindromeSubseq {
    public static void main(String[] args) {
        int n = 4;
        LongestPalindromeSubseq lps = new LongestPalindromeSubseq();
        System.out.println(lps.longestPlin("adceca"));
    }

    public int longestPlin(String a) {
        int n = a.length();
        int[][] dpMatrix = new int[n][n];

        for (int k = 0; k < n; k++) {
            for (int i = 0, j = k; j < n; i++, j++) {
                if (i == j) {
                    dpMatrix[i][j] = 1;
                } else if (a.charAt(i) == a.charAt(j)) {
                    dpMatrix[i][j] = 2 + dpMatrix[i + 1][j - 1];
                } else {
                    dpMatrix[i][j] = Math.max(dpMatrix[i][j - 1], dpMatrix[i + 1][j]);
                }
            }
        }
        return dpMatrix[0][n - 1];
    }
}
