package stack_queue;

public class QueueUsingLL {
    Node rear;
    Node front;

    public QueueUsingLL() {
        this.rear = null;
        this.front = null;
    }

    public static void main(String[] args) {
        QueueUsingLL qul = new QueueUsingLL();
        qul.enqueue(1);
        qul.enqueue(2);
        qul.enqueue(3);
        qul.enqueue(4);
        System.out.println(qul.dequeue());
        System.out.println(qul.dequeue());
        System.out.println(qul.dequeue());
        System.out.println(qul.isEmpty());
        System.out.println(qul.dequeue());
        System.out.println(qul.isEmpty());
    }

    public void enqueue(int value) {
        Node node = new Node(value);
        if (this.isEmpty()) {
            front = rear = node;
            return;
        }

        rear.next = node;
        rear = node;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public Node dequeue() {
        if (this.isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        Node node = front;
        front = front.next;
        return node;
    }
}
