package HashHeap;

import tree.Pair;

import java.util.HashMap;
import java.util.Map;

public class FourSum {
    public static void fourSum(int[] array,int target) {
        Map<Integer, Pair<Integer, Integer>> map = new HashMap<>();
        for(int i = 0 ; i<array.length; i++){
            for(int j = i+1; j<array.length;j++){
                map.put(array[i]+array[j], new Pair<>(i, j));
            }
        }

        for(int i = 0 ; i<array.length; i++){
            for(int j = i+1; j<array.length;j++){
                int remaining = target -(array[i]+array[j]);
                if(map.containsKey(remaining)){
                     Pair<Integer,Integer> p = map.get(remaining);
                     if(p.first != i && p.second != i && p.first !=j && p.second !=j){
                         System.out.println(i + " "+ j + " " + p.first + " " + p.second);
                     }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = { 1,5,1,0,6,0};
        fourSum(array,7);
    }
}
