import trees.BST;

public class Analizador {

    public static void main(String[] args) {
/*
        JFrame frame = new JFrame("Analizador de datos");
        frame.setContentPane(new Interface().analizador);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
*/
        int size = 100;

        BST t = new BST();

        for(int i = size - 1; i > 0 ; i--){
            t.insertElement(i);
        }

        long inicio = System.nanoTime();

        t.insertElement(1);

        long fin = System.nanoTime();

        System.out.println(fin - inicio);
    }
}
