package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Graph {
    Map<Integer, LinkedList<Integer>> adjacencyList;
    //  LinkedList<Integer>[] adjacencyList;
    int[][] adjacencyMatrix;

    public Graph(int vertices) {
        this.adjacencyMatrix = new int[vertices][vertices];
        this.adjacencyList = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            adjacencyList.put(i, new LinkedList<>());
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(3, 0);
        g.addEdge(3, 4);
        g.printGraph();
    }

    public void addEdge(int u, int v) {
        this.adjacencyList.get(u).add(v);
        this.adjacencyMatrix[u][v] = 1;
//        this.map.get(v).add(u); // for undirected
    }

    public void printGraph() {
        // print adjacency list
        for (Map.Entry<Integer, LinkedList<Integer>> e : adjacencyList.entrySet()) {
            System.out.print(e.getKey() + " = ");
            for (Integer v : e.getValue()) {
                System.out.print(v + " -> ");
            }
            System.out.println("null");
        }

        // print adjacency matrix
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            System.out.print(i + " = ");
            for (int j = 0; j < adjacencyMatrix[0].length; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
