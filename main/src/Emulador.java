import java.util.TimerTask;
import java.lang.Math;
import java.util.concurrent.ThreadLocalRandom;

public class Emulador extends TimerTask {

    private static double data = 0;
    private static final Queue_linked_list queue = new Queue_linked_list();


    @Override
    public void run() {
        queue.enqueue(data);
        queue.queueDisplay();
        queue.queueAverage();
        data = ThreadLocalRandom.current().nextInt(0, 150 + 1);
    }
}
