package stack_queue;

import java.util.Stack;

public class HistogramByStack {
    public static int findHistogram(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int maxArea = 0;
        int maxTemp;
        int top;

        while (i < array.length) {
            if (stack.isEmpty() || array[stack.peek()] <= array[i]) {
                stack.push(i);
                i++;
            } else {
                top = stack.pop();
                maxTemp = array[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);

                if (maxArea < maxTemp) {
                    maxArea = maxTemp;
                }
            }
        }

        while (!stack.isEmpty()) {
            top = stack.pop();
            maxTemp = array[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);


            if (maxArea < maxTemp) {
                maxArea = maxTemp;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] array = {2,4,6,8,1,1};
        int result = findHistogram(array);
        System.out.println("Maximum area: " + result);

    }
}

