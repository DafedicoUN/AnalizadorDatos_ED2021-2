import java.util.*;

public class Analizador {

    public static void main(String[] args){

        Timer timer = new Timer();
        timer.schedule(new Emulador(), 0, 1000);

    }
}
