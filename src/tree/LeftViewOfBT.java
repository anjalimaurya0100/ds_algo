package tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfBT {
    public static int maxLevel = -1;
    public static boolean isLeftView = true;

    public static void leftViewRecursive(Node node, int level) {
        if (node == null)
            return;

        if (level > maxLevel) {
            System.out.println(node.data);
            maxLevel = level;
        }

        if (isLeftView) {
            leftViewRecursive(node.left, level + 1);
            leftViewRecursive(node.right, level + 1);
        } else {
            leftViewRecursive(node.right, level + 1);
            leftViewRecursive(node.left, level + 1);
        }
    }

    public static void leftViewIterative(Node node) {
        Queue<Pair<Node, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(node, 0));

        int maxLevel = -1;
        while (!queue.isEmpty()) {
            Pair<Node, Integer> t = queue.poll();
            if (maxLevel < t.second) {
                System.out.print(t.first.data + " ");
                maxLevel = t.second;
            }

            if (t.first.left != null)
                queue.add(new Pair<>(t.first.left, t.second + 1));

            if (t.first.right != null)
                queue.add(new Pair<>(t.first.right, t.second + 1));
        }
        System.out.println();
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
        leftViewRecursive(root, 0);
    }
}
