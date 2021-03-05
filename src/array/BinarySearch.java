package array;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {2, 3, 4, 5, 6, 8, 9, 11, 14};
        int index = binarySearch(array, 8, 0, array.length - 1);
        System.out.println(index);

    }

    public static int binarySearch(int[] array, int key, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = (low + (high - low) / 2);

        if (key == array[mid]) {
            return mid;
        } else if (key < array[mid]) {
            return binarySearch(array, key, low, mid - 1);
        } else {
            return binarySearch(array, key, mid + 1, high);
        }
    }
}
