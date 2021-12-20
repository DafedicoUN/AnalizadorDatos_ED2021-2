package com.project;

import java.util.Scanner;

class Node {

    int data;
    Node next, behind;

    Node(int a) {
        data = a;
        next = null;
        behind = null;
    }

}

class Player_node {
    int sum, pos;
    Player_node next;

    Player_node(int a, int p) {
        sum = a;
        pos = p;
        next = null;
    }
}

class Deck {

    Node front;

    Node last;

    int size = 0;

    public void append(int data){
        if(front == null){
            front = new Node(data);
            last = front;
        } else {
            last.next = new Node(data);
            last.next.behind = last;
            last = last.next;
        }
        size++;
    }

    public int compareDeck(){
        if(front == last){
            int data = front.data;
            front = null;
            last = null;
            return data;

        } else {
            int data;
            if(front.data >= last.data ){
                data = front.data;
                front = front.next;
                front.behind = null;
            } else {
                data = last.data;
                last = last.behind;
                last.next = null;
            }
            size--;
            return data;
        }
    }

    /*void printList(){
        Node temp = front;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        //System.out.print(temp.data);
    }
    */

}

class Players {

    Player_node front;
    Player_node last;
    int size;

    Players(int a){
        size = a;
        for(int i = 1; i < a + 1; i++){
            if(front == null){
                front = new Player_node(0, 1);
                last = front;
            } else {
                last.next = new Player_node(0, i);
                last = last.next;
                last.next = front;
            }
        }
    }

    void game(Deck deck){
        Player_node temp = front;
        while(deck.front != null){
            temp.sum += deck.compareDeck();
            temp = temp.next;
        }
    }

    int max(){
        Player_node temp = front;
        int max = 0;
        for(int i = 1; i < size + 1; i++){
            int sum = temp.sum;
            temp = temp.next;
            if(max < sum){
                max = sum;
            }
        }
        return max;
    }

    void winners(){
        Player_node temp = front;
        int max = max();
        boolean has_printed = false;

        for(int i = 1; i < size + 1; i++){
            if(temp.sum == max){
                if(!has_printed){
                    System.out.print(temp.pos);
                    has_printed = true;
                } else {
                    System.out.print(" " + temp.pos);
                }
            }
            temp = temp.next;
        }
    }
}



public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for(int i = 1; i < cases + 1; i++){
            int number_cards = scanner.nextInt();
            int number_players = scanner.nextInt();
            Deck deck = new Deck();
            Players players = new Players(number_players);
            for(int j = 0; j < number_cards; j++){
                int card = scanner.nextInt();
                deck.append(card);
            }

            players.game(deck);
            if(i == 1){
                System.out.println("Caso #" + i + ":");
            } else {
                System.out.println("\nCaso #" + i + ":");
            }
            players.winners();
        }


    }
}
