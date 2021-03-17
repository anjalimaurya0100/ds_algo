package practice;

public class freq {
    public static void countFreq(int[] a){
        int n = a.length;
        for(int i = 0 ; i<n ; i++){
            a[i] = a[i]-1;
        }
        for(int i = 0 ; i<a.length;i++){
            a[a[i]%n] = a[a[i]%n]+n;
        }
        for(int i = 0 ; i<n ; i++){
            System.out.println(i+1 + " " + a[i]/n);
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 7, 7, 5, 5, 2};

        countFreq(a);
    }
}
