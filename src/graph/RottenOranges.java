package graph;

import java.util.LinkedList;
import java.util.Queue;


public class RottenOranges {
    public static int R;
    public static int C;

    static class Element {
        int x;
        int y;

        Element(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int rottenOranges(int[][] matrix) {
        Queue<Element> q = new LinkedList<>();
        Element temp;
        int time = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 2) {
                    q.add(new Element(i, j));
                }
            }
        }
        q.add(new Element(-1, -1));

        int[] rowNum = {-1, 0, 0, 1};
        int[] colNum = {0, -1, 1, 0};

        while (!q.isEmpty()) {
            boolean flag = false;

            while (!checkCell(q.peek())) {
                temp = q.remove();
                for (int i = 0; i < 4; i++) {
                    int r = temp.x + rowNum[i];
                    int c = temp.y + colNum[i];

                    if (valid(r, c) && matrix[r][c] == 1) {
                        if (!flag) {
                            time++;
                            flag = true;
                        }
                        matrix[r][c] = 2;
                        q.add(new Element(r, c));
                    }
                }
            }
            q.remove();

            if (!q.isEmpty()) {
                q.add(new Element(-1, -1));
            }
        }
        return (checkAll(matrix)) ? -1 : time;
    }

    static boolean valid(int i, int j) {
        return (i >= 0 && j >= 0 && i < R && j < C);
    }

    static boolean checkCell(Element temp) {
        return (temp.x == -1 && temp.y == -1);
    }

    static boolean checkAll(int[][] matrix) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 1) {
                    return true;
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 2, 1}
        };

        R = matrix.length;
        C = matrix[0].length;
        int time = rottenOranges(matrix);
        if (time == -1) {
            System.out.println("not all the oranges are rotten");
        } else {
            System.out.println("time required to rot all oranges " + time);
        }
    }
}
