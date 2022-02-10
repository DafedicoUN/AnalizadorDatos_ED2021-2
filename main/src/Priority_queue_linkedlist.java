class Priority_queue_linkedlist {
    //constructor para crear un nodo en la cola.
    static class Node {
        int data;
        int priority;
        Node next;

        public Node(int d, int pr) {
            this.data = d;
            this.priority = pr;
        }
    }

    private static Node head = null;

    //metodo para agregar un elemento a la cola.
    private static void enqueue(int d, int pr) {
        //crea nuevo nodo.
        Node newNode = new Node(d, pr);
        //si la cola se encuentra vacia, el nuevo nodo sera la cabeza de la cola.
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        Node previ = null;
        //Se busca un nodo con prioridad menor a la ingresada.
        while (temp != null && temp.priority > pr) {
            previ = temp;
            temp = temp.next;
        }
        if (temp == null) {
            //si no se encuentra un nodo con prioridad menor
            previ.next = newNode;
        } else {
            //todos los nodos tienen una prioridad menor este se inserta al principio.
            if (previ == null) {
                newNode.next = head;
                head = newNode;
            } else {
                // se encuntra y se añade el nodo antes del que tiene una prioridad menor
                newNode.next = temp;
                previ.next = newNode;
            }
        }
    }

    //devuelve el elemento con maxima prioridad de la lista
    private static int peek() {
        if (head != null) {
            return (head.data);
        }
        return -1;
    }

    //elimina el elemento con maxima prioridad de la lista
    private static int dequeue() {
        if (head != null) {
            int d = head.data;
            head = head.next;
            return (d);
        }
        return -1;
    }

    //metodo para imprimir los nodos de la cola recursivamente.
    public static void nDisplay(Node x) {
        if (null == x.next) {
            System.out.print(x.data + "," + x.priority + "\n");
        } else {
            System.out.print(x.data + "," + x.priority + " ");
            nDisplay(x.next);
        }
    }

    //metodo para imprimir la cola en base a sus nodos.
    public static void qpDisplay() {
        if (head == null) {
            System.out.println("Priority queue is empty");
        } else {
            nDisplay(head);
        }

    }

    private static void qpFind(double data) {
        Node a = head;
        int r = 0;
        while (a.data != data) {
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

    //metood parabuscar el dato mayor en la cola.
    public static int queueNodeMax(Node a) {
        Node temp = a;
        int max = 0;
        if (a != null) {
            while (temp.next != null) {
                if (max < temp.data) {
                    max = temp.data;
                }
                temp = temp.next;
            }
        }
        return max;
    }

}