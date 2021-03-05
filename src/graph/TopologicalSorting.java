package graph;

import java.util.Stack;

public class TopologicalSorting {
    int[][] am;
    int v;
    boolean[] visited;
    Stack<Integer> stack;

    public TopologicalSorting(int v) {
        this.am = new int[v][v];
        this.v = v;
        this.visited = new boolean[v];
        this.stack = new Stack<>();
    }

    public static void main(String[] args) {
        TopologicalSorting g = new TopologicalSorting(6);

        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        g.topologicalSort();
    }

    public void addEdge(int u, int v) {
        this.am[u][v] = 1;
    }

    public void dfs(int u) {
        visited[u] = true;
        for (int v = 0; v < am[u].length; v++) {
            if (am[u][v] == 1 && !visited[v]) {
                dfs(v);
            }
        }
        stack.push(u);
    }

    public void topologicalSort() {
        for (int u = 0; u < am.length; u++) {
            if (!visited[u]) {
                dfs(u);
            }
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
