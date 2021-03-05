package stack_queue;

import com.sun.source.tree.LiteralTree;

import java.util.*;

public class SlidingWindowByDequeue {
    public static List<Integer> maxElementInSlidingWindow(List<Integer> array, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        int i = 0;

        while(i < array.size()) {
            // remove elements from starting which are not in current window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.removeFirst();
            }

            // remove all small elements from last smaller than current
            while (!dq.isEmpty() && array.get(dq.peekLast()) <= array.get(i)) {
                dq.removeLast();
            }
            dq.addLast(i);
            i++;
            if (i >= k) {

            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(8, 10, 6, 7, 5, 17, 14, 87, 15);
        List<Integer> result = maxElementInSlidingWindow(array, 3);
        for(Integer val: result) {
            System.out.println(val);
        }
    }
}
