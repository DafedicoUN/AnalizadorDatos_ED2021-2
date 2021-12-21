package com.project;

import java.util.Scanner;

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

class Pile{

    Package_node front, last;

    void append(int ID, int x, int y){
        if (front == null){
            front = new Package_node(ID, x, y);
            last = front;
        } else {
            last.next = new Package_node(ID, x, y);
            last = last.next;
        }
    }

}

class Truck{
    int min_x, max_x, min_y, max_y;
    Package_node front;

    Truck(int minimum_x, int maximum_x, int minimum_y, int maximum_y){
        min_x = minimum_x;
        max_x = maximum_x;
        min_y = minimum_y;
        max_y = maximum_y;
    }

    void sortedInsert(int ID, int x, int y){
        if(min_x <= x && x < max_x && min_y <= y && y < max_y){
            Package_node temp;
            Package_node node = new Package_node(ID, x, y);
            Package_node a = front;
            int key_y = node.y_axis;
            int key_x = node.x_axis;
            if(front == null || key_y <= front.y_axis){
                node.next = front;
                front = node;
            } else {
                temp = front;
                while (temp.next != null && temp.next.y_axis <= key_y) {
                    if(temp.next.y_axis == key_y){
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

        int x_lenght = scanner.nextInt();
        int y_lenght = scanner.nextInt();
        int regions = scanner.nextInt();

        int x_jump = (int) (x_lenght / Math.sqrt(regions));
        int y_jump = (int) (y_lenght / Math.sqrt(regions));

        int min_y = 0;
        int max_y = y_jump;

        int packages_number = scanner.nextInt();
        int piles_number = scanner.nextInt();

        Pile pile = new Pile();

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
                while(temp != null){
                    truck.sortedInsert(temp.ID, temp.x_axis, temp.y_axis);
                    temp = temp.next;
                }

                if(has_printed){
                    System.out.print("\n");
                }

                System.out.print(contador + " ");

                truck.printList();

                has_printed = true;



                min_x += x_jump;
                max_x += x_jump;

                contador += 1;

            }

            min_y += y_jump;
            max_y += y_jump;
        }
    }
}