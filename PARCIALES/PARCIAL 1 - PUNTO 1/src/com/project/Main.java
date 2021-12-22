package com.project;

import java.util.Scanner;

//Constructor para  crear un nodo en la lista doblemente enlazada.
class Node {

    int data;       
    Node next, behind;

    Node(int a) {
        data = a;
        next = null;
        behind = null;
    }
}


//Creacion de clase nodo_jugador, con  la suma de los valores de sus cartas y la posicion en que se encuentra.
class Player_node {
    int sum, pos;
    Player_node next;

    Player_node(int a, int p) {
        sum = a;
        pos = p;
        next = null;
    }
}

//Creacion de la clase mazo.
class Deck {

    Node front;

    Node last;

    int size = 0;

    //Metodo para añadir un dato al frente del mazo.
    public void append(int data){
        if(front == null){
          //si el mazo esta vacio last y front seran iguales al dato ingresado.
            front = new Node(data);
            last = front;
        } else {
          //Si el mazo no esta vacio se añade el elemento al final de la lista y el tamaño aumenta.
            last.next = new Node(data);
            //guarda el anterior elemento final.
            last.next.behind = last;
            //el nuevo elemento final se guarda.
            last = last.next;
        }
        //aumenta el tamaño del mazo.
        size++;
    }
    //metodo para comparar el mazo.
    public int compareDeck(){
        //si el mazo tiene solo 1 carta, retornar su valor.
        if(front == last){
            int data = front.data;
            front = null;
            last = null;
            return data;
        //si tiene mas de una carta.
        } else {
            int data;
            //escoge la carta con un valor mayor, y la extrae del mazo, su valor queda en null.
            if(front.data >= last.data ){
              //si la carta del frente es mayor.
                data = front.data;
                front = front.next;
                front.behind = null;
            } else {
              //si la ultima carta de es mayor.
                data = last.data;
                last = last.behind;
                last.next = null;
            }
            //reduce el tamaño del mazo.
            size--;
            return data;
        }
    }

}
//Creacion clase jugadores.
class Players {

    Player_node front;
    Player_node last;
    int size;
    //creacion de una lista de los jugadores con el valor de suma y posicion.
    Players(int a){
        size = a;
        for(int i = 1; i < a + 1; i++){
          //si no hay jugadores, el jugador añadido estara en 1era posicion.
            if(front == null){
                front = new Player_node(0, 1);
                last = front;
            } else {
            //si hay uno o mas jugadores, añade las posiciones progresivamente con un i++.
                last.next = new Player_node(0, i);
                last = last.next;
                last.next = front;
            }
        }
    }
    //método para la realizacion del juego.
    void game(Deck deck){
      //Creación de nodo temporal en el frente del mazo.
        Player_node temp = front;
        //ciclo para sumar la carta mayor.
        while(deck.front != null){
          //suma d carta con mayor valor mediante el medoto CompareDeck();
            temp.sum += deck.compareDeck();
            //cambiar de jugador.
            temp = temp.next;
        }
    }
    //metodo para buscar la maxima suma de valores entre los jugadores.
    int max(){
      //Creación de nodo temporal en el frente del mazo.
        Player_node temp = front;
        int max = 0;
        for(int i = 1; i < size + 1; i++){
          //Comparar la suma de cada nodo(jugador) y retornar el maximo.
            int sum = temp.sum;
            temp = temp.next;
            if(max < sum){
                max = sum;
            }
        }
        return max;
    }
    //metodo para buscar el ganador del juego.
    void winners(){
      //Creación de nodo temporal en el frente del mazo.
        Player_node temp = front;
        int max = max();
        boolean has_printed = false;
        for(int i = 1; i < size + 1; i++){
          //Verificar si la suma es igual al maximo.
            if(temp.sum == max){
                if(!has_printed){
                  //imprimir posicion;
                    System.out.print(temp.pos);
                    has_printed = true;
                //en caso de más de un ganador imprimirlos con un espacio que los preceda.
                } else {
                    System.out.print(" " + temp.pos);
                }
            //movilizarse por los nodos.    
            }
            temp = temp.next;
        }
    }
}



public class Main {

    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);
        //tomar el numero de casos.
        int cases = scanner.nextInt();
        for(int i = 1; i < cases + 1; i++){
                  //tomar el numero de cartas y de jugadores.
            int number_cards = scanner.nextInt();
            int number_players = scanner.nextInt();
            //Creación de un mazo.
            Deck deck = new Deck();
            Players players = new Players(number_players);
            //Añadir las cartas al mazo.
            for(int j = 0; j < number_cards; j++){
                int card = scanner.nextInt();
                deck.append(card);
            }
            //realizacion del juego.
            players.game(deck);
            if(i == 1){
                System.out.println("Caso #" + i + ":");
            } else {
                System.out.println("\nCaso #" + i + ":");
            }
            //impresión de los ganadores.
            players.winners();
        }


    }
}
