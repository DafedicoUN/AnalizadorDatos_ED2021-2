import java.util.*;

public class Analizador {

    public static void main(String[] args){
        Queue_array q = new Queue_array(100);

        //Queue_linked_list q = new Queue_linked_list();

        for(int i = 0; i < 10;i++){
            q.enqueue(i);
        }

        q.queueDisplay();
    }
}
