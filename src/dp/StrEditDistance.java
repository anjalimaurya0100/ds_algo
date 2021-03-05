package dp;

public class StrEditDistance {
    public static int convertWord(char[] a, char[] b) {
        int r = a.length;
        int c = b.length;
        int[][] dpMatrix = new int[r + 1][c + 1];

        for (int i = 0; i <= r; i++) {
            for (int j = 0; j <= c; j++) {
                if (i == 0) {
                    dpMatrix[i][j] = j;
                } else if (j == 0) {
                    dpMatrix[i][j] = i;
                } else if (a[i - 1] == b[j - 1]) {
                    dpMatrix[i][j] = dpMatrix[i - 1][j - 1];
                } else {
                    dpMatrix[i][j] = 1 + min(dpMatrix[i][j - 1], dpMatrix[i - 1][j], dpMatrix[i - 1][j - 1]);
//                    dpMatrix[i][j] = 1+ Math.min(Math.min(dpMatrix[i][j - 1], dpMatrix[i - 1][j]), dpMatrix[i - 1][j - 1]);
                }
            }
        }
        return dpMatrix[r][c];
    }

    public static int min(int x, int y, int z) {
        if (x <= y && x <= z) {
            return x;
        }
        if (y <= x && y <= z) {
            return y;
        } else
            return z;
    }

    public static void main(String[] args) {
        char[] a = {'a', 'p', 'p', 'l', 'e'};
        char[] b = {'m', 'a', 'r', 'p', 'l', 'e'};

        System.out.println(convertWord(a, b));

    }
}
