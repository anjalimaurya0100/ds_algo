package tree;

public class IdenticalAndMirrorBT {
    public static boolean mirrorBt(Node a, Node b){
        if(a == null && b== null){
            return true;
        }

        if(a== null || b==null){
            return false;
        }
        return a.data == b.data && mirrorBt(a.left,b.right) && mirrorBt(a.right,b.left);
    }

    public static boolean identicalBt(Node a, Node b){
        if(a == null && b== null){
            return true;
        }

        if(a== null || b==null){
            return false;
        }
        return a.data == b.data && identicalBt(a.left,b.left) && identicalBt(a.right,b.right);
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(1);
        a.left = new Node(2);
        a.right = new Node(3);
        a.left.left = new Node(4);
        a.left.right = new Node(5);

        b.left = new Node(3);
        b.right = new Node(2);
        b.right.left = new Node(5);
        b.right.right = new Node(4);
        System.out.println(mirrorBt(a,b));
        System.out.println(identicalBt(a,a));

    }
}
