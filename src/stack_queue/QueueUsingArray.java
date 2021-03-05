package stack_queue;

public class QueueUsingArray {
    private int[] queue;
    private int rear;
    private int front;
    private int capacity;

    public QueueUsingArray(int capacity){
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = 0;
        this.rear = 0;
    }

    public boolean isEmpty(){
        return rear-front ==0;
    }



    public void enqueue (int value){

        this.queue[rear]=value;
        rear++;
    }

    public int dequeue(){
        if(this.isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        int value  = this.queue[front];
        front++;
        return value;
    }

    public static void main(String[] args) {
        QueueUsingArray qua = new QueueUsingArray(5);
        qua.enqueue(1);
        qua.enqueue(2);
        qua.enqueue(3);
        qua.enqueue(4);
        System.out.println(qua.dequeue());
        System.out.println(qua.dequeue());
        System.out.println(qua.dequeue());
        System.out.println(qua.isEmpty());
        System.out.println(qua.dequeue());
        System.out.println(qua.isEmpty());


    }
}
