package graph;

public class CheckCycleUsingDFS {
    int[][] am;
    int v;
    boolean[] visited;

    public CheckCycleUsingDFS(int v) {
        this.am = new int[v][v];
        this.v = v;
        this.visited = new boolean[v];
    }

    public void addEdge(int u, int v) {
        this.am[u][v] = 1;
        this.am[v][u] = 1;
    }

    public boolean dfs(int u, int parent) {
        visited[u] = true;

        for(int v = 0 ; v < am[u].length ; v++) {
            if(am[u][v] == 1){
                if (!visited[v] && dfs(v, u)) {
                    return true;
                } else if (v != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCycle() {
        for(int u = 0; u < am.length; u++) {
            if(!visited[u] && dfs(u, -1)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CheckCycleUsingDFS g = new CheckCycleUsingDFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(g.isCycle());
    }

}
