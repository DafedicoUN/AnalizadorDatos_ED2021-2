import queue.Queue_array;
import queue.Queue_linked_list;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QueueI {
    public JPanel analizador;
    public JButton nuevoButton;
    private JTextField puntoTextField;
    private JButton conectarButton;
    private JButton iniciarButton;
    private JButton detenerButton;
    private JButton llegaButton;
    private JButton atendidoButton;
    private Queue_linked_list queue = new Queue_linked_list();
    boolean connected = false;
    Queue_array q = new Queue_array(50);
    int current = 0;

    QueueI(){

        conectarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String textFieldValue = puntoTextField.getText();
                if(!textFieldValue.equals("")){
                    JOptionPane.showMessageDialog(null, "Conexión exitosa con el puerto " + textFieldValue);
                    connected = true;
                }
            }
        });

        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!connected){
                    JOptionPane.showMessageDialog(null, "No se ha realizado una conexión");
                }
            }
        });

        nuevoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                q.queueEmpty();
                current = 0;
            }
        });

        llegaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!connected){
                    JOptionPane.showMessageDialog(null, "No se ha realizado una conexión");
                } else {
                    current += 1;
                    q.enqueue(current);
                    //q.queueDisplay();
                }
            }
        });
        atendidoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!connected){
                    JOptionPane.showMessageDialog(null, "No se ha realizado una conexión");
                } else {
                    q.dequeue();

                }
            }
        });
    }

    public static void main(String[] args){

    }
}
