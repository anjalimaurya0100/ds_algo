package practice;

import java.util.*;

public class MergeKSortedArray {
    public static class Node {
        int i;
        int j;
        int value;

        public Node(int i, int j, int value) {
            this.i = i;
            this.j = j;
            this.value = value;
        }
    }

    public static List<Integer> MergeArrays(int[][] a) {
        List<Integer> result = new ArrayList<>();
        Queue<Node> minHeap = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);
        for (int i = 0; i < a.length; i++) {
            minHeap.add(new Node(i,0,a[i][0]));
        }
        while(!minHeap.isEmpty()) {
            Node node = minHeap.remove();
            result.add(node.value);
            if (node.j + 1 < a[node.i].length) {
                minHeap.add(new Node(node.i, node.j + 1, a[node.i][node.j + 1]));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] array = {
                {1, 3, 5, 7},
                {2, 4, 6, 8},
                {0, 9, 10, 11}
        };
        List<Integer> result = MergeArrays(array);
        for (Integer v : result) {
            System.out.println(v);
        }
    }
}