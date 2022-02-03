import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HeapI {
    public JPanel analizador;
    public JButton nuevoButton;
    private JTable table1;
    private JTextField puntoTextField;
    private JButton abrirButton;
    private JButton guardarButton;
    private JButton conectarButton;
    private JButton iniciarButton;
    private JButton detenerButton;
    //private Heap queue.queue = new queue.Queue_linked_list();

    HeapI(){

        conectarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String textFieldValue = puntoTextField.getText();
            }
        });

        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //get data
                //queue.queue.enqueue(data);
            }
        });

        nuevoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }

    public static void main(String[] args){
        System.out.println("HELLO");
    }
}
