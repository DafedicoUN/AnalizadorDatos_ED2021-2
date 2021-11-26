public class Queue_linked_list implements queue {

    static class Node
    {
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
    public void queueNodeSearch(Node a, int search)
    {
        if (null == a.next) {
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
    public void queueSearch(int search)
    {
        queueNodeSearch(this.front, search);

    }

    //Vacía la cola.
    public void emptyQueue()
    {
        this.front = null;
        this.rear = null;
    }
}