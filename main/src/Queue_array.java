class Queue_array {
    private static int front, rear, capacity;
    private static int[] queue;

    Queue_array(int c)
    {
        front = rear = 0;
        capacity = c;
        queue = new int[capacity];
    }

    // function to insert an element
    // at the rear of the queue
    static void queueEnqueue(int data)
    {
        // check queue is full or not
        if (capacity == rear) {
            System.out.print("\nQueue is full\n");
        }

        // insert element at the rear
        else {
            queue[rear] = data;
            rear++;
        }
    }

    // function to delete an element
    // from the front of the queue
    static void queueDequeue()
    {
        // if queue is empty
        if (front == rear) {
            System.out.print("\nQueue is empty\n");
        }

        // shift all the elements from index 2 till rear
        // to the right by one
        else {
            if (rear - 1 >= 0) System.arraycopy(queue, 1, queue, 0, rear - 1);

            // store 0 at rear indicating there's no element
            if (rear < capacity)
                queue[rear] = 0;

            // decrement rear
            rear--;
        }
    }

    // print queue elements
    static void queueDisplay()
    {
        int i;
        if (front == rear) {
            System.out.print("\nQueue is Empty\n");
            return;
        }

        // traverse front to rear and print elements
        for (i = front; i < rear; i++) {
            System.out.printf(" %d <-- ", queue[i]);
        }
    }

    // print front of queue
    static void queueFront()
    {
        if (front == rear) {
            System.out.print("\nQueue is Empty\n");
            return;
        }
        System.out.printf("\nFront Element is: %d", queue[front]);
    }
}