package stack_queue;

public class MaxRectangle {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
        };

        int result = HistogramByStack.findHistogram(matrix[0]);
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = matrix[i][j] + matrix[i - 1][j];
                }
            }
            result = Math.max(result, HistogramByStack.findHistogram(matrix[i]));
        }
        System.out.println(result);
    }
}
