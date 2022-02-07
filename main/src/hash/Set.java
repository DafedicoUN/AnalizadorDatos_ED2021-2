package hash;

import java.util.ArrayList;
import java.util.Objects;

public class Set {

    static class Node{
        String name;
        Node next;

        public Node(String s) {
            this.name = s;
            this.next = null;
        }
    }

    Node front, rear;
    int size = 0;

    public Set() {
        this.front = this.rear = null;
    }

    public void add(String data) {
        Node temp = this.front;
        Node a = new Node(data);

        if (this.front == null) {
            this.front = this.rear = a;
            size = 1;
        } else {
            while(temp != null){
                String l = temp.name;
                if(Objects.equals(l, data)){
                    System.out.println("NOT ADDED");
                    return;
                }
                temp = temp.next;
            }
            this.rear.next = a;
            this.rear = a;
            size += 1;
        }
    }

    public void print(){
        Node temp = this.front;
        if(this.front != null){
            while(temp != null){
                String l = temp.name;
                temp = temp.next;
                if(temp != null){
                    System.out.print(l + " ");
                } else {
                    System.out.print(l + "\n");
                }

            }
        }
    }

    public void delete(String data){
        Node temp = this.front;
        Node prev = null;
        if (temp != null && Objects.equals(temp.name, data)) {
            this.front = temp.next;
            return;
        }

        while (temp != null && !Objects.equals(temp.name, data)) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null)
            return;

        assert prev != null;
        prev.next = temp.next;
    }

    public boolean contains(String data){
        Node temp = this.front;
        Node prev = null;
        if (temp != null && Objects.equals(temp.name, data)) {
            return true;
        }

        while (temp != null && !Objects.equals(temp.name, data)) {
            prev = temp;
            temp = temp.next;
        }

        return temp != null;
    }

}
