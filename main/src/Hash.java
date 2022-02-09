import hash.HashMap;

import javax.swing.*;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Hash {
    public JPanel analizador;
    private JButton iniciarButton;
    private JButton conectarButton;
    private JTextField puntoTextField;
    private JButton nuevoButton;
    private JButton detenerButton;
    private JButton verificarSiSeEncuentraButton;
    private JTextField busquedaTextField;
    private JButton borrarAlumno;
    private JTextField borrarTextField;
    boolean connected = false;
    HashMap h = new HashMap();
    boolean shutdown = false;

    Hash(){

        conectarButton.addActionListener(actionEvent -> {
            String textFieldValue = puntoTextField.getText();
            if(!textFieldValue.equals("")){
                JOptionPane.showMessageDialog(null, "Conexión exitosa con el puerto " + textFieldValue);
                connected = true;
            }
        });

        iniciarButton.addActionListener(actionEvent -> {
            if(!connected){
                JOptionPane.showMessageDialog(null, "No se ha realizado una conexión");
            } else {
                shutdown = false;
                h.add("jcarrilloa", "jcarrilloa@unal.edu.co");
                h.add("cchois", "cchois@unal.edu.co");
                h.add("dafdiazco", "dafdiazco@unal.edu.co");
                emulador();
            }
        });

        nuevoButton.addActionListener(actionEvent -> h.clear());


        verificarSiSeEncuentraButton.addActionListener(actionEvent -> {
            String textFieldValue = busquedaTextField.getText();
            if(!textFieldValue.equals("")){
                String found = h.contains(textFieldValue);
                if(!found.equals("NOT FOUND")){
                    JOptionPane.showMessageDialog(null, "Encontrado con el email " + found);
                } else {
                    JOptionPane.showMessageDialog(null, "No fue encontrado");
                }
            }
        });
        borrarAlumno.addActionListener(actionEvent -> {
            String textFieldValue = borrarTextField.getText();
            if(!textFieldValue.equals("")){
                h.delete(textFieldValue);
                JOptionPane.showMessageDialog(null, textFieldValue + "eliminado");
            }
        });
    }

    Runnable runnable = () -> {
        if(!shutdown){
            String name = generateRandomID(ThreadLocalRandom.current().nextInt(6, 9 + 1));
            String email = generateRandomEmail(ThreadLocalRandom.current().nextInt(6, 9 + 1));
            h.add(name, email);
            System.out.println(name + " " + email);
        }
    };

    public void emulador(){
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(runnable, 0, 3, TimeUnit.SECONDS);
    }

    public static String generateRandomID(int len) {
        String chars = "0123456789 abcdefghijklmnopqrstuvwxyz";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }

    public static String generateRandomEmail(int len) {
        String s = generateRandomID(len);
        if(len % 2 == 0){
            return s + "@gmail.com";
        } else {
            return s + "@yahoo.com";
        }
    }

}
