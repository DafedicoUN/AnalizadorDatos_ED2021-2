class Priority_queue_linkedlist {
    static class Node
    int data;
    int priority;
    Node next;

    public Node(int d, int pr) {
        this.data = d;
        this.priority = pr;
    }
}

    private static Node head = null;
    private static void enqueue(int d, int pr) {
        Node newNode = new Node(d, pr);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        Node previ = null;
        while (temp!= null && temp.priority > pr) {
            previ = temp;
            temp = temp.next;
        }
        if (temp == null) {
            previ.next = newNode;
        } else {
            if (previ == null) {
                newNode.next = head;
                head = newNode;
            } else {

                newNode.next = temp;
                previ.next = newNode;
            }
        }
    }
    private static int peek() {
        if (head != null) {
            return (head.data);
        }
        return -1;
    }
    private static int dequeue() {
        if (head != null) {
            int d = head.data;
            head = head.next;
            return(d);
        }
        return-1;
    }

    public static void nDisplay(Node x)
    {
        if (null == x.next) {
            System.out.print(x.data + "," + x.priority + "\n");
        }
        else {
            System.out.print(x.data + "," + x.priority + " ");
            nDisplay(x.next);
        }
    }
    public static void qpDisplay()
    {
        if( head== null){
            System.out.println("Priority queue is empty");
        } else {
            nDisplay(head);
        }

    }


    public static int queueNodeMax(Node a)
    {
        Node temp = a;
        int max = 0;
        if (a != null) {
            while (temp.next != null) {
                if(max < temp.data){
                    max = temp.data;
                }
                temp = temp.next;
            }
        }
        return max;
    }

    public static void queueMax() {
        System.out.println(queueNodeMax(head));
    }