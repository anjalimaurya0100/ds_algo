package stack_queue;

import java.util.Stack;

public class PushPopMinO1 {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public PushPopMinO1() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(Integer value) {
        stack.push(value);
        if (minStack.isEmpty()) {
            minStack.push(value);
        } else {
            if (minStack.peek() > value) {
                minStack.push(value);
            }
        }
    }

    public Integer pop() {
        Integer value = stack.pop();
        if(minStack.peek().equals(value)) {
            minStack.pop();
        }
        return value;
    }

    public Integer getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        PushPopMinO1 ds = new PushPopMinO1();
        ds.push(4);
        ds.push(-1);
        ds.push(2);
        ds.push(-3);
        ds.push(0);
        System.out.println(ds.getMin());
        ds.pop();
        ds.pop();
        ds.pop();
        System.out.println(ds.getMin());
    }
}
