public class Employee extends Thread {

    Generator generator;

    @Override
    public void run() {
        answerTheCall();
    }

    public void answerTheCall() {
        while(true) {
            try {
                if (generator != null && !generator.getList().isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + " отвечает на звонок");
                    Thread.sleep(4000);
                    generator.getList().take();
                    System.out.println(Thread.currentThread().getName() + " заявка обработана");
                }
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}
