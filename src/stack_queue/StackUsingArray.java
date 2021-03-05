package stack_queue;

public class StackUsingArray {
    private int[] stack;
    private int top;
    private int capacity;

    public StackUsingArray(int capacity) {
        this.capacity = capacity;
        this.stack = new int[capacity];
        this.top = -1;
    }

    public void push(int value) {
        top++;
        this.stack[top] = value;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int pop() {
        if (this.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        int value = this.stack[top];
        top--;
        return value;
    }

    public static void main(String[] args) {
        StackUsingArray sua = new StackUsingArray(100);
        sua.push(10);
        sua.push(11);
        sua.push(12);
        sua.push(13);
        System.out.println(sua.pop());
        System.out.println(sua.pop());
        System.out.println(sua.pop());
        System.out.println(sua.isEmpty());
        System.out.println(sua.pop());
        System.out.println(sua.isEmpty());
        System.out.println(sua.pop());
    }
}
