package stack;

import stack.stack;

class Stack_linked_list implements stack {
    Node top;
    int size;

    class Node {
        double data;
        Node next;

        public Node(double data) {
            this.data = data;
            this.next = null;
        }
    }

    //Verificar si la pila eesta vacia.
    boolean Empty() {
        return size == 0;
    }

    //Insertar dato en el top de la pila.
    public void stacks(double data) {
        //Nodo temporal para crear añadir una posicion y asignar el valor a top.
        Node temp = new Node(data);
        temp.next = top;
        top = temp;
        size++;
    }

    //Eliminar el ultimo dato insertado(top).
    public void unstack() {
        //Verificar si la pila esta vacia.
        if (Empty()) {
            System.out.print("\n" + "Stack is empty" + "\n");
        }
        //designa top a su valor anterior y reduce el tamaño.
        else {
            top = top.next;
            size--;
        }
    }

    //Imprimir los datos de la pila empezando por el top.
    public void stackDisplay() {
        //Verificar si la pila esta vacia.
        if (Empty()) {
            System.out.print("\n" + "Stack is empty" + "\n");
        }
        //imprime los datos de la pila usando los nodos deste top hasta que el next del nodo sea nulo.
        else {
            Node a = top;
            while (a != null) {
                if (a.next != null) {
                    System.out.print(a.data + " ");
                    a = a.next;
                } else
                    break;
            }
            System.out.print(a.data + "\n");
        }
    }

    //Busca un dato dentro de la pila.
    public void stackFind(double data) {
        if (Empty()) {
            System.out.print("\n" + "Stack is empty" + "\n");
        } else {
            //Busca el dato por los nodos desde el top
            Node a = top;
            int r = 0;
            while (a.data != data) {
                //Verifica que haya un nodo siguiente.
                if (a.next != null) {
                    a = a.next;
                    r = 1;
                } else {
                    r = -1;
                    break;
                }
            }
            if (r == -1) {
                System.out.print("not found" + "\n");
            } else {
                System.out.print("found" + "\n");
            }
        }
    }

    //Busca el valor maximo de la pila.
    public void max() {
        if (Empty()) {
            System.out.print("\n" + "Stack is empty" + "\n");
        } else {
            double max = 0;
            Node a = top;
            //Se Busca entre los nodos un valor mayor a max y se reemplaza en caso de ser mayor.
            while (a != null) {
                if (max < a.data)
                    max = a.data;
                a = a.next;
            }
            System.out.print("\n" + max);
        }
    }

    //Busca el valor minimo de la pila.
    public void min() {
        if (Empty()) {
            System.out.print("\n" + "Stack is empty" + "\n");
        } else {
            double min = Double.MAX_VALUE;
            Node a = top;
            //Se Busca entre los nodos un valor menor a min y se reemplaza en caso de ser menor.
            while (a != null) {
                if (min > a.data)
                    min = a.data;
                a = a.next;
            }
            System.out.print("\n" + min);
        }
    }
    //vacia la pila establiciendo el tamaño como cero y el top como null.
    public void stackEmpty(){
        top=null;
        size=0;
    }
    //Resuelve el promedio de los valores dentro de la pila.
    public void stackAverage() {
        if (Empty()) {
            System.out.print("\n" + "Stack is empty" + "\n");
        } else {
            Node a = top;
            double sum = 0;
            int count = 0;
            //Suma los valores de la pila recorriendo cada nodo.
            while (a != null) {
                sum += a.data;
                count++;
                a = a.next;
            }
            //Imprime el promedio de los valores de la pila.
            System.out.print("\n" + sum / (count));
        }
    }
}

