package dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        String[] dict = {"i", "like", "am", "boy", "e", "o", "g", "dog", "cat"};
        String str = "ilikedog";
        WordBreak wb = new WordBreak();
        String broken = wb.wordBreak(str, dict);
        System.out.println(broken);
    }

    public String wordBreak(String str, String[] dict) {
        Set<String> dictionary = new HashSet<>(Arrays.asList(dict));
        int n = str.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0, j = k; j < n; i++, j++) {
                String p = str.substring(i, j + 1);
                if (dictionary.contains(p)) {
                    dp[i][j] = i;
                    continue;
                }

                for (int x = i; x < j; x++) {
                    if (dp[i][x] != -1 && dp[x + 1][j] != -1) {
                        dp[i][j] = x;
                        break;
                    }
                }
            }
        }

        if (dp[0][n - 1] == -1)
            return null;

        int i = 0;
        int j = n - 1;
        StringBuilder sb = new StringBuilder();
        while (i < j) {
            int k = dp[i][j];
            if (k == i && i > 1) {
                sb.append(str, i, n);
                break;
            }
            sb.append(str, i, k + 1).append(" ");
            i = k + 1;
        }

        return sb.toString();
    }
}
