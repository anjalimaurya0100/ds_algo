package array;

public class SingleEleInArrayWithXor {
    public static void main(String[] args) {
        int[] array = {6, 2, 4, 3, 4, 2, 3};
        int xor = 0;
        for (int i = 0; i < array.length; i++) {
            xor = (xor ^ array[i]);
        }
        System.out.print(xor);
    }
}
