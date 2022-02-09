package priorityQueue;

public class PQ_binary_heap{

    static int capacity;
    static int[] H;
    static int size = -1;

    public PQ_binary_heap(int i){
        capacity = i;
        H = new int[capacity];
    }

    static int getParent(int index){
        return (index - 1) / 2;
    }

    static int getLeftChild(int index){
        return ((2 * index) + 1);
    }

    static int getRightChild(int index){
        return ((2 * index) + 2);
    }

    static void swapUp(int index)
    {
        while (index > 0 && H[getParent(index)] < H[index])
        {
            swap(getParent(index), index);
            index = getParent(index);
        }
    }

    static void swapDown(int index){
        int maxInd = index;
        int Left = getLeftChild(index);
        int right = getRightChild(index);


        if (right <= size && H[right] > H[maxInd]){
            maxInd = right;
        }

        if (Left <= size && H[Left] > H[maxInd]){
            maxInd = Left;
        }

        if (index != maxInd){
            swap(index, maxInd);
            swapDown(maxInd);
        }
    }

    public static void insert(int pr){
        size++;
        H[size] = pr;
        swapUp(size);
    }

    public static int getMax(){
        return H[0];
    }

    static int extractMax(){
        int max = H[0];
        H[0] = H[size];
        size--;
        swapDown(0);
        return max;
    }

    static void changePr(int index,  int priority){
        int opr = H[index];
        H[index] = priority;

        if (priority > opr){
            swapUp(index);
        }
        else{
            swapDown(index);
        }
    }

    public static void remove(int index){
        H[index] = getMax() + 1;

        swapUp(index);
        extractMax();
    }

    static void swap(int x, int y){
        int temp= H[x];
        H[x] = H[y];
        H[x] = temp;
    }

    static void display(){
        for(int i=1; i<=size; i++) {
            if (i==size){
                System.out.print(H[i]+"\n");
            }
            else{
                System.out.print(H[i]+" ");
            }
        }

    }

}
