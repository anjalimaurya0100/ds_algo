package graph;

import java.util.LinkedList;
import java.util.Queue;

public class KnightWalk {
        static class Point {
            int x;
            int y;
            int distance;

            public Point(int i, int j, int distance) {
                this.x = i;
                this.y = j;
                this.distance = distance;
            }
        }

        public static boolean isValid(int r, int c) {
            return r >= 0 && c >= 0 && r < 8 && c < 8;
        }

        public static int minKnightDistance(Point s, Point d) { // bfs
            boolean[][] visited = new boolean[8][8];

            Queue<Point> queue = new LinkedList<>();
            visited[s.x][s.y] = true;
            queue.add(s);

            int[] rowNum = {-1, 1, -2, -2, -1, 1, 2, 2};
            int[] colNum = {-2, -2, -1, 1, 2, 2, -1, 1};

            while (!queue.isEmpty()) {
                Point p = queue.remove();

                if (p.x == d.x && p.y == d.y) {
                    return p.distance;
                }

                for(int i = 0; i < 8; i++) {
                    int r = p.x + rowNum[i];
                    int c = p.y + colNum[i];

                    if (isValid(r, c) && !visited[r][c]) {
                        queue.add(new Point(r, c, p.distance+1));
                        visited[r][c] = true;
                    }
                }
            }
            return -1;
        }

        public static void main(String[] args) {
            System.out.println(minKnightDistance(new Point(0, 7, 0), new Point(7, 0, 0)));
        }
    }

