package array;

import java.util.Arrays;

public class NextGreatestNumber {
    public static void main(String[] args) {
        int[] array = {2,1,8,7,6,5};
        nextGreaterNum(array);
    }

    public static void nextGreaterNum(int[] array){
        int i = array.length-1;
        while(i>0){
            if(array[i-1]<array[i]){
                break;
            }
            i--;
        }

        if(i==0){
            return;
        }

        int element = array[i-1];
        int elementIndex = i-1;
        int min = i;
        while(i < array.length) {
            if(array[i] > element && array[i] < array[min]) {
                min = i;
            }
            i++;
        }

        swap(array, elementIndex, min);
        Arrays.sort(array, elementIndex+1, array.length);
//        int[] res = new int[array.length];
//        array.MergeSort.mergeSort(array, res, i, array.length-1);
        System.out.println(Arrays.toString(array));
    }

    public static void swap(int[] array, int i, int j) {
        int c = array[i];
        array[i] = array[j];
        array[j] = c;
    }
}
