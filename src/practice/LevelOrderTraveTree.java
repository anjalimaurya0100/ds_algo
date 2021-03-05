package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraveTree {

    public static void leveOT(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            Node t = q.poll();
            System.out.println(t.data);
            if (t.left != null) {
                q.add(t.left);
            }
            if (t.right != null) {
                q.add(t.right);
            }
        }
    }

    public static void reverseLT(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> q2 = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        q2.add(node);
        while (!q2.isEmpty()) {
            Node temp = q2.poll();
            stack.push(temp.data);
            if (temp.left != null) {
                q2.add(temp.left);
            }
            if (temp.right != null) {
                q2.add(temp.right);
            }
        }
        while (!stack.isEmpty()) {
            int result = stack.pop();
            System.out.println(result);
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
        System.out.println("level order traversal");
        leveOT(root);
        System.out.println("reverse level traversal");
        reverseLT(root);
    }
}
