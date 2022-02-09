package heap;

import java.util.ArrayList;

public class Heap {
    ArrayList<Integer> a = new ArrayList<>();

    void heapify(int i) {
        int size = a.size();
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < size && a.get(l) > a.get(largest))
            largest = l;
        if (r < size && a.get(r) > a.get(largest))
            largest = r;

        if (largest != i) {
            int temp = a.get(largest);
            a.set(largest, a.get(i));
            a.set(i, temp);

            heapify(largest);
        }
    }

    public void insert(int newNum) {
        int size = a.size();
        a.add(newNum);
        if (size != 0) {
            for (int i = size / 2 - 1; i >= 0; i--) {
                heapify(i);
            }
        }
    }

    public void delete(int num)
    {
        int size = a.size();
        int i;
        boolean found = false;
        for (i = 0; i < size; i++)
        {
            if (num == a.get(i)) {
                found = true;
                break;
            }
        }
        if(found){
            int temp = a.get(i);
            a.set(i, a.get(size-1));
            a.set(size-1, temp);

            a.remove(size-1);
            for (int j = size / 2 - 1; j >= 0; j--)
            {
                heapify(j);
            }
        }

    }

    public void print() {
        for (Integer i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public int max() {
        return a.get(0);
    }

    public void find(int data){
        for (Integer i : a) {
            if(i == data){
                System.out.println("Found");
                return;
            }
        }
        System.out.println("Not found");
    }

}
