package HashHeap;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
    private List<Integer> heap;

    public MaxHeap() {
        this.heap = new ArrayList<>();
    }

    public void insert(int value) {
        if (this.heap.size() == 0) {
            this.heap.add(0, value);
            return;
        }

        this.heap.add(value);

        int i = this.heap.size() - 1;
        while (i >= 0 && this.heap.get(parent(i)) < heap.get(i)) {
            swap(i, parent(i));
            i = parent(i);
        }

    }

    public void swap(int i, int j) {
        int t = this.heap.get(i);
        this.heap.set(i, this.heap.get(j));
        this.heap.set(j, t);
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return (2 * i) + 1;
    }

    private int rightChild(int i) {
        return (2 * i) + 2;
    }

    public int delete(int index) {
        if (this.heap.size() == 1) {
            this.heap.remove(index);
        }
        swap(index, this.heap.size() - 1);
        int value = this.heap.remove(this.heap.size() - 1);

        heapify(index);
        return value;
    }

    public void heapify(int i) {
        int l = leftChild(i);
        int r = rightChild(i);
        int largest = i;

        if (l < heap.size() && this.heap.get(l) > this.heap.get(largest)) {
            largest = l;
        }
        if (r < heap.size() && this.heap.get(r) > this.heap.get(largest)) {
            largest = r;
        }
        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    public static void main(String[] args) {
        MaxHeap mh = new MaxHeap();
        mh.insert(11);
        mh.insert(3);
        mh.insert(15);
        mh.insert(5);
        mh.insert(4);
        mh.insert(45);

        System.out.println("del " + mh.delete(3));

        for (Integer val : mh.heap) {
            System.out.println(val);
        }
    }
}
