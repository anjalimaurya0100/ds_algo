package HashHeap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            char[] charCount = new char[26];
            for (int i = 0; i < str.length(); i++) {
                charCount[str.charAt(i) - 'a']++;
            }

            String ns = new String(charCount);
            if (map.containsKey(ns)) {
                map.get(ns).add(str);
            } else {
                List<String> l = new ArrayList<>();
                l.add(str);
                map.put(ns, l);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strings = {"abc", "cab", "listen", "silent", "pen", "fired", "fried"};
        List<List<String>> result = groupAnagrams(strings);
        for (List<String> list : result) {
            for (String str : list) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
}
