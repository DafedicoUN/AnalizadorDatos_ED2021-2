package com.project;

import java.util.Scanner;


//Creacion del constructor para el nodo de los paquetes con su ID y las coordenadas de entrega.
class Package_node{

    int ID, x_axis, y_axis;
    Package_node next;

    Package_node(int i, int x, int y){
        ID = i;
        x_axis = x;
        y_axis = y;
        next = null;
    }
}

//Creacion de clase pile(montones).
class Pile{

    Package_node front, last;
    //metodo para añadir un nuevo paquete al fondo del monton(el primero en insertarse es el que esta en la cima del monton).
    void append(int ID, int x, int y){
        //si no hay datos, el frente y el fondo tendran el valor del nuevo paquete.
        if (front == null){
            front = new Package_node(ID, x, y);
            last = front;
        //si hay datos.  
        } else {
          //Guarda el dato en un nuevo nodo al fondo del monton.
            last.next = new Package_node(ID, x, y);
            last = last.next;
        }
    }

}
//Creacion de clase Truck.
class Truck{
    int min_x, max_x, min_y, max_y;
    Package_node front;

    //Asignación de variables para el minimo y maximo segun el largo y ancho de la ciudad.
    Truck(int minimum_x, int maximum_x, int minimum_y, int maximum_y){
        min_x = minimum_x;
        max_x = maximum_x;
        min_y = minimum_y;
        max_y = maximum_y;
    }
    //Metodo para organizar los paquetes segun su region a entregar.
    void sortedInsert(int ID, int x, int y){
        if(min_x <= x && x < max_x && min_y <= y && y < max_y){
            Package_node temp;
            Package_node node = new Package_node(ID, x, y);
            Package_node a = front;
            int key_y = node.y_axis;
            int key_x = node.x_axis;
            //Añadir un paquete con coordenada de entrega y menor a la del frente.(o en caso de que la lista del camion este vacia.)
            if(front == null || key_y <= front.y_axis){
                node.next = front;
                front = node;
            } 
            else {
              //Creacion de nodo temporal en el fente de la lista.
                temp = front;
                while (temp.next != null && temp.next.y_axis <= key_y) {
                    if(temp.next.y_axis == key_y){
                      //mientras que los paquetes tengan coordenada y igual y una coordeanda x menor a la del nodo, añadirlos despues del nodo.
                        while(temp.next != null && temp.next.y_axis == key_y && temp.next.x_axis < key_x){
                            temp = temp.next;
                        }
                        node.next = temp.next;
                        temp.next = node;
                        break;
                    }
                    temp = temp.next;
                }
                node.next = temp.next;
                temp.next = node;
            }
        }
    }
    //metodo para imprimir la lista.
    void printList(){
        if(front != null){
            Package_node temp = front;
            while(temp.next != null){
                System.out.print(temp.ID + " ");
                temp = temp.next;
            }
            System.out.print(temp.ID);
        }
    }

}


public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //scanner para el ancho y largo de la ciudad, asi como para la cantidad de regiones.
        int x_lenght = scanner.nextInt();
        int y_lenght = scanner.nextInt();
        int regions = scanner.nextInt();

        //calculo para el tamaño de las regiones.
        int x_jump = (int) (x_lenght / Math.sqrt(regions));
        int y_jump = (int) (y_lenght / Math.sqrt(regions));

        int min_y = 0;
        int max_y = y_jump;
        
        int packages_number = scanner.nextInt();
        int piles_number = scanner.nextInt();

        Pile pile = new Pile();
        //ciclo para añadir un nuevo paquete al monton segun la entrada.
        for(int i = 0; i < packages_number;i++){
            int ID = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            pile.append(ID, x, y);
        }

        int contador = 1;

        boolean has_printed = false;
        for(int i = 0; i < Math.sqrt(regions);i++){

            int min_x = 0;
            int max_x = x_jump;

            for(int j = 0; j < Math.sqrt(regions); j++){
                
                Truck truck = new Truck(min_x, max_x, min_y, max_y);

                Package_node temp = pile.front;
                //insertar los paquetes de los montones segun las coordenadas de entrega.
                while(temp != null){
                    truck.sortedInsert(temp.ID, temp.x_axis, temp.y_axis);
                    temp = temp.next;
                }

                if(has_printed){
                    System.out.print("\n");
                }
                //imprimir region 1 con sus respectivos paquetes ordenados segun entrega.
                System.out.print(contador + " ");

                truck.printList();

                has_printed = true;


              //añadir al minimo en ambos ejes el tamaño de una region y aumentar en1 la region.
                min_x += x_jump;
                max_x += x_jump;

                contador += 1;

            }

            min_y += y_jump;
            max_y += y_jump;
        }
    }
}
