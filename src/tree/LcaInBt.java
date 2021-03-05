package tree;

public class LcaInBt {
    public static Node lcaVar = null;

    public static Node lcaInBt(Node node, int a, int b) {
        if (node == null)
            return null;

        if (node.data == a || node.data == b)
            return node;

        Node left = lcaInBt(node.left, a, b);
        Node right = lcaInBt(node.right, a, b);

        if (left != null && right != null)
            return node;

        return (left != null ? left : right);
    }

    public static boolean lcaInBtVariation(Node node, int a, int b) {
        if (node == null)
            return false;

        if (node.data == a || node.data == b)
            return true;

        boolean left = lcaInBtVariation(node.left, a, b);
        boolean right = lcaInBtVariation(node.right, a, b);

        if (left && right) {
            lcaVar = node;
            return true;
        }

        return left || right;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.left.left = new Node(9);
        root.right.left.right = new Node(8);
        Node lca = lcaInBt(root, 9, 6);
        System.out.println(lca.data);
        lcaInBtVariation(root, 9, 6);
        System.out.println(lcaVar.data);
    }
}
