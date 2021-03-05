package practice;

public class TotalRainWater {
    public static int totalWater(int[] a){
        int n = a.length;
        int[] maxRight = new int[n] ;
        int max = a[n-1];
        for(int i = n-1 ; i>=0;i--){
            if(max<a[i]){
                max = a[i];
            }
            maxRight[i] = max;

        }
        int sum = 0;
        int maxL = a[0];
        for(int i = 0 ; i<n ; i++) {
            if (maxL < a[i]) {
                maxL = a[i];
            }

            sum = sum + Math.min(maxL, maxRight[i]) - a[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a = {7, 2, 1, 6};
       System.out.println(totalWater(a));
    }
}
