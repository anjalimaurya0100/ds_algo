package array;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {8, 4, 12, 3, 25, 6, 9, 13};
        int[] tempArray = new int[array.length];
        mergeSort(array, tempArray, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    // here we are doing sorting  by storing element in result array and then updating to main array.
//    public static void merge(int[] array1, int[] array2, int[] result)
    public static void merge(int[] array, int[] tempArray, int low, int mid, int high) {
        int k = low; // 0
        int i = low; // 0
        int j = mid + 1; // 0
        // update result array
        while (i <= mid && j <= high) { // i < array1.length && j < array2.length
            if (array[i] <= array[j]) {
                tempArray[k++] = array[i++];
            } else {
                tempArray[k++] = array[j++];
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
    }

    // this is dividing array in tow parts then in there sub parts till single element
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