package tree;

import java.util.HashMap;
import java.util.Map;

public class SerializeDeserializeBT {
    static int pIndex;
    Node root;

    public static void main(String[] args) {
        SerializeDeserializeBT tree = new SerializeDeserializeBT();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(4);
        tree.serialize(tree.root);

        int[] in = {7, 2, 6, 1, 5, 3, 4};
        int[] pre = {1, 2, 7, 6, 5, 3, 4};

        Node resultTree = tree.deserialize(in, pre);
        tree.serialize(resultTree);
    }

    public void serialize(Node node) {
        System.out.println("InOrder Array");
        this.inOrder(node);
        System.out.println();

        System.out.println("preOrder Array");
        this.preOrder(node);
        System.out.println();
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        inOrder(node.right);
    }

    public Node deserialize(int[] inO, int[] pO) {
        int n = inO.length;

        pIndex = 0;

        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inO.length; i++) {
            inOrderMap.put(inO[i], i);
        }
        return constructBt(inOrderMap, 0, inO.length - 1, pO);
    }

    private Node constructBt(Map<Integer, Integer> inOrderMap, int s, int e, int[] pO) {
        if (s > e) {
            return null;
        }
        Node node = new Node(pO[pIndex]);
        pIndex++;
        int ii = inOrderMap.get(node.data);

        if (s == e) {
            return node;
        }
        node.left = constructBt(inOrderMap, s, ii - 1, pO);
        node.right = constructBt(inOrderMap, ii + 1, e, pO);

        return node;
    }

}
