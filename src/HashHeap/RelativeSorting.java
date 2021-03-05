package HashHeap;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class RelativeSorting {
    public static void relativeSorting(int[] first, int[] second) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int c : first) {
            if (map.containsKey(c)) {
                int count = map.get(c);
                map.put(c, count + 1);
            } else {
                map.put(c, 1);
            }
        }

        int i = 0;
        for (int c : second) {
            if (map.containsKey(c)) {
                int count = map.get(c);
                while (count > 0) {
                    first[i] = c;
                    count--;
                    i++;
                }
                map.remove(c);
            }
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int count = e.getValue();
            while (count > 0) {
                first[i] = e.getKey();
                count--;
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] first = {2,3,4,5,2,3,4,4,1};
        int[] second = {3,2};
        relativeSorting(first,second);
        System.out.println(Arrays.toString(first));
    }
}
