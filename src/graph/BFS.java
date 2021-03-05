package graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    int[][] am;
    int v;

    public BFS(int v) {
        this.v = v;
        this.am = new int[v][v];
    }

    public static void main(String[] args) {
        BFS g = new BFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Breadth First Traversal (starting from vertex 2)");
        g.bfs(2);
    }

    public void addEdge(int u, int v) {
        this.am[u][v] = 1;
    }

    private void bfs(int s) {
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;

        while (!queue.isEmpty()) {
            Integer u = queue.remove();
            System.out.println(u);

            for (int v = 0; v < am[u].length; v++) {
                if (am[u][v] == 1 && !visited[v]) {
                    visited[u] = true;
                    queue.add(v);
                }
            }
        }

    }
}
