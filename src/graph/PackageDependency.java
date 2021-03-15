package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class PackageDependency {
    char[] vertices = {'A', 'B', 'C', 'D'};
    Map<Character, LinkedList<Character>> map;
    HashMap<Character, Integer> visited;
    Stack<Character> stack;

    public PackageDependency() {
        stack = new Stack<>();
        map = new HashMap<>();
        visited = new HashMap<>();
        for (char vertex : vertices) {
            map.put(vertex, new LinkedList<>());
            visited.put(vertex, 0);
        }
    }

    public static void main(String[] args) {
        char[][] courses = {
                {'B', 'A'},
                {'C', 'A'},
                {'D', 'B'},
                {'D', 'C'},
        };
        PackageDependency pd = new PackageDependency();
        for (char[] course : courses) {
            pd.addEdge(course[0], course[1]);
        }
        pd.topologicalSort();
    }

    private void addEdge(char s, char d) {
        map.get(s).add(d);
    }

    public void topology(char c) {
        visited.put(c, 1);
        for (Character newC : map.get(c)) {
            if (visited.get(newC) == 0) {
                topology(newC);
            }

        }
        stack.push(c);
    }

    public void topologicalSort() {
        for (Character k : map.keySet()) {
            if (visited.get(k) == 0) {
                topology(k);
            }
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
