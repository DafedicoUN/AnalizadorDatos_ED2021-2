class pq_binary_heap{
        //cosntructor del heap en base a un array.
        static int []H = new int[50000];
        static int size = -1;

        //obtiene el indice del nodo padre del nodo ingresado.
        static int getParent(int index){
            return (index - 1) / 2;
        }

        //obtiene el indice del hijo izquierdo del nodo ingresado.
        static int getLeftChild(int index){
            return ((2 * index) + 1);
        }

    //obtiene el indice del hijo derecho del nodo ingresado.
        static int getRightChild(int index){
            return ((2 * index) + 2);
        }

        //intercambiar un nodo hacia arriba para conservar las propiedades de un heap.
        static void swapUp(int index)
        {
            while (index > 0 && H[getParent(index)] < H[index])
            {
                //intercambia el nodo actual con su padre
                swap(getParent(index), index);
                index = getParent(index);
            }
        }

    //intercambiar un nodo hacia abajo
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

        //insertar un elemento en el heap.
        static void insert(int pr){
            size++;
            H[size] = pr;
            swapUp(size);
        }
        //obtiene el valor de elemento con mayor priordiad.
        static int getMax(){
            return H[0];
        }
        //saca el elemento con prioridad mayor.
        static int dequeue(){
            int max = H[0];
            H[0] = H[size];
            size--;
            swapDown(0);
            return max;
        }

        //cambiar la prioridad de un elemeento.
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

        //remover un elemento dado un indice.
        static void remove(int index){
            H[index] = getMax() + 1;

            swapUp(index);
            extractMax();
        }

        static void swap(int x, int y){
            int temp= H[x];
            H[x] = H[y];
            H[x] = temp;
        }

        static void Find(int p ){
            int i=1;
            int r=0;
            while (H[i]!=p){
                if (i+1<=size){
                    i++;
                    r=1;
                }
                else{
                    r=-1;
                    break;
                }
            }
            if (r == -1) {
                System.out.print("not found" + "\n");
            }
            else {
                System.out.print("found" + "\n");
            }
        }
    static void max(){
        System.out.print(H[0]);
    }

        //imprime la cola de prioridad.
        static void Display(){
            for(int i=0; i<=size; i++) {
                if (i==size){
                    System.out.print(H[i]+"\n");
                }
                else{
                    System.out.print(H[i]+" ");
                }
            }

        }

}
