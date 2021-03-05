package backtracking;

public class Sudoku {
    public static boolean isValidSudoku(char[][] board) {
        // check rows
        for(int i = 0; i < 9; i++) {
            boolean[] check = new boolean[9];
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    if (check[board[i][j] - '1']) {
                        return false;
                    }
                    check[board[i][j] - '1'] = true;
                }
            }
        }

        // check columns
        for(int i = 0; i < 9; i++) {
            boolean[] check = new boolean[9];
            for(int j = 0; j < 9; j++) {
                if(board[j][i] != '.') {
                    if (check[board[j][i] - '1']) {
                        return false;
                    }
                    check[board[j][i] - '1'] = true;
                }
            }
        }

        // check cell
        for(int x = 0; x < 9; x += 3) {
            for(int y = 0; y < 9; y += 3) {
                boolean[] check = new boolean[9];
                for(int i = x; i < x+3; i++) {
                    for(int j = y; j < y+3; j++) {
                        if(board[i][j] != '.') {
                            if (check[board[i][j] - '1']) {
                                return false;
                            }
                            check[board[i][j] - '1'] = true;
                        }
                    }
                }
            }
        }

        return true;
    }

    // TODO: get rid of boolean array
    public static boolean isSafe(char[][] board, int r , int c){
        // check r row
        for(int j = 0; j < 9; j++) {
            boolean[] check = new boolean[9];
            if(board[r][j] != '.') {
                if (check[board[r][j] - '1']) {
                    return false;
                }
                check[board[r][j] - '1'] = true;
            }
        }

        // check c column
        for(int j = 0; j < 9; j++) {
            boolean[] check = new boolean[9];
            if(board[j][c] != '.') {
                if (check[board[j][c] - '1']) {
                    return false;
                }
                check[board[j][c] - '1'] = true;
            }
        }

        // check cell that encloses r,c
        int x = (r/3)*3;
        int y = (c/3)*3;
        boolean[] check = new boolean[9];
        for(int i = x; i < x+3; i++) {
            for(int j = y; j < y+3; j++) {
                if(board[i][j] != '.') {
                    if (check[board[i][j] - '1']) {
                        return false;
                    }
                    check[board[i][j] - '1'] = true;
                }
            }
        }

        return true;
    }

    private boolean isSafeOpt(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) {
                return false;
            }

            if (board[row][i] != '.' && board[row][i] == c) {
                return false;
            }

            int x = (row/3)*3;
            int y = (col/3)*3;
            if (board[x + i / 3][y + i % 3] != '.' && board[x + i / 3][y + i % 3] == c) {
                return false;
            }
        }
        return true;
    }

    public static boolean sudokuSolver(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.')
                    continue;

                for(char k = '1'; k <= '9'; k++) {
                    board[i][j] = k;
                    if(isSafe(board, i, j) && sudokuSolver(board)) {
                        return true;
                    }
                    board[i][j] = '.'; // backtrack
                }
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
        System.out.println(isValidSudoku(board));
        System.out.println(sudokuSolver(board));

        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
