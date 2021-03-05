package graph;

public class Dijkstra {
    int nv;
    int[] dis;
    boolean[] visited;

    public Dijkstra(int nv){
        this.nv = nv;
        this.dis = new int[nv];
        for(int i = 0 ; i < nv ; i++){
            dis[i] = Integer.MAX_VALUE;
        }
        this.visited = new boolean[nv];
    }

    public void dijkstra(int[][] matrix, int s){
        dis[s] = 0;
        for(int i = 0; i< nv -1 ; i++){
            int u = minDistance();
            visited[u] = true;

            for(int v = 0 ; v < matrix[u].length ; v++){
                if(!visited[v] && dis[u] != Integer.MAX_VALUE && matrix[u][v] != 0 && dis[u]+matrix[u][v] < dis[v]  ){
                    dis[v] = dis[u]+matrix[u][v];
                }
            }
        }
    }

    public int minDistance(){
        int minV = -1;
        int minVal = Integer.MAX_VALUE;
        for(int i = 0 ; i < nv ; i++){
            if(dis[i] < minVal && !visited[i]){
                minVal = dis[i];
                minV = i;
            }
        }
        return minV;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0,2,0,0,0,3},
                {2,0,4,0,0,0},
                {0,4,0,5,1,1},
                {0,0,5,0,0,0},
                {0,0,1,0,0,2},
                {3,0,1,0,2,0}
        };

        Dijkstra d = new Dijkstra(matrix.length);
        d.dijkstra(matrix,0);
        for(int val : d.dis) {
            System.out.println(val);
        }
    }
}
