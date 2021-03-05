package HashHeap;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    private List<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
    }

    private void heapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;

        if (l < this.heap.size() && this.heap.get(l) < this.heap.get(smallest)) {
            smallest = l;
        }

        if (r < this.heap.size() && this.heap.get(r) < this.heap.get(smallest)) {
            smallest = r;
        }

        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    private void swap(int i, int j) {
        int t = this.heap.get(i);
        this.heap.set(i, this.heap.get(j));
        this.heap.set(j, t);
    }

    private int parent(int i) {
        return (i-1)/2;
    }

    private int left(int i) {
        return (2*i)+1;
    }

    private int right(int i) {
        return (2*i)+2;
    }

    public void insert(int value) {
        if (this.heap.size() == 0) {
            this.heap.add(0, value);
            return;
        }

        this.heap.add(value);

        int i = this.heap.size()-1;
        while (i >= 0 && this.heap.get(parent(i)) > this.heap.get(i)) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public int delete(int index) {
        if (this.heap.size() == 1) {
            return this.heap.remove(index);
        }

        swap(index, this.heap.size()-1);
        int value = this.heap.remove(this.heap.size()-1);

        heapify(index);
        return value;
    }

    public static void main(String[] args) {
        MinHeap mh = new MinHeap();
        mh.insert(11);
        mh.insert(3);
        mh.delete(1);
        mh.insert(15);
        mh.insert(5);
        mh.insert(4);
        mh.insert(45);

//        for(Integer val: mh.heap) {
//            System.out.println(val);
//        }

       // System.out.println("del " + mh.delete(0));
        //System.out.println("root " + mh.heap.get(0));

        for(Integer val: mh.heap) {
            System.out.println(val);
        }
    }
}
