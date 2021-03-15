package backtracking;

public class RatMaze {
    static int N;

    public static boolean findPathInMaze(int[][]matrix, int x, int y, int[][] path){
        if(x== N-1 && y== N-1 && matrix[x][y]==0){
            path[x][y]=1;
            return true;
        }
        if(x >=0 && y >= 0 && x<=N-1 && y<=N-1 && matrix[x][y]==0 && path[x][y] == 0){
            path[x][y]=1;

            if(findPathInMaze(matrix,x,y+1,path))
                return true;
            if(findPathInMaze(matrix,x+1,y,path))
                return true;

//            if(findPathInMaze(matrix,x-1,y,path))
//                return true;
//            if(findPathInMaze(matrix,x,y-1,path))
//                return true;

            // if none of above movements work then do backtracking
            path[x][y] = 0;
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 1, 0, 0, 0 },
                { 0, 1, 0, 1, 0 },
                { 0, 1, 0, 1, 0 },
                { 0, 1, 0, 1, 0 },
                { 0, 0, 0, 0, 0 }
        };

        N = matrix.length;
        int[][] sol = new int[N][N];
        findPathInMaze(matrix, 0, 0, sol);

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }
}
