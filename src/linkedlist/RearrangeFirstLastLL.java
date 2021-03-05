package linkedlist;

public class RearrangeFirstLastLL {
    public static boolean midReached = false;
    public Node first = null;

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(7);
        list.insert(8);
        list.printList(list.head);

        RearrangeFirstLastLL rr = new RearrangeFirstLastLL();
        rr.first = list.head;

        rr.rearrangeLL(list.head);
        list.printList(list.head);
    }

    public void rearrangeLL(Node last) {
        if (last == null)
            return;

        rearrangeLL(last.next);
        if (midReached)
            return;

        if (first == last || first.next == last) {
            last.next = null;
            midReached = true;
            return;
        }

        last.next = first.next;
        first.next = last;
        first = first.next.next;
    }
}
