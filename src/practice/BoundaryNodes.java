package practice;


public class BoundaryNodes {
    Node root;

    public static void leafNode(Node node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            System.out.println(node.data);
        }
        leafNode(node.left);
        leafNode(node.right);
    }

    public static void internalLeft(Node node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            return;
        }
        System.out.println(node.data);
        if (node.left == null) {
            internalLeft(node.right);
        } else {
            internalLeft(node.left);
        }
    }

    public static void internalRight(Node node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            return;
        }
        System.out.println(node.data);
        if (node.right == null) {
            internalLeft(node.left);
        } else {
            internalLeft(node.right);
        }
    }

    public static void printBt(Node node) {
        System.out.println(node.data);

        internalLeft(node.left);
        leafNode(node);
        internalRight(node.right);
    }

    public static void main(String[] args) {
        BoundaryNodes tree = new BoundaryNodes();
        tree.root = new practice.Node(20);
        tree.root.left = new practice.Node(8);
        tree.root.right = new practice.Node(22);
        tree.root.right.right = new practice.Node(25);
        tree.root.left.left = new practice.Node(4);
        tree.root.left.right = new practice.Node(12);
        tree.root.left.right.left = new practice.Node(10);
        tree.root.left.right.right = new practice.Node(14);
        tree.root.left.right.left.left = new practice.Node(17);
        printBt(tree.root);
    }

}
