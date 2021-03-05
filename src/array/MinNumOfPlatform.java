package array;

import java.util.Arrays;

public class  MinNumOfPlatform {
    public static void main(String[] args) {
        int[] arrival = { 100, 140, 150, 200, 215, 400 };
        int[] departure = {110, 300, 220, 230, 315, 600};
        MinNumOfPlatform obj = new MinNumOfPlatform();
        int result = obj.minPlatform(arrival,departure);
        System.out.println(result);
    }

    public int minPlatform(int[] arrival , int [] departure){
        Arrays.sort(departure);
        int i = 0;
        int j = 0;
        int platformNeeded=0;
        int maxPlatform =0;
        while(i<arrival.length && j<departure.length){
            if(arrival[i]<departure[j]){
                platformNeeded++;
                i++;
                if(platformNeeded>maxPlatform){
                    maxPlatform = platformNeeded;
                }
            } else {
                platformNeeded--;
                j++;
            }
        }
        return maxPlatform;
    }
}
