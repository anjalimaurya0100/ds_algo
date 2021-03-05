package extra;

import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {1, 2, 3, 4};
        int[] result = mergeArray(array1,array2);
        System.out.println(Arrays.toString(result));
    }

    public static int[] mergeArray(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] <= array2[j])
                result[k++] = array1[i++];
            else
                result[k++] = array2[j++];
        }

        while(i<array1.length){
            result[k++] = array1[i++];
        }
        while(j<array2.length){
            result[k++]=array2[j++];
        }
        return result;
    }
}

