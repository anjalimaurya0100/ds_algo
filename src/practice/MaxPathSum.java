package practice;

public class MaxPathSum {
    static int maxSum = 0;
    static int longestP = 0;

    public static int maxPathSum(Node node) {
        if (node == null) {
            return 0;
        }

        int left = maxPathSum(node.left);
        int right = maxPathSum(node.right);

        int maxValue = Math.max(Math.max(left, right) + node.data, node.data);
        int maxTop = Math.max(maxValue, left + right + node.data);

        maxSum = Math.max(maxTop, maxSum);

        return maxValue;
    }

    public static int diameter(Node node) {
        if (node == null) {
            return 0;
        }

        int left = diameter(node.left);
        int right = diameter(node.right);

        int maxV = Math.max(left, right) + 1;
        int maxT = Math.max(maxV, left + right + 1);
        longestP = Math.max(maxT, longestP);
        return maxV;
    }

    public static void main(String[] args) {
        practice.Node root = new practice.Node(1);
        root.left = new practice.Node(2);
        root.right = new practice.Node(3);
        root.left.right = new practice.Node(4);
        root.right.left = new practice.Node(5);
        root.right.right = new practice.Node(6);
        root.right.left.left = new practice.Node(7);
        root.right.left.left.left = new practice.Node(9);
        root.right.left.right = new practice.Node(8);

        diameter(root);
        System.out.println("Diameter of Binary Tree: " + longestP);

        maxPathSum(root);
        System.out.println("Max Sum of Binary tree: " + maxSum);
    }
}
