package graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 1, 1, 0},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {0, 0, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1}
        };
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        NumberOfIsland nfi = new NumberOfIsland();
        System.out.println("Number of Islands: " + nfi.numberOfIslands(matrix, visited));
    }

    private void bfs(Point s, int[][] matrix, boolean[][] visited) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(s);
        visited[s.x][s.y] = true;

        int[] rowNum = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colNum = {-1, 0, 1, -1, 1, -1, 0, 1};

        while (!queue.isEmpty()) {
            Point p = queue.remove();

            for (int i = 0; i < 8; i++) {
                int r = p.x + rowNum[i];
                int c = p.y + colNum[i];

                if (r >= 0 && c >= 0 && r < matrix.length && c < matrix[0].length && !visited[r][c] && matrix[r][c] == 1) {
                    queue.add(new Point(r, c));
                    visited[r][c] = true;
                }
            }
        }
    }

    public int numberOfIslands(int[][] matrix, boolean[][] visited) {
        int island = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!visited[i][j] && matrix[i][j] == 1) {
                    bfs(new Point(i, j), matrix, visited);
                    island++;
                }
            }
        }
        return island;
    }

    static class Point {
        int x;
        int y;

        public Point(int i, int j) {
            this.x = i;
            this.y = j;
        }
    }
}
