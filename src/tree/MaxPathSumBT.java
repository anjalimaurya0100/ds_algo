package tree;

public class MaxPathSumBT {
    static int maxSum = 0;
    static int diameter = 0;

    public static int maxPathSum(Node node){
        if(node == null){
            return 0;
        }
        int left = maxPathSum(node.left);
        int right = maxPathSum(node.right);

        int maxValue = Math.max(Math.max(left , right)+node.data , node.data);
        int maxTop = Math.max(maxValue,left+right+node.data);

        maxSum = Math.max(maxSum,maxTop);

        return maxValue;
    }

    public static int diameterOfBt(Node node){
        if(node == null){
            return 0;
        }
        int left  = diameterOfBt(node.left);
        int right  = diameterOfBt(node.right);

        int maxValue = Math.max(left,right)+ 1;
        int maxTop = Math.max(left+right+1, maxValue);

        diameter = Math.max(diameter,maxTop);
        return maxValue;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.left.left = new Node(9);
        root.right.left.right = new Node(8);

        diameterOfBt(root);
        System.out.println("Diameter of Binary Tree: " + diameter);

        maxPathSum(root);
        System.out.println("Max Sum of Binary tree: " + maxSum);
    }
}
