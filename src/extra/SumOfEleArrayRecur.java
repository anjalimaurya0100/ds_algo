package extra;

public class SumOfEleArrayRecur {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int result = sum(array, 0, array.length - 1);
        System.out.println(result);

    }

    public static int sum(int[] array, int low, int high) {
        if (low == high) {
            return array[low];
        }
        return (array[low] + sum(array, low + 1, high));
    }
}

