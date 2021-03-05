package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class AlienDictionary {
    //    LinkedList<Integer>[] adjacencyList;
    Map<Integer, LinkedList<Integer>> adjacencyList;
    boolean[] visited;
    int numberOfVertices;

    public AlienDictionary(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        visited = new boolean[numberOfVertices];
//        adjacencyList = new LinkedList[numberOfVertices];
        adjacencyList = new HashMap<>();
//        for (int i = 0; i < numberOfVertices; i++) {
//            adjacencyList[i] = new LinkedList<>();
//        }
        for (int i = 0; i < numberOfVertices; i++) {
            adjacencyList.put(i, new LinkedList<>());
        }
    }

    public static void main(String[] args) {
        String[] words = {"baa", "abcd", "abca", "cab", "cad"};
        AlienDictionary ad = new AlienDictionary(4);
        ad.buildGraph(words);
        ad.topologicalSort();
    }

    public void buildGraph(String[] words) {
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    addEdge(w1.charAt(j) - 'a', w2.charAt(j) - 'a');
                    break;
                }
            }
        }
    }

    private void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        for (int u = 0; u < this.numberOfVertices; u++) {
            if (!visited[u]) {
                dfs(u, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.println((char) ('a' + stack.pop()));
        }
    }

    private void dfs(int u, Stack<Integer> stack) {
        visited[u] = true;
//        for(Integer v : adjacencyList[u]) {
        for (Integer v : adjacencyList.get(u)) {
            if (!visited[v]) {
                dfs(v, stack);
            }

        }
        stack.add(u);
    }

    private void addEdge(int u, int v) {
//        adjacencyList[u].add(v);
        adjacencyList.get(u).add(v);
    }
}
