import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.SynchronousQueue;

public class Main {

    public static void main(String[] args) {

        SynchronousQueue<Integer> list = new SynchronousQueue<>();
        Thread generator = new Generator(list);
        generator.start();

//        for (int i = 1; i < 5; i++) {
//            Thread employee = new Thread(null, new Employee(), "Сотрудник " + i);
//            employee.start();
//        }
        Thread employee = new Thread(null, new Employee(), " Сотрудник");
        employee.start();

    }
}
