package backtracking;

public class NQueen {
    public static boolean nQueen(int[][] board, int col) {
        if (col >= board.length)
            return true;

        for(int i = 0; i < board.length; i++) {
            if(isSafe(board, i, col)) {
                board[i][col] = 1;
                if(nQueen(board, col+1)) {
                    return true;
                }
                board[i][col] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col) {
        int i, j;
        for(i = 0; i < board.length; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

//        for(i = 0; i < board.length; i++) { // not required
//            if (board[i][col] == 1) {
//                return false;
//            }
//        }

        for(i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for(i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        nQueen(board, 0);

        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
