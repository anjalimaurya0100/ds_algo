package array;

import java.util.Arrays;

public class Sort012Array {
    public static void main(String[] args) {
        int[] array = {0, 2, 0, 1, 1, 0};
        sortArray(array, 0, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void sortArray(int[] array, int left, int mid, int right) {
        while (mid <= right) {
            if (array[mid] == 2) {
                swap(array, mid, right);
                right--;
            } else if (array[mid] == 0) {
                swap(array, mid, left);
                left++;
                mid++;
            } else {
                mid++;
            }
        }
    }

    public static void swap(int[] array, int i, int j) {
        int c = array[i];
        array[i] = array[j];
        array[j] = c;
    }
}
