package Concurrent.ProducerToComsumer;

public class Consumer implements Runnable{

    private Transporter<String> transporter;

    public Consumer(Transporter<String> transporter) {
        this.transporter = transporter;
    }

    @Override
    public void run() {
        String s;
        while (true) {
            try {
                if ((s = transporter.get()) != null) {
                    System.out.println("[" + Thread.currentThread().getName() + "] " + "consume: " + s);
                } else {
                    Thread.sleep(100);
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
