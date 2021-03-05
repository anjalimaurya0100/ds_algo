package linkedlist;

public class ReverseLLinKGroup {
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

        ReverseLLinKGroup rr = new ReverseLLinKGroup();
        Node revList = rr.reverseKGroup(list.head, 3);
        list.printList(revList);
    }

    public Node reverseKGroup(Node node, int k) {
        if (node == null || node.next == null)
            return node;

        Node curr = node;
        Node prev = null;
        Node next = null;
        int i = 0;
        while (curr != null && i < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }

        node.next = reverseKGroup(curr, k);
        return prev;
    }
}
