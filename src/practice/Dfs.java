package practice;

public class Dfs {
    int[][] matrix;
    int nOfv;
    boolean[] visited;

    public Dfs(int nOfv) {
        matrix = new int[nOfv][nOfv];
        this.nOfv = nOfv;
        visited = new boolean[nOfv];

    }

    public static void main(String[] args) {
        Dfs g = new Dfs(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("DFS with start vertex 2");

        g.dfs(2);
    }

    private void addEdge(int u, int v) {
        matrix[u][v] = 1;
    }

    public void dfs(int u) {
        System.out.println(u);
        visited[u] = true;

        for (int v = 0; v < matrix[u].length; v++) {
            if (matrix[u][v] == 1 && !visited[v]) {
                dfs(v);
            }
        }
    }
}
