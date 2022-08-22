
import java.util.concurrent.SynchronousQueue;

public class Generator extends Thread {

    protected SynchronousQueue<Integer> list;

    public Generator(SynchronousQueue<Integer> list) {
        this.list = new SynchronousQueue<>();
    }

    public SynchronousQueue<Integer> getList() {
        return list;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i < 60; i++) {
                Thread.sleep(1000);
                System.out.println("Звонок " + i);
                this.list.put(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
