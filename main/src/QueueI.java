import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QueueI {
    public JPanel analizador;
    public JButton nuevoButton;
    private JTable table1;
    private JTextField puntoTextField;
    private JButton abrirButton;
    private JButton guardarButton;
    private JButton conectarButton;
    private JButton iniciarButton;
    private JButton detenerButton;
    private Queue_linked_list queue = new Queue_linked_list();

    QueueI(){

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
                //queue.enqueue(data);
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
