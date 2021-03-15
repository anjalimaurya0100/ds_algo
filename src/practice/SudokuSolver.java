package practice;

public class SudokuSolver {
    public static boolean sudokuFill(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                for (char k = '1'; k <= '9'; k++) {
                    if (isSafe(board, i , j, k)) {
                        board[i][j] = k;
                        if (sudokuFill(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    public static boolean isSafe(char[][] board, int row, int col, char k) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == k) {
                return false;
            }

            if (board[row][i] != '.' && board[row][i] == k) {
                return false;
            }

            int x = (row / 3) * 3;
            int y = (col / 3) * 3;
            if (board[x + i / 3][y + i % 3] != '.' && board[x + i / 3][y + i % 3] == k) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        System.out.println(sudokuFill(board));

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
