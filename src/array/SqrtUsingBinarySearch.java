package array;

public class SqrtUsingBinarySearch {
    public static void main(String[] args) {
        double num = 3;
        double result = sqrt(num,0,num);
        System.out.println("Calculated " + result);
        System.out.println("Expected " + Math.sqrt(num));
    }
    public static double sqrt(double num , double low , double high){
        if(low>high){
            return -1;
        }
        double mid = (low+high)/2;
        if (Math.abs(mid*mid - num) <= 0.001){
            return mid;
        }
        if(mid*mid>num){
            return sqrt(num,low,mid-0.0001);
        }else {
            return sqrt(num,mid+0.0001,high);
        }
    }
}
