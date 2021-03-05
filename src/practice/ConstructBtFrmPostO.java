package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ConstructBtFrmPostO {
    public static class Index {
        int index;
    }

    public static void main(String[] args) {
        int[] inorder = {4, 2, 1, 7, 5, 8, 3, 6};
        int[] postorder = {4, 2, 7, 8, 5, 6, 3, 1};
        int n = inorder.length;
        Index pi = new Index();
        pi.index = n - 1;

        Node root = constructBT(inorder, postorder, 0, n - 1, pi);
        inOrder(root);

    }

    public static Node constructBT(int[] inorder, int[] postorder, int s, int e, Index pi) {
        if (s > e) {
            return null;
        }
        Map<Integer, Integer> inoMap = new TreeMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inoMap.put(inorder[i], i);
        }
        Node node = new Node(postorder[pi.index]);
        pi.index--;

        int inI = inoMap.get(node.data);

        if (s == e) {
            return node;
        }
        node.right = constructBT(inorder, postorder, inI + 1, e, pi);
        node.left = constructBT(inorder, postorder, s, inI - 1, pi);
        return node;
    }

    public static void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }
}
