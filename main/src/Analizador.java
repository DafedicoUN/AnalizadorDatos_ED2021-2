import priorityQueue.PQ_binary_heap;

public class Analizador {

    public static void main(String[] args) {
/*
        JFrame frame = new JFrame("Analizador de datos");
        frame.setContentPane(new Interface().analizador);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
*/
        int size = 1000000;

        PQ_binary_heap pq = new PQ_binary_heap(size);

        for(int i = size - 1; i > 0 ; i--){
            PQ_binary_heap.insert(i);
        }

        long inicio = System.nanoTime();

        PQ_binary_heap.getMax();

        long fin = System.nanoTime();

        System.out.println(fin - inicio);
    }
}
