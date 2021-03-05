package dp;

public class LCS {
    public static int lcsByDp(char[] a, char[] b) {
        int r = a.length;
        int c = b.length;
        int[][] matrix = new int[r + 1][c + 1];

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (a[i - 1] == b[j - 1]) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }
        return matrix[r][c];
    }

    public static void main(String[] args) {
        char[] a = {'p', 'r', 'a', 'm', 'o', 'd'};
        char[] b = {'a', 'r', 'j', 'a', 'l', 'm'};

        System.out.println(lcsByDp(a, b));

    }
}
