import java.util.concurrent.SynchronousQueue;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        SynchronousQueue<Integer> list = new SynchronousQueue<>();
        Thread generator = new Generator(list);
        generator.start();

        Thread employee = new Thread(null, new Employee(list), " Сотрудник");
        employee.start();

        generator.join();
        employee.interrupt();
    }
}
