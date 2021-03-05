package HashHeap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianInStream {
    public static void medianInStream(int[] array) {
        Queue<Integer> minHeap = new PriorityQueue<>(Comparator.naturalOrder());
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        Integer median = 0;
        for (int i = 0; i < array.length; i++) {
            if (minHeap.size() < maxHeap.size()) {
                if (array[i] > median) {
                    minHeap.add(array[i]);
                } else {
                    minHeap.add(maxHeap.remove());
                    maxHeap.add(array[i]);
                }
                median = (minHeap.peek() + maxHeap.peek()) / 2;
            } else if (minHeap.size() > maxHeap.size()) {
                if (array[i] < median) {
                    maxHeap.add(array[i]);
                } else {
                    maxHeap.add(minHeap.remove());
                    minHeap.add(array[i]);
                }
                median = (minHeap.peek() + maxHeap.peek()) / 2;
            } else {
                if (array[i] > median) {
                    minHeap.add(array[i]);
                    median = minHeap.peek();
                } else {
                    maxHeap.add(array[i]);
                    median = maxHeap.peek();
                }
            }
            System.out.println(median);
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
        medianInStream(array);
    }
}
