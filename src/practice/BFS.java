package practice;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    int[][] matrix;
    int nOfv;

    public BFS(int nOfv) {
        this.nOfv = nOfv;
        matrix = new int[nOfv][nOfv];
    }

    public static void main(String[] args) {
        BFS g = new BFS(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("BFS with start vertex 2");

        g.bfs(2);
    }

    private void addEdge(int u, int v) {
        matrix[u][v] = 1;
    }

    public void bfs(int startVertex) {
        boolean[] visited = new boolean[nOfv];
        Queue<Integer> q = new LinkedList<>();
        q.add(startVertex);
        visited[startVertex] = true;

        while (!q.isEmpty()) {
            int u = q.remove();
            System.out.println(u);

            for (int v = 0; v < matrix[u].length; v++) {
                if (matrix[u][v] == 1 && !visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
    }
}
