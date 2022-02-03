package queue;

import queue.queue;

public class Queue_linked_list implements queue {

    static class Node
    {
        double data;
        Node next;

        //Constructor para crear un nuevo nodo de la cola.
        public Node(double data) {
            this.data = data;
            this.next = null;
        }
    }

    Node front, rear;

    public Queue_linked_list() {
        //Al inicializar la cola ambos tienen un valor nulo.
        this.front = this.rear = null;
    }

    //Argegar un elemento a la cola.
    public void enqueue(double data)
    {

        //Crear un nuevo nodo
        Node temp = new Node(data);

        //Si la cola está vacia, el nuevo dato es el frente y la parte trasera de la cola.
        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }

        //Agrega el nodo a la parte trasera de la cola y cambia la parte trasera de la cola.
        this.rear.next = temp;
        this.rear = temp;
    }

    //Elimina un elemento del frente de la cola.
    public void dequeue()
    {
        //Si la cola está vacia retorna null.
        if (this.front == null)
            return;

        //Guarda el anterior frente y mueve el frente al siguiente dato del frente actual.
        //Node temp = this.front;
        this.front = this.front.next;

        //Si el nuevo frente el nulo, cambia la parte trasera a nulo.
        if (this.front == null)
            this.rear = null;
    }

    //Imprime los nodos de la cola de manera recursiva.
    public void queueNodeDisplay(Node a)
    {
        if (null == a.next) {
            if(a.data == -1){
                System.out.println("Queue is empty");
            } else {
                System.out.print(a.data + "\n");
            }
        } else {
            System.out.print(a.data + " ");
            queueNodeDisplay(a.next);
        }
    }

    //Imprime la cola empezando por el nodo del frente.
    public void queueDisplay()
    {
        if(this.front == null){
            System.out.println("Queue is empty");
        } else {
            queueNodeDisplay(this.front);
        }

    }

    //Busca el dato en los nodos de la cola de manera recursiva.
    public void queueNodeSearch(Node a, double search)
    {
        if (null == a.next && a.data != search) {
            System.out.println("Not found");
        } else {
            if(a.data == search){
                System.out.println("Found");
            } else {
                queueNodeSearch(a.next, search);
            }
        }
    }

    //Imprime si un dato en específico fue encontrado o no.
    public void queueSearch(double search)
    {
        queueNodeSearch(this.front, search);
    }

    //Vacía la cola.
    public void queueEmpty()
    {
        this.front = null;
        this.rear = null;
    }

    //Suma los valores de los nodos de la cola de manera recursiva.
    public double queueNodeSum(Node a)
    {
        if (null == a.next) {
            return a.data;
        } else {
            return a.data + queueNodeSum(a.next);
            }
    }

    public int queueNodeCount(Node a)
    {
        if (null == a.next) {
            return 1;
        } else {
            return 1 + queueNodeCount(a.next);
        }
    }

    //Imprime el promedio de los valores la cola.
    public void queueAverage() {
        double sum = queueNodeSum(this.front);
        int count = queueNodeCount(this.front);
        System.out.println(sum/count);
    }

    public double queueNodeMax(Node a)
    {
        if (null == a.next) {
            return a.data;
        } else {
            double max = a.data;
            double data = queueNodeMax(a.next);
            if(max < data){
                max = data;
                return max;
            } else {
                return max;
            }
        }
    }

    public void queueMax() {
        System.out.println(queueNodeMax(this.front));
    }
}