package array;

public class KthSmallest {
    public static void main(String[] args) {
        int[] array = {9, 10, 11, 2, 8, 1, 5};
        int k = 5;
        int numIndex = kthSmallest(array, 0, array.length - 1, k - 1);
        System.out.println(array[numIndex]);
    }

    public static int kthSmallest(int[] array, int low, int high, int kIndex) {
        if (low <= high) {
            int pi = partition(array, low, high);
            if (kIndex < pi) {
                return kthSmallest(array, low, pi - 1, kIndex);
            } else if (kIndex > pi) {
                return kthSmallest(array, pi + 1, high, kIndex);
            } else {
                return pi;
            }
        }
        return -1;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int j = low - 1;
        for (int i = low; i < high; i++) {
            if (array[i] < pivot) {
                j++;
                swap(array, i, j);
            }
        }
        swap(array, j + 1, high);
        return j + 1;
    }
}
