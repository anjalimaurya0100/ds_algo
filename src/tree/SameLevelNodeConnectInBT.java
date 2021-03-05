package tree;

public class SameLevelNodeConnectInBT {
    public static class Node {
        int data;
        Node left;
        Node right;
        Node next;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.next = null;
        }
    }

    public static void linkNode(Node root){
        if(root==null){
            return;
        }

        linkNode(root.next);

        if(root.left!= null){
            root.left.next = (root.right !=null ? root.right: findNextNode(root));
        }

        if(root.right!=null){
            root.right.next = findNextNode(root);
        }

        linkNode(root.left);
        linkNode(root.right);
    }

    private static Node findNextNode(Node root) {
        if(root==null || root.next==null){
            return null;
        }

        if(root.next.left !=null) {
            return root.next.left;
        }

        if(root.next.right!=null){
            return root.next.right;
        }

        return findNextNode(root.next);
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.left.left.right = new Node(7);




    }


}