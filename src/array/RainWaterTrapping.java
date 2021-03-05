package array;

public class RainWaterTrapping {
    public static void main(String[] args) {
        int[] array = {5, 2, 1, 6, 1, 1, 2, 7};
        int n = array.length;
        int[] maxRight = new int[n];
        int max = array[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            if (array[i] > max) {
                max = array[i];
            }
            maxRight[i] = max;
        }

        int sum = 0;
        int maxL = array[0];
        for (int i = 0; i < n; i++) {
            if (array[i] > maxL) {
                maxL = array[i];
            }

            sum = sum + Math.min(maxL, maxRight[i]) - array[i];
        }
        System.out.println(sum);
    }
}