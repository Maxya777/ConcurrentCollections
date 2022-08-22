import java.util.concurrent.SynchronousQueue;

public class Employee extends Thread {

    protected SynchronousQueue<Integer> list;

    public Employee(SynchronousQueue<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        try {
            do {
                answerTheCall();
                Thread.sleep(100);
            } while (!isInterrupted());
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

    public void answerTheCall() {
        try {
            for (int i = 1; i < 5; i++) {
                Thread.sleep(1500);
                System.out.println(Thread.currentThread().getName() + " " + i + " отвечает на звонок");
                Thread.sleep(4000);
                this.list.take();
                System.out.println(Thread.currentThread().getName() + " " + i + " заявка обработана");
            }
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }
}

