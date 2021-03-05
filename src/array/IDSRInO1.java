package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
Design a data Structure which support Insert, Delete, Search, Random in O(1) time
 */
public class IDSRInO1 {
    public List<Integer> al;
    public Map<Integer, Integer> hm;

    public IDSRInO1() {
        al = new ArrayList<>();
        hm = new HashMap<>();
    }

    public void insert(int a) {
        al.add(a);
        hm.put(a, al.size()-1);
    }

    public void remove(int a){
        int i = hm.get(a);
        hm.remove(a);
        al.add(i, al.get(al.size()-1));
        al.remove(al.size()-1);
    }

    public int search(int a){
        return hm.get(a);
    }

    public int getRandom(){
        int i = (int) (Math.random()*100) % al.size();
        return al.get(i);
    }

    public static void main(String[] args) {
        IDSRInO1 ds = new IDSRInO1();
        ds.insert(12);
        ds.insert(16);
        ds.insert(14);
        ds.insert(20);
        ds.insert(30);
        System.out.println(ds.search(30));
        ds.remove(14);
        System.out.println(ds.search(20));
        System.out.println(ds.getRandom());
    }
}
