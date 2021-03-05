package array;

public class CelebrityProblem {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 1, 1},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0}
        };

        int n = matrix.length;
        int a = 0;
        int b = n - 1;
        while (a < b) {
            if (matrix[a][b] == 1) {
                a++;
            } else {
                b--;
            }
        }

        int flag = 0;
        for (int i = 0; i < n; i++) {
            if (i != a && (matrix[a][i] == 1 || matrix[i][a] == 0)) {
                flag = -1;
                break;
            }
        }

        if (flag == -1)
            System.out.println("No Celebrity");
        else
            System.out.println("Celebrity is " + a);
    }
}