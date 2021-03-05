package linkedlist;

public class CloneLL {
    static class NodeRandom {
        int data;
        NodeRandom random;
        NodeRandom next;

        public NodeRandom(int data){
            this.data = data;
            this.random = null;
            this.next = null;
        }

        @Override
        public String toString() {
            Integer nextdata = this.next != null ? this.next.data : null;
            Integer randomData = this.random != null ? this.random.data : null;
            return "[" + "data=" + data + ", next=" + nextdata +
                    ", random=" + randomData +
                    "]";
        }
    }

    public static NodeRandom cloneLL(NodeRandom node){
        NodeRandom next = null;
        NodeRandom curr = node;

        NodeRandom cloneList = new NodeRandom(-1);
        NodeRandom temp = cloneList;

        while (curr != null) {
            next = curr.next;

            NodeRandom newNode = new NodeRandom(curr.data);
            temp.next = newNode;
            temp = temp.next;

            curr.next = newNode;
            newNode.random = curr;

            curr = next;
        }

        cloneList = cloneList.next;
        temp = cloneList;
        while (temp != null) {
            temp.random = temp.random.random.next;
            temp = temp.next;
        }
        return cloneList;
    }

    private static void printNextRandomList(NodeRandom clone) {
        if (clone == null) {
            return;
        }
        NodeRandom temp = clone;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        NodeRandom head = new NodeRandom(3);
        head.next = new NodeRandom(4);
        head.next.next = new NodeRandom(5);
        head.next.next.next = new NodeRandom(6);
        head.next.next.next.next = new NodeRandom(7);

        // 3 random points to 5
        head.random = head.next.next;

        // 4 random points to 3
        head.next.random = head;

        // 5 and 6 random points to 7
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next.next.next;

        // 7 random points to 4
        head.next.next.next.next.random = head.next;

        System.out.println("Original list : ");
        printNextRandomList(head);

        NodeRandom clone = cloneLL(head);

        System.out.println("\nCloned list : ");
        printNextRandomList(clone);
    }
}
