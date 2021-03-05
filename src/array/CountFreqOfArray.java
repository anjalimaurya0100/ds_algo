package array;

public class CountFreqOfArray {
    public static void main(String[] args) {
        int[] array = {5, 2, 7, 7, 5, 5, 2};
        int n = array.length;
        for (int i = 0; i < n; i++) {
            array[i] = array[i] - 1;
        }
        for (int i = 0; i < n; i++) {
            array[array[i]% n]= array[array[i]%n]+n;
        }
        for(int i = 0 ; i<n;i++){
            System.out.println(i+1 + " -> " + array[i]/n);
        }
    }
}
