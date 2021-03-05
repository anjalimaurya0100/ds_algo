package tree;

public class SpiralBt {
    Node root;

    public static int height(Node node) {
        if (node == null) {
            return 0;
        }
        int lHeight = height(node.left);
        int rHeight = height(node.right);

        return Math.max(lHeight, rHeight) + 1;
    }

    public static void printGivenLevelNodes(Node node, int level, boolean ltr) {
        if (node == null) {
            return;
        }
        if (level == 1) {
            System.out.print(node.data);
        } else if (level > 1) {
            if (ltr) {
                printGivenLevelNodes(node.left, level - 1, ltr);
                printGivenLevelNodes(node.right, level - 1, ltr);
            } else {
                printGivenLevelNodes(node.right, level - 1, ltr);
                printGivenLevelNodes(node.left, level - 1, ltr);
            }
        }
    }

    public static void printSpiral(Node node) {
        int h = height(node);
        int i;
        if (node == null) {
            return;
        }
        boolean ltr = false;
        for (i = 1; i <= h; i++) {
            printGivenLevelNodes(node, i, ltr);
            ltr = !ltr;
        }
    }

    public static void main(String[] args) {
        SpiralBt tree = new SpiralBt();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(4);
        System.out.println(" ");
        printSpiral(tree.root);
    }
}
