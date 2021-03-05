package practice;

import java.util.Map;
import java.util.TreeMap;

public class TreeBottomView {
    Node root;
    Map<Integer, Pair<Integer, Integer>> map;
    int height;
    int dia;

    TreeBottomView() {
        map = new TreeMap<>();
        int height = 0;
        int dia = 0;
    }

    public static void main(String[] args) {
        TreeBottomView tree = new TreeBottomView();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.left.right.right = new Node(5);
        tree.root.left.right.right.right = new Node(6);


        tree.treeBottom(tree.root, tree.map, 0, 0);
        for (Pair<Integer, Integer> v : tree.map.values()) {
            System.out.println(v.first);
        }
    }

    public void treeBottom(Node node, Map<Integer, Pair<Integer, Integer>> map, int dia, int height) {
        if (node == null) {
            return;
        }
        if (!map.containsKey(dia)) {
            map.put(dia, new Pair<>(node.data, height));
        } else {
            Pair<Integer, Integer> p = map.get(dia);
            if (p.second < height) {
                map.put(dia, new Pair<>(node.data, height));
            }
        }
        treeBottom(node.left, map, dia - 1, height + 1);
        treeBottom(node.right, map, dia + 1, height + 1);
    }
}
