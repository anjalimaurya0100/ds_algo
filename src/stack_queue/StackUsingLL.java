package stack_queue;

public class StackUsingLL {
    Node top;

    public StackUsingLL() {
        this.top = null;
    }

    public static void main(String[] args) {
        StackUsingLL sul = new StackUsingLL();
        sul.push(10);
        sul.push(11);
        sul.push(12);
        sul.push(13);
        System.out.println(sul.pop());
        System.out.println(sul.pop());
        System.out.println(sul.pop());
        System.out.println(sul.isEmpty());
        System.out.println(sul.pop());
        System.out.println(sul.isEmpty());
        System.out.println(sul.pop());
    }

    public void push(int value) {
        Node node = new Node(value);
        node.next = top;
        top = node;
    }

    public Node pop() {
        if (this.isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        Node node = top;
        top = top.next;
        return node;
    }

    public boolean isEmpty() {
        return top == null;
    }
}