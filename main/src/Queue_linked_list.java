public class Queue_linked_list {

    static class Nodo {
        int data;
        Nodo next;

        //Constructor para crear un nuevo nodo de la cola
        public Nodo(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // A class to represent a queue
    // The queue, front stores the front node of LL and rear stores the
    // last node of LL
    static class Cola {
        Nodo front, rear;

        public Cola() {
            this.front = this.rear = null;
        }

        // Method to add an key to the queue.
        void enqueue(int data)
        {

            // Create a new LL node
            Nodo temp = new Nodo(data);

            // If queue is empty, then new node is front and rear both
            if (this.rear == null) {
                this.front = this.rear = temp;
                return;
            }

            // Add the new node at the end of queue and change rear
            this.rear.next = temp;
            this.rear = temp;
        }

        // Method to remove an key from queue.
        void dequeue() {
            // If queue is empty, return NULL.
            if (this.front == null)
                return;

            // Store previous front and move front one node ahead
            Nodo temp = this.front;
            this.front = this.front.next;

            // If front becomes NULL, then change rear also as NULL
            if (this.front == null)
                this.rear = null;
        }
    }


}