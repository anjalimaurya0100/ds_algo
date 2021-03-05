package linkedlist;

public class LinkedList {
    public Node head = null;

    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public boolean search(int data) {
        Node ptr = head;

        while (ptr != null) {
            if (ptr.data == data)

                return true;

            ptr = ptr.next;
        }
        return false;
    }

    public void delete(int data) {
        Node ptr = head;
        Node prev = null;

        if (ptr != null && ptr.data == data) {
            head = ptr.next;
            return;
        }
        while (ptr != null && ptr.data != data) {
            prev = ptr;
            ptr = ptr.next;
        }
        if (ptr == null)
            return;
        prev.next = ptr.next;
    }

    public void printList(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public Node reverse(Node node) {
        if (node == null || node.next == null)
            return node;

        Node rest = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return rest;
    }

    public Node reverseIterative(Node node){
        Node current = head;
        Node next = null;
        Node previous = null;
        if(node == null){
            return null;
        }
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        node = previous;
        return node;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.printList(list.head);
        System.out.println(list.search(3));
        Node temp = list.head;
        Node n = list.reverse(temp);
        list.printList(n);
        Node n2 = list.reverseIterative(list.head);
        list.printList(n2);
    }
}
