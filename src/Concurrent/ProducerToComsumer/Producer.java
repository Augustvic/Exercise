package Concurrent.ProducerToComsumer;

public class Producer implements Runnable{

    private final Transporter<String> transporter;
    private int num;

    public Producer(Transporter<String> transporter, int num) {
        this.transporter = transporter;
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 0; i < num; i++) {
            String s = Thread.currentThread().getName() + "-" + i;
            transporter.put(s);
            System.out.println("[" + Thread.currentThread().getName() + "] " + "produce: " + s);
        }
    }
}
