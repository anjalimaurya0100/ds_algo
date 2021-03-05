package practice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Graph {
    Map<Integer, LinkedList<Integer>> map;
    int[][] matrix;

    public Graph(int nOfv) {
        matrix = new int[nOfv][nOfv];
        map = new HashMap<>();
        for (int i = 0; i < nOfv; i++) {
            map.put(i, new LinkedList<>());
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.addEdge(2, 0);
        g.printGraph();
    }

    public void addEdge(int s, int d) {
        map.get(s).add(d);
        matrix[s][d] = 1;
    }

    public void printGraph() {
        // print adjacency list
        for (Map.Entry<Integer, LinkedList<Integer>> e : map.entrySet()) {
            System.out.print(e.getKey() + " = ");
            for (Integer v : e.getValue()) {
                System.out.print(v + " -> ");
            }
            System.out.println("null");
        }

        // print adjacency matrix
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(i + " = ");
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}

