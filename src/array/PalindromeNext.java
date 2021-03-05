package array;

import java.util.Arrays;

public class PalindromeNext {
    public static void main(String[] args) {
        int[] array = {1,2,9,3,7,2,1};
        // todo - check for aal 9s

        int n = array.length;
        int mid = n/2;
        int l = mid - 1;
        int r = n%2 == 0 ? mid : mid+1;
        boolean leftSmall = false; // add value 1 to mid and propagate to msb
        while (l >= 0 && array[l] == array[r]) {
            l--;
            r++;
        }

        if (l < 0 || array[l] < array[r])
            leftSmall = true;

        while (l >= 0) {
            array[r++] = array[l--];
        }

        if (leftSmall) {
            int carry = 1;
            if(n%2 == 1) {
                array[mid] += 1;
                carry = array[mid]/10;
                array[mid] %= 10;
            }
            l = mid-1;
            r = n%2 == 0 ? mid : mid+1;

            while(l >= 0 && carry > 0) {
                array[l] += carry;
                carry = array[l]/10;
                array[l] %= 10;
                array[r++] = array[l--];
            }
        }

        System.out.println(Arrays.toString(array));
    }
}
