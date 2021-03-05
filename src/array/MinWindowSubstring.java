package array;

public class MinWindowSubstring {
    public static void main(String[] args) {
        String str = "ADOBECODEBANC";
        String pat = "ABC";
        String result = minWindowSubstring(str, pat);
        System.out.println(result);
    }

    public static String minWindowSubstring(String str, String pat) {
        if (pat.length() > str.length()) {
            return "";
        }

        int[] countStr = new int[26];
        int[] countPat = new int[26];

        for (int i = 0; i < pat.length(); i++) {
            countPat[pat.charAt(i) - 'A']++;
        }

        int start = 0;
        int len = 0;
        int startIndex = -1;
        int minLength = Integer.MAX_VALUE;
        int i = 0;
        int count = 0;
        while (i < str.length()) {
            countStr[str.charAt(i) - 'A']++;

            if (countPat[str.charAt(i) - 'A'] != 0 && (countStr[str.charAt(i) - 'A'] <= countPat[str.charAt(i) - 'A'])) {
                count++;
            }

            if (count == pat.length()) {
                while ((countStr[str.charAt(start) - 'A'] > countPat[str.charAt(start) - 'A']) || countPat[str.charAt(start) - 'A'] == 0) {
                    if (countStr[str.charAt(start) - 'A'] > countPat[str.charAt(start) - 'A']) {
                        countStr[str.charAt(start) - 'A']--;
                    }
                    start++;
                }

                len = i - start + 1;
                if (len < minLength) {
                    minLength = len;
                    startIndex = start;
                }
            }
            i++;
        }
        return str.substring(startIndex, startIndex + minLength);
    }
}
