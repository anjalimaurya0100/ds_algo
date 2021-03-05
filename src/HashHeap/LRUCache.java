package HashHeap;

import linkedlist.DLL;
import linkedlist.DNode;

import java.util.HashMap;
import java.util.Map;


public class LRUCache {
    public Integer capacity;
    public Integer count;
    public DLL<Integer> dll;
    public Map<Integer, DNode<Integer>> map;

    public LRUCache(Integer capacity) {
        this.capacity = capacity;
        this.dll = new DLL<>();
        this.map = new HashMap<>();
        this.count = 0;
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(4);
        lru.refer(1);
        lru.refer(2);
        lru.refer(3);
        lru.refer(1);
        lru.refer(4);
        lru.refer(5);
        lru.refer(2);
        lru.refer(2);
        lru.refer(1);
        lru.display();
    }

    public boolean refer(Integer value) {
        if (map.containsKey(value)) {
            DNode<Integer> node = map.remove(value);
            dll.delete(node);
            dll.insertStart(value);
            map.put(value, dll.head);
            return true;
        } else {
            if (count < capacity) {
                dll.insertStart(value);
                map.put(value, dll.head);
                count++;
            } else {
                map.remove(dll.tail.data);
                dll.delete(dll.tail);
                dll.insertStart(value);
                map.put(value, dll.head);
            }
            return false;
        }
    }

    private void display() {
        DNode<Integer> temp = dll.head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
