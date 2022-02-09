import heap.Heap;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class HeapI {
    public JPanel analizador;
    public JButton nuevoButton;
    private JTextField puntoTextField;
    private JButton conectarButton;
    private JButton iniciarButton;
    private JButton detenerButton;
    private JButton obtenerLas3MayoresButton;
    private JButton promedioTemperaturaButton;
    boolean connected = false;
    private Heap h = new Heap();
    boolean shutdown = false;

    HeapI(){

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
                } else {
                    shutdown = false;
                    emulador();
                }
            }
        });

        nuevoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!connected){
                    JOptionPane.showMessageDialog(null, "No se ha realizado una conexión");
                } else {
                    h = new Heap();
                }
            }
        });
        detenerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!connected){
                    JOptionPane.showMessageDialog(null, "No se ha realizado una conexión");
                } else {
                    shutdown = true;
                }
            }
        });
        obtenerLas3MayoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!connected){
                    JOptionPane.showMessageDialog(null, "No se ha realizado una conexión");
                } else {
                    JOptionPane.showMessageDialog(null, h.max() + " Grados C°");
                }
            }
        });
    }

    Runnable runnable = new Runnable() {
        double i = 1;
        public void run() {
            if(!shutdown){
                i++;
                h.insert((int) Math.round(Math.log10(i / 2) * 81));
                h.print();
            } else {
                i = 1;
            }
        }
    };

    public void emulador(){
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(runnable, 0, 3, TimeUnit.SECONDS);
    }
}
