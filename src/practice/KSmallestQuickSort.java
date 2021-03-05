package practice;

public class KSmallestQuickSort {
    public static void main(String[] args) {
        int[] a = {9, 10, 11, 2, 8, 3, 5};
        int kIndex = 6;
        int index = kSmallest(a, 0, a.length - 1, kIndex - 1);
        System.out.println(a[index]);
    }

    public static int kSmallest(int[] a, int low, int high, int kIndex) {
        if (low > high) {
            return -1;
        }
        int pi = partition(a, low, high);
        if (kIndex == pi) {
            return pi;
        } else if (kIndex < pi) {
            return kSmallest(a, low, pi - 1, kIndex);
        } else {
            return kSmallest(a, pi + 1, high, kIndex);
        }

    }

    public static int partition(int[] a, int low, int high) {
        int pivot = a[high];
        int j = low - 1;
        for (int i = low; i < high; i++) {
            if (a[i] < pivot) {
                j++;
                swap(a, i, j);
            }
        }
        swap(a, j + 1, high);
        return j + 1;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }
}
