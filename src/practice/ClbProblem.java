package practice;

public class ClbProblem {

    public static int clbP(int[][] matrix) {
        int i = 0;
        int j = matrix.length - 1;

        while (i < j) {
            if (matrix[i][j] == 1) {
                i++;
            } else {
                j--;
            }
        }
        boolean flag = true;
        for (int k = 0; k < matrix[0].length; k++) {
            if ((matrix[i][k] == 1) || (matrix[k][i] == 0 && k != i)) {
                flag = false;
                break;
            }
        }
        return flag ? i : -1;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 0, 1},
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0},
        };

        System.out.println(clbP(matrix));
    }
}
