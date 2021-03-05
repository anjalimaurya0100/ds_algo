package extra;

public class MergeSortPractice {
    public static void main(String[] args) {
        int[] array = {8, 4, 12, 3, 25, 6, 9, 13};
        int[] tempArray = new int[array.length];
        mergeSort(array, tempArray, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void merge(int[] array, int[] tempArray, int low, int mid, int high) {
        int i = low;
        int k = low;
        int j = mid + 1;
        while (i <= mid && j <= high) {
            if (array[i] <= array[j]) {
                tempArray[k++] = array[i++];
            } else {
                tempArray[k++] = array[j++];
            }
        }
        while (i <= mid) {
            tempArray[k++] = array[i++];
        }
        while (j <= high) {
            tempArray[k++] = array[j++];
        }
        for (i = low; i <= high; i++) {
            array[i] = tempArray[i];
        }

    }

    public static void mergeSort(int[] array, int[] tempArray, int low, int high) {
        if (low == high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(array, tempArray, low, mid);
        mergeSort(array, tempArray, mid + 1, high);
        merge(array, tempArray, low, mid, high);
    }
}
