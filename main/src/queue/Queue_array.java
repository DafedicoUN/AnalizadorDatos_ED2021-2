package queue;

import javax.swing.*;

public class Queue_array implements queue {

    private static int front, rear, capacity;
    private static int[] queue;

    public Queue_array(int c)
    {
        //Índices del frente y la parte trasera tienen un valor de 0.
        front = rear = 0;
        //Capacidad de la cola
        capacity = c;
        queue = new int[capacity];
    }

    //Agrega un elemento a la cola.
    public void enqueue(int data)
    {

        //Verifica si la cola está llena o no.
        if (capacity == rear) {
            JOptionPane.showMessageDialog(null, "La cola está llena");
        }

        //Insertar elemento en la cola.
        else {
            queue[rear] = data;
            //Rear aumenta, es el índice donde irá el último elemento en la cola.
            rear++;

        }
    }

    //Elimina un elemento del frente de la cola.
    public void dequeue()
    {
        int atendido = this.peek();
        //Si la cola está vacia.
        if (front != rear) {
            //Todos los elementos se desplazan hacia la izquierda borrando el primer elemento ingresado.
            //First IN, First OUT.
            if (rear - 1 >= 0) System.arraycopy(queue, 1, queue, 0, rear - 1);

            //Guarda un 0 indicando que no hay valor en la posición del último que ingresó.
            if (rear < capacity) queue[rear] = 0;

            //La posición de la parte trasera de la cola disminuye.
            rear--;

            if(this.peek() != 0){
                JOptionPane.showMessageDialog(null, "Turno " + atendido + " fue atendido, turno " + this.peek() + " puede seguir");
            } else {
                JOptionPane.showMessageDialog(null, "Turno " + atendido + " fue atendido, no hay más personas en la cola");
            }

        } else {
            JOptionPane.showMessageDialog(null, "No hay más personas en la cola");
        }

    }

    //Imprime los elementos de la cola.
    public void queueDisplay()
    {
        int i;
        if (front == rear) {
            JOptionPane.showMessageDialog(null, "La cola está vacía");
            return;
        }

        //Itera imprimiendo todos los elementos empezando por el frente.
        for (i = front; i < rear; i++) {
            if (i + 1 == rear){
                System.out.print(queue[i] + "\n");
            } else {
                System.out.print(queue[i] + " ");
            }
        }
    }

    //Busca un elemento en la cola.
    public void queueSearch(int search)
    {
        int i;
        if (front == rear) {
            System.out.println("Queue is Empty");
            return;
        }

        for (i = front; i < rear; i++) {
            if (search == queue[i]){
                System.out.println("Found");
                return;
            }
        }
        System.out.println("Not found");
    }

    //Vacía la cola.
    public void queueEmpty()
    {
        int i;

        if (front == rear) {
            return;
        }

        for (i = front; i < rear; i++) {
            queue[i] = 0;
        }

        rear -= i;
    }

    public void queueAverage()
    {
        int i;
        int sum = 0;

        if (front == rear) {
            return;
        }

        for (i = front; i < rear; i++) {
            sum += queue[i];
        }

        System.out.println(sum / i);

    }

    public void queueMax() {
        int i;
        int max = 0;

        if (front == rear) {
            return;
        }

        for (i = front; i < rear; i++) {
            if (max < queue[i]){
                max = queue[i];
            }
        }

        System.out.println(max);
    }

    public int peek(){
        if(front != rear){
            return queue[0];
        } else {
            return 0;
        }
    }


}