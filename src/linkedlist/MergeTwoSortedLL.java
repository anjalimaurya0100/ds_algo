package linkedlist;

public class MergeTwoSortedLL {
    public static void main(String[] args) {
        System.out.println("LL first");
        LinkedList list1 = new LinkedList();
        list1.insert(1);
        list1.insert(5);
        list1.insert(6);
        list1.printList(list1.head);

        System.out.println("LL second");
        LinkedList list2 = new LinkedList();
        list2.insert(2);
        list2.insert(3);
        list2.insert(4);
        list2.printList(list2.head);

        System.out.println("LL merged");
        MergeTwoSortedLL mm = new MergeTwoSortedLL();
        Node newLL = mm.merge(list1.head, list2.head);
        mm.printList(newLL);
    }

    public Node merge(Node first, Node second) {
        Node newLL = new Node(-1);
        Node temp = newLL;

        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }

        while (first != null && second != null) {
            if (first.data <= second.data) {
                temp.next = first;
                first = first.next;
            } else {
                temp.next = second;
                second = second.next;
            }
            temp = temp.next;
        }
        if (first == null)
            temp.next = second;
        if (second == null)
            temp.next = first;
        return newLL.next;
    }

    public void printList(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
