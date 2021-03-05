package graph;

public class DFS {
    int[][] am;
    int v;
    boolean[] visited;

    public DFS(int v){
        this.v = v;
        this.am = new int[v][v];
        this.visited = new boolean[v];
    }

    public void addEdge(int u , int v){
        this.am[u][v] = 1;

    }

    public void dfs(int u){
        System.out.println(u);
        visited[u] = true;

        for(int v = 0; v < am[u].length; v++) {
            if(am[u][v] == 1 && !visited[v]) {
                dfs(v);
            }
        }
    }

    public static void main(String[] args) {
        DFS g = new DFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Depth First Traversal (starting from vertex 2)");
        g.dfs(2);
    }
}
