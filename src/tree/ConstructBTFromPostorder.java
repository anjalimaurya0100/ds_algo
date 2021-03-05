package tree;

import java.util.HashMap;
import java.util.Map;

/*
going by fact that last value of postorder is root

---
make root as last value of post order(lv) array and keep decrementing the pointer
index = look for index of lv in inorder array
recur of root's right from index+1, end
recur of root's left from start, index-1
 */
public class ConstructBTFromPostorder {
    static class Index {
        int index;
    }



    public static Node constructBT(Map<Integer, Integer> inorderMap, int s, int e, int[] postorder, Index pi) {
        if(s > e) {
            return null;
        }

        Node node = new Node(postorder[pi.index]);
        pi.index--;

        int ii = inorderMap.get(node.data);

        if(s == e) {
            return node;
        }
        node.right = constructBT(inorderMap, ii+1, e, postorder, pi);
        node.left = constructBT(inorderMap, s, ii-1, postorder, pi);
        return node;
    }

    public static void inorder(Node node){
        if(node == null){
            return;
        }
        inorder(node.left);
        System.out.println(node.data);
        inorder(node.right);
    }

    public static void main(String[] args) {
        int[] inorder = { 4, 2, 1, 7, 5, 8, 3, 6 };
        int[] postorder = { 4, 2, 7, 8, 5, 6, 3, 1};

        int n = inorder.length;

        Index pi = new Index();
        pi.index = n-1;

        Map<Integer, Integer> inorderMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        Node root = constructBT(inorderMap, 0, n-1, postorder, pi);
        inorder(root);
    }
}
