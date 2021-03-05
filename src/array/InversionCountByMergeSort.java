package array;

public class InversionCountByMergeSort {
    public static void main(String[] args) {
        int[] array = {1, 20, 6, 4, 5};
        int[] tempArray = new int[array.length];
        int c = mergeSort(array, tempArray, 0, array.length - 1);
        System.out.println(c);
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static int merge(int[] array, int[] tempArray, int low, int mid, int high) {
        int k = low; // 0
        int i = low; // 0
        int j = mid + 1; // 0
        int swaps = 0;
        // update tempArray array
        while (i <= mid && j <= high) { // i < array1.length && j < array2.length
            if (array[i] <= array[j]) {
                tempArray[k++] = array[i++];
            } else {
                tempArray[k++] = array[j++];
                swaps += (mid+1-i);
            }
        }
        //copy remaining items
        while (i <= mid) {
            tempArray[k++] = array[i++];
        }
        while (j <= high) {
            tempArray[k++] = array[j++];
        }

        // update main array
        for (i = low; i <= high; i++) {
            array[i] = tempArray[i];
        }
        return swaps;
    }

    public static int mergeSort(int[] array, int[] tempArray, int low, int high) {
        if (low == high) {
            return 0;
        }
        int c = 0;
        int mid = (low + high) / 2;
        c += mergeSort(array, tempArray, low, mid);
        c += mergeSort(array, tempArray, mid + 1, high);
        c += merge(array, tempArray, low, mid, high);
        return c;
    }
}
