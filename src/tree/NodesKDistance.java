package tree;

public class NodesKDistance {
    public static void distanceK(Node node, int k) {
        if (node == null) {
            return;
        }
        if (k == 0) {
            System.out.println(node.data);

        } else {
            distanceK(node.left, k - 1);
            distanceK(node.right, k - 1);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(13);
        root.left = new Node(10);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.left.right.left = new Node(11);
        root.left.right.right = new Node(16);
        root.right = new Node(18);
        root.right.right = new Node(20);
        distanceK(root, 3);

    }
}
