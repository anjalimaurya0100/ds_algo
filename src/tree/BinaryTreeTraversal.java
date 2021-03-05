package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeTraversal {
    public static void preorder(Node node) {
        if (node == null)
            return;

        System.out.println(node.data);
        preorder(node.left);
        preorder(node.right);
    }

    public static void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.println(node.data);
        inorder(node.right);
    }

    public static void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.println(node.data);
    }

    public static void levelOrderTraversal(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node t = queue.poll();
            System.out.print(t.data + " ");

            if (t.left != null)
                queue.add(t.left);

            if (t.right != null)
                queue.add(t.right);
        }
        System.out.println();
    }

    public static void reverseLevelOrderTraversal(Node node) {
        Queue<Node> queue = new LinkedList<>();
        Stack<Node> stack = new Stack<>();

        queue.add(node);

        while (!queue.isEmpty()) {
            Node t = queue.remove();
            stack.push(t);

            if (t.right != null)
                queue.add(t.right);

            if (t.left != null)
                queue.add(t.left);
        }

        while (!stack.isEmpty()) {
            Node t = stack.pop();
            System.out.print(t.data + " ");
        }

        System.out.println();
    }

    public static int sumOfNodeData(Node node) {
        if (node == null) {
            return 0;
        }
        return node.data + sumOfNodeData(node.left) + sumOfNodeData(node.right);
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
        System.out.println("preorder result");
        preorder(root);
        System.out.println("inorder result");
        inorder(root);
        System.out.println("postorder result");
        postorder(root);
        System.out.println("level order result");
        levelOrderTraversal(root);
        System.out.println("reverse level order result");
        reverseLevelOrderTraversal(root);
        int sum = sumOfNodeData(root);
        System.out.println("Sum of nodes " + sum);
    }
}
