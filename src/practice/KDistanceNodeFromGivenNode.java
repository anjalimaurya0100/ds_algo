package practice;

public class KDistanceNodeFromGivenNode {
    public static void main(String[] args) {
        practice.Node target = new practice.Node(18);
        practice.Node root = new practice.Node(13);
        root.left = new practice.Node(10);
        root.left.left = new practice.Node(8);
        root.left.right = new practice.Node(12);
        root.left.right.left = new practice.Node(11);
        root.left.right.right = new practice.Node(16);
        root.right = target;
        root.right.right = new practice.Node(20);
        kDistance(root, target,3);
    }

    public static int kDistance(Node node, Node target, int k) {
        if (node == null) {
            return -1;
        }
        if (node == target) {
            distanceDown(node, k);
            return 1;
        }
        int dl = kDistance(node.left, target, k);
        if (dl != -1) {
            if (dl == k) {
                System.out.println(node.data);
            } else {
                distanceDown(node.right, k - dl - 1);
            }
            return dl + 1;
        }
        int dr = kDistance(node.right, target, k);
        if (dr != -1) {
            if (dr == k) {
                System.out.println(node.data);
            } else {
                distanceDown(node.left, k - dr - 1);
            }
            return dr + 1;
        }
        return -1;
    }

    private static void distanceDown(Node node, int k) {
        if (node == null) {
            return;
        }
        if (k == 0) {
            System.out.println(node.data);
        }
        distanceDown(node.left, k - 1);
        distanceDown(node.right, k - 1);

    }
}
