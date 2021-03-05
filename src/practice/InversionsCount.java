package practice;

public class InversionsCount {
    public int mergeSort(int[] a, int low , int high){
        int count = 0;
        if(low == high){
            return 0;
        }
        int mid = (low+high)/2;
        count += mergeSort(a,low,mid);
        count += mergeSort(a,mid+1,high);
        count += merge(a,low,mid,high);
        return count;
    }

    private int merge(int[] a, int low, int mid, int high) {
        int[] temp  = new int[a.length];
        int swap = 0;
        int i = low;
        int j = mid+1;
        int k = low;

        while(i<=mid && j<=high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
                swap += (mid+1)-i;
            }
        }
        while(i<=mid){
            temp[k++] = a[i++];
        }
        while(j<=high){
            temp[k++] = a[j++];
        }

        for(i = low ; i<=high ; i++){
            a[i]=temp[i];
        }
        return swap;
    }

    public static void main(String[] args) {
        int[] array = {1, 20, 6, 4, 5};
        InversionsCount ic = new InversionsCount();

        int c = ic.mergeSort(array, 0, array.length - 1);
        System.out.println(c);
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
