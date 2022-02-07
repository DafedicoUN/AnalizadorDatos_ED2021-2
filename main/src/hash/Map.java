package hash;

import java.util.Objects;

public class Map {

    static class Node{
        String ID, email;
        Node next;

        public Node(String s, String e) {
            this.ID = s;
            this.email = e;
            this.next = null;
        }
    }

    Node front, rear;
    int size = 0;

    public Map() {
        this.front = this.rear = null;
    }

    public void add(String ID, String email) {
        Node temp = this.front;
        Node a = new Node(ID, email);

        if (this.front == null) {
            this.front = this.rear = a;
            size = 1;
        } else {
            while(temp != null){
                String l = temp.ID;
                if(Objects.equals(l, ID)){
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
        if(this.front != null) while (temp != null) {
            String l = temp.ID;
            String l2 = temp.email;
            temp = temp.next;
            if (temp != null) {
                System.out.print(l + " " + l2 + " ");
            } else {
                System.out.print(l + l2 + "\n");
            }

        }
    }

    public void delete(String data){
        Node temp = this.front;
        Node prev = null;
        if (temp != null && Objects.equals(temp.ID, data)) {
            this.front = temp.next;
            return;
        }

        while (temp != null && !Objects.equals(temp.ID, data)) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null)
            return;

        assert prev != null;
        prev.next = temp.next;
    }

    public String contains(String data){
        Node temp = this.front;
        if (temp != null && Objects.equals(temp.ID, data)) {
            return temp.email;
        }

        while (temp != null && !Objects.equals(temp.ID, data)) {
            temp = temp.next;
        }

        if(temp != null){
            return temp.email;
        }

        return "NOT FOUND";

    }

}
