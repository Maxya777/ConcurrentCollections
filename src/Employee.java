import java.util.concurrent.SynchronousQueue;

public class Employee extends Thread {
    private static final int ANSWER = 1500;
    private static final int PROCESSING = 4000;
    private static final int WAIT = 100;
    protected SynchronousQueue<Integer> list;

    public Employee(SynchronousQueue<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        try {
            while (true) {
                answerTheCall();
                Thread.sleep(WAIT);
            }
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

    public void answerTheCall() {
        try {
            for (int i = 1; i < 5; i++) {
                Thread.sleep(ANSWER);
                System.out.println(Thread.currentThread().getName() + " " + i + " отвечает на звонок");
                Thread.sleep(PROCESSING);
                this.list.take();
                System.out.println(Thread.currentThread().getName() + " " + i + " заявка обработана");
            }
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }
}

