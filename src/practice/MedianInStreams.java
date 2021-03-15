package practice;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianInStreams {

    public static void medianStreams(int[] a){
        Queue<Integer> minHeap = new PriorityQueue<>(Comparator.naturalOrder());
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int median = 0;
        for(int i = 0; i<a.length; i++){
            if(minHeap.size()< maxHeap.size()){
                if(a[i] > median){
                    minHeap.add(a[i]);
                }else{
                    minHeap.add(maxHeap.remove());
                    maxHeap.add(a[i]);
                }
                median = (minHeap.peek()+maxHeap.peek())/2;
            }
            else if(minHeap.size() > maxHeap.size()){
                if(a[i] < median){
                    maxHeap.add(a[i]);
                }else{
                    maxHeap.add(minHeap.remove());
                    minHeap.add(a[i]);
                }
                median = (minHeap.peek()+maxHeap.peek())/2;
            }else{
                if(a[i]>median){
                    minHeap.add(a[i]);
                    median = minHeap.peek();
                }else{
                    maxHeap.add(a[i]);
                    median = maxHeap.peek();
                }
            }
            System.out.println(median);
        }
    }
    public static void main(String[] args) {
        int[] array = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
        medianStreams(array);
    }
}
