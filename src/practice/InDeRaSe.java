package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InDeRaSe {
    ArrayList<Integer> a;
    Map<Integer, Integer> map;

    public InDeRaSe() {
        this.a = new ArrayList<>();
        this.map = new HashMap<>();
    }

    public static void main(String[] args) {
        InDeRaSe obj = new InDeRaSe();
        obj.insert(1);
        obj.insert(2);
        obj.insert(3);
        obj.delete(3);
        obj.insert(4);
        obj.insert(5);

        System.out.println(obj.search(0));
        System.out.println(obj.random());

    }

    public void insert(int v) {
        a.add(v);
        map.put(v, a.size() - 1);
    }

    public void delete(int v) {
        if (map.containsKey(v)) {
            int ai = map.remove(v);
            a.set(ai, a.get(a.size() - 1));
            a.remove(a.size() - 1);
        }
    }

    public int search(int v) {
        if (map.containsKey(v)) {
            return map.get(v);
        }
        return -1;
    }

    public int random() {
        int i = (int) ((Math.random() * 100) % a.size());
        return a.get(i);
    }
}
