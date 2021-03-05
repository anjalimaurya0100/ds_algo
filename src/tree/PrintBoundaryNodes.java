package tree;

public class PrintBoundaryNodes {
    Node root;

    public static void main(String[] args) {
        PrintBoundaryNodes tree = new PrintBoundaryNodes();

        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.right.right = new Node(25);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        tree.root.left.right.left.left = new Node(17);
        tree.printBoundaryNodes(tree.root);

    }

    public void leafNode(Node node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            System.out.println(node.data);
        }
        leafNode(node.left);
        leafNode(node.right);
    }

    public void leftInternalNode(Node node) {
        if (node == null)
            return;
        if (node.left == null && node.right == null)
            return;
        System.out.println(node.data);
        if (node.left == null) {
            leftInternalNode(node.right);
        } else {
            leftInternalNode(node.left);
        }

    }

    public void rightInternalNode(Node node) {
        if (node == null)
            return;
        if (node.left == null && node.right == null)
            return;
        System.out.println(node.data);
        if (node.right == null) {
            rightInternalNode(node.left);
        } else {
            rightInternalNode(node.right);

        }
    }

    public void printBoundaryNodes(Node node) {
        System.out.println(node.data);

        leftInternalNode(node.left);

        leafNode(node);

        rightInternalNode(node.right);
    }
}
