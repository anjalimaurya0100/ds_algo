package linkedlist;

public class FlattenLL {
    Nodedown head;

    public static void main(String[] args) {
        FlattenLL L = new FlattenLL();
        L.head = L.insert(L.head, 29);
        L.head = L.insert(L.head, 7);
        L.head = L.insert(L.head, 6);
        L.head = L.insert(L.head, 4);

        L.head.next = L.insert(L.head.next, 21);
        L.head.next = L.insert(L.head.next, 12);

        L.head.next.next = L.insert(L.head.next.next, 48);
        L.head.next.next = L.insert(L.head.next.next, 23);
        L.head.next.next = L.insert(L.head.next.next, 18);

        L.head.next.next.next = L.insert(L.head.next.next.next, 44);
        L.head.next.next.next = L.insert(L.head.next.next.next, 41);
        L.head.next.next.next = L.insert(L.head.next.next.next, 36);
        L.head.next.next.next = L.insert(L.head.next.next.next, 24);

        L.head = L.flattenLL(L.head);

        L.printNode();
    }

    public Nodedown flattenLL(Nodedown node) {
        if (node == null || node.next == null) {
            return node;
        }

        Nodedown curr = node;
        Nodedown temp = node.next;
        while (temp != null) {
            curr = merge(curr, temp);
            temp = temp.next;
        }
        return curr;
    }

    public Nodedown merge(Nodedown first, Nodedown second) {
        Nodedown newLL = new Nodedown(-1);
        Nodedown temp = newLL;

        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }

        while (first != null && second != null) {
            if (first.data <= second.data) {
                temp.down = first;
                first = first.down;
            } else {
                temp.down = second;
                second = second.down;
            }
            temp = temp.down;
        }
        if (first == null)
            temp.down = second;
        if (second == null)
            temp.down = first;
        return newLL.down;
    }

    Nodedown insert(Nodedown headPtr, int data) {
        /*Allocate the Node*/
        Nodedown new_node = new Nodedown(data);

        /*Make next of new Node as head */
        new_node.down = headPtr;

        /*Move the head to point to new Node */
        headPtr = new_node;

        /*eturn to link it back */
        return headPtr;
    }

    void printNode() {
        Nodedown temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.down;
        }
        System.out.println();
    }

    static class Nodedown {
        int data;
        Nodedown next;
        Nodedown down;

        public Nodedown(int data) {
            this.data = data;
            this.next = null;
            this.down = null;
        }
    }
}
