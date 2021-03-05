package array;

public class JumpGameProb {
    public static void main(String[] args) {
        int[] array = {1,3,5,8,9,2,6,7,6,8,9};
        int result=count(array);
        System.out.println(result);
    }

    public static int count(int[] array){
        int a = array[0];
        int b = array[0];
        int i = 1;
        int jump= 0;
        while(i< array.length){
            if(i==array.length-1){
                return jump+1;
            }
            a--;
            b--;
            if(array[i]>b){
                b=array[i];
            }
            if(a==0){
                jump++;
                a=b;
            }
            i++;
        }
        return jump;
    }
}
