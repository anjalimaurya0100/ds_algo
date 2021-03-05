package tree;

public class FindNodesFromDisKToGivenNode {
    public static int printkDistanceNode(Node node, Node target, int k) {
        if (node == null) {
            return -1;
        }

        if (node == target) {
            distanceKDown(node, k);
            return 1;
        }

        int dl = printkDistanceNode(node.left, target, k);
        if (dl != -1) {
            if (dl == k) {
                System.out.println(node.data);
            } else {
                distanceKDown(node.right, k - dl - 1);
            }
            return dl + 1;
        }

        int dr = printkDistanceNode(node.right, target, k);
        if (dr != -1) {
            if (dr == k) {
                System.out.println(node.data);
            } else {
                distanceKDown(node.left, k - dr - 1);
            }
            return dr + 1;
        }

        return -1;
    }

    public static void distanceKDown(Node node, int k) {
        if (node == null) {
            return;
        }
        if (k == 0) {
            System.out.println(node.data);
        }
        distanceKDown(node.left, k - 1);
        distanceKDown(node.right, k - 1);
    }

    public static void main(String[] args) {
        Node target = new Node(18);
        Node root = new Node(13);
        root.left = new Node(10);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.left.right.left = new Node(11);
        root.left.right.right = new Node(16);
        root.right = target;
        root.right.right = new Node(20);
        printkDistanceNode(root, target, 3);

    }
}
