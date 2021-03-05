package tree;

import java.util.Map;
import java.util.TreeMap;

public class TreeBottomView {
    Node root;

    public static void verticalSum(Node node, int d, Map<Integer, Integer> map) {
        if (node == null) {
            return;
        }
        map.put(d, map.getOrDefault(d, 0) + node.data);
        verticalSum(node.left, d - 1, map);
        verticalSum(node.right, d + 1, map);
    }

    public static void printTopNodes(Node node, int h, int d, Map<Integer, Pair<Integer, Integer>> map) {

        if (node == null) {
            return;
        }

        if (!map.containsKey(d)) {
            map.put(d, new Pair<>(node.data, h));
        } else {
            Pair<Integer, Integer> p = map.get(d);
            if (p.second > h) {
                map.put(d, new Pair<>(node.data, h));
            }
        }
        printTopNodes(node.left, h + 1, d - 1, map);
        printTopNodes(node.right, h + 1, d + 1, map);
    }

    public static void printBottomView(Node node, int h, int d, Map<Integer, Pair<Integer, Integer>> map) {
        if (node == null) {
            return;
        }

        if (!map.containsKey(d)) {
            map.put(d, new Pair<>(node.data, h));
        } else {
            Pair<Integer, Integer> p = map.get(d);
            if (p.second < h) {
                map.put(d, new Pair<>(node.data, h));
            }
        }

        printBottomView(node.left, h + 1, d - 1, map);
        printBottomView(node.right, h + 1, d + 1, map);
    }

    public static void main(String[] args) {
        TreeBottomView tree = new TreeBottomView();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.left.right.right = new Node(5);
        tree.root.left.right.right.right = new Node(6);

        Map<Integer, Integer> map3 = new TreeMap<>();
        verticalSum(tree.root, 0, map3);
        System.out.println("Bottom view: ");
        for (Map.Entry<Integer, Integer> e : map3.entrySet()) {
            System.out.println(e.getValue());
        }

        Map<Integer, Pair<Integer, Integer>> map1 = new TreeMap<>();
        System.out.println("Bottom view: ");
        printBottomView(tree.root, 0, 0, map1);

        for (Map.Entry<Integer, Pair<Integer, Integer>> e : map1.entrySet()) {
            System.out.println(e.getValue().first);
        }

        Map<Integer, Pair<Integer, Integer>> map2 = new TreeMap<>();
        System.out.println("Top view: ");
        printTopNodes(tree.root, 0, 0, map2);

        for (Map.Entry<Integer, Pair<Integer, Integer>> e : map2.entrySet()) {
            System.out.println(e.getValue().first);
        }
    }
}

