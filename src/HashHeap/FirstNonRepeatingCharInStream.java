package HashHeap;

import linkedlist.DLL;
import linkedlist.DNode;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharInStream {
    public static void firstNonRepeatingCharInStream(char[] charArray) {
        DLL<Character> dll = new DLL<>();
        Map<Character, DNode<Character>> map = new HashMap<>();

        for (Character c : charArray) {
            if (!map.containsKey(c)) {
                dll.insertLast(c);
                map.put(c, dll.tail);
            } else if (map.containsKey(c) && map.get(c) != null) {
                DNode<Character> node = map.get(c);
                map.put(c, null);
                dll.delete(node);
            }

            if (dll.head != null)
                System.out.println(dll.head.data);
            else
                System.out.println("NA");
        }
    }

    public static void main(String[] args) {
        String str = "abcadbedced";
        firstNonRepeatingCharInStream(str.toCharArray());
    }
}
