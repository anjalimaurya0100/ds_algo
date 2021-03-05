package linkedlist;

public class DLL<T> {
    public DNode<T> head = null;
    public DNode<T> tail = null;

    public static void main(String[] args) {
        DLL<Integer> dlist = new DLL<>();
        dlist.insertLast(1);
        dlist.insertLast(2);
        dlist.insertLast(3);
        dlist.insertLast(4);
        dlist.insertLast(5);
        dlist.insertLast(6);
        dlist.printList();
        dlist.delete(dlist.head);
        dlist.delete(dlist.tail);
        dlist.delete(dlist.head.next.next);
        dlist.printList();
    }

    public void insertLast(T data) {
        DNode<T> newNode = new DNode<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            head.prev = null;
            tail.next = null;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            tail.next = null;
        }
    }

    public void insertStart(T data) {
        DNode<T> newNode = new DNode<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            head.prev = null;
            tail.next = null;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void printList() {
        DNode<T> temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void delete(DNode<T> node) {
        if (node.next == null && node.prev == null) {
            this.head = null;
            this.tail = null;
        } else if (node.prev == null) {
            node.next.prev = null;
            this.head = node.next;
        } else if (node.next == null) {
            node.prev.next = null;
            this.tail = node.prev;
        } else {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
    }
}
