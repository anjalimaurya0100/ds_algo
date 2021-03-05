package practice;

public class LeftView {
    int maxLevel;
    boolean isLeft;

    public LeftView() {
        maxLevel = -1;
        isLeft = true;
    }

    public void leftView(Node node, int level) {
        if (node == null) {
            return;
        }
        if (level > maxLevel) {
            System.out.println(node.data);
            maxLevel = level;
        }
        if (isLeft) {
            leftView(node.left, level + 1);
            leftView(node.right, level + 1);
        } else {
            leftView(node.right, level + 1);
            leftView(node.left, level + 1);
        }
    }

    public static void main(String[] args) {
        Node root = new practice.Node(13);
        root.left = new practice.Node(10);
        root.left.left = new practice.Node(8);
        root.left.right = new practice.Node(12);
        root.left.right.left = new practice.Node(11);
        root.left.right.right = new practice.Node(16);
        root.right = new practice.Node(18);
        root.right.right = new practice.Node(20);
        LeftView Lf = new LeftView();
        Lf.leftView(root,0);
    }
}