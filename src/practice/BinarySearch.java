package practice;

public class BinarySearch {

    public static int binaryS(int[] a , int num , int s , int e){
         if(s > e){
             return -1;
         }
        int mid = (s+e)/2;
         if(num == a[mid]){
             return mid;
         }else if(num > a[mid]){
             return binaryS(a,num,mid+1,e);
         }else{
             return binaryS(a,num,s,mid-1);
         }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6};
        System.out.println(binaryS(a,2,0,5));
    }
}
