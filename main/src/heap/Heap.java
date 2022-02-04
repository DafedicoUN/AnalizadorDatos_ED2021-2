package heap;

public class Heap {

    private int[] Heap;
    private int size;
    private int maxsize;

    //Inicializa un heap con capacidad máxima
    public Heap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize];
    }

    //Posición padre
    private int parent(int pos) {
        return (pos - 1) / 2;
    }

    //Posición hijo izquierda
    private int leftChild(int pos) {
        return (2 * pos);
    }

    //Posición hijo derecha
    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    //Verifica si el nodo es hijo
    private boolean isLeaf(int pos) {
        return pos > (size / 2) && pos <= size;
    }

    //Intercambia nodos
    private void swap(int fpos, int spos) {
        int tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    //Función recursiva para max heapify dado un subtree
    private void maxHeapify(int pos) {
        if (isLeaf(pos))
            return;

        if (Heap[pos] < Heap[leftChild(pos)]
                || Heap[pos] < Heap[rightChild(pos)]) {

            if (Heap[leftChild(pos)]
                    > Heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            } else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }

    //Insertar elemento
    public void insert(int element) {
        Heap[size] = element;

        //Verifica que se cumpla la propiedad del heap
        int current = size;
        while (Heap[current] > Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }

    //Imprime el heap
    public void print() {

        for (int i = 0; i < size / 2; i++) {

            System.out.print("Parent Node : " + Heap[i]);

            if (leftChild(i) < size) //if the child is out of the bound of the array
                System.out.print(" Left Child Node: " + Heap[leftChild(i)]);

            if (rightChild(i) < size) //if the right child index must not be out of the index of the array
                System.out.print(" Right Child Node: " + Heap[rightChild(i)]);

            System.out.println(); //for new line

        }

    }
}
