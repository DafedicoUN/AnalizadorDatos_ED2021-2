import javax.swing.*;

public class Analizador {


    public static void main(String[] args) {
        JFrame frame = new JFrame("Analizador de datos");
        frame.setContentPane(new Interface().analizador);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
