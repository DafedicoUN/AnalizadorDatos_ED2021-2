import hash.HashSet;
import hash.Set;
import heap.Heap;
import queue.*;
import javax.swing.*;
import java.util.Random;

public class Analizador {

    public static String generateRandomPassword(int len) {
        String chars = "abcdefghijk"
                +"lmnopqrstuvwxyz ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }

    public static int hash(String s) {
        int hash_value = 0;
        String space = " ";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' '){
                return hash_value;
            }
            hash_value += s.charAt(i);
        }
        return hash_value;
    }


    public static void main(String[] args) {
    /*
        JFrame frame = new JFrame("Analizador de datos");
        frame.setContentPane(new Interface().analizador);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    */
        HashSet s = new HashSet();
        for (int i = 0; i < 15; i++) {
            Random rand = new Random();
            String name = generateRandomPassword(rand.nextInt(9) + 1);
            s.add(name);
            s.contains(name);
        }
        s.add("a");
        s.add("a");
        s.add("a");
        s.contains("a ");
        s.contains("a");
    }
}
