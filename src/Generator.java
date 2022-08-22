import java.util.concurrent.SynchronousQueue;

public class Generator extends Thread {

    protected SynchronousQueue<Integer> list;

    public Generator(SynchronousQueue<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i < 13; i++) {
                System.out.println("Звонок " + i);
                this.list.put(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
