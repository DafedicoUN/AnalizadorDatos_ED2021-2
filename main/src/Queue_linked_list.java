public class Queue_linked_list implements queue {

    private static int data;
    private static Node next;

    static class Node {
        int data;
        Node next;

        //Constructor para crear un nuevo nodo de la cola.
        public Node(int data) {
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
    public void enqueue(int data)
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
        Node temp = this.front;
        this.front = this.front.next;

        //Si el nuevo frente el nulo, cambia la parte trasera a nulo.
        if (this.front == null)
            this.rear = null;
    }

    //Imprime la cola empezando por el nodo del frente.
    public void queueDisplay()
    {
        queueNodeDisplay(this.front);
    }

    //Imprime los nodos de la cola de manera recursiva.
    public void queueNodeDisplay(Node a)
    {

        if (null == a.next) {
            System.out.print(a.data + "\n");
        } else {
            System.out.print(a.data + " ");
            queueNodeDisplay(a.next);
        }
    }





}