package HashHeap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedArrays {
    public static List<Integer> mergeKSortedArrays(int[][] arrays) {
        List<Integer> result = new ArrayList<>();
        Queue<Node> minHeap = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);
        for (int i = 0; i < arrays.length; i++) {
            minHeap.add(new Node(i, 0, arrays[i][0]));
        }

        while (!minHeap.isEmpty()) {
            Node node = minHeap.remove();
            result.add(node.value);

            if (node.j + 1 < arrays[node.i].length) {
                minHeap.add(new Node(node.i, node.j + 1, arrays[node.i][node.j + 1]));
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
        List<Integer> result = mergeKSortedArrays(array);
        for (Integer v : result) {
            System.out.println(v);
        }
    }

    static class Node {
        int value; // j th value of i th row
        int i; // i th row
        int j; // j index

        public Node(int i, int j, int value) {
            this.i = i;
            this.j = j;
            this.value = value;
        }
    }
}
