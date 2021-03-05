package array;

public class MaxNumberInIncDecArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 4, 3, 2, 1};
        int val = maxNumber(array, 0, array.length - 1);
        System.out.println(val);
    }

    public static int maxNumber(int[] array, int low, int high) {
        if (low == high) {
            return array[low];
        }
        int mid = (low + high) / 2;

        if (high - low == 1) {
            return Math.max(array[low], array[high]);
        }

        if (array[mid - 1] <= array[mid] && array[mid] <= array[mid + 1]) {
            return maxNumber(array, mid + 1, high);
        } else if (array[mid - 1] >= array[mid] && array[mid] >= array[mid + 1]) {
            return maxNumber(array, low, mid - 1);
        } else {
            return array[mid];
        }
    }
}