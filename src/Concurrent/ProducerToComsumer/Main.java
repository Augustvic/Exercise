package Concurrent.ProducerToComsumer;

import Concurrent.ProducerToComsumer.support.*;

public class Main {

    public static void main(String[] args) {
        testTest();
    }

    private static void testSemaphore() {
        Transporter<String> transporter = new SemaphoreTransporter<>(2);
        int num = 5;
        Thread producer1 = new Thread(new Producer(transporter, num),"producer1");
        Thread producer2 = new Thread(new Producer(transporter, num),"producer2");
        Thread consumer1 = new Thread(new Consumer(transporter),"consumer1");
        Thread consumer2 = new Thread(new Consumer(transporter),"consumer2");
        consumer1.start();
        consumer2.start();
        producer1.start();
        producer2.start();
    }

    private static void testExchanger() {
        Transporter<String> transporter = new ExchangerTransporter<>();
        int num = 5;
        Thread producer = new Thread(new Producer(transporter, num),"producer");
        Thread consumer = new Thread(new Consumer(transporter),"consumer");
        consumer.start();
        producer.start();
    }

    private static void testCondition() {
        Transporter<String> transporter = new ConditionTransporter<>(2);
        int num = 5;
        Thread producer1 = new Thread(new Producer(transporter, num),"producer1");
        Thread producer2 = new Thread(new Producer(transporter, num),"producer2");
        Thread consumer1 = new Thread(new Consumer(transporter),"consumer1");
        Thread consumer2 = new Thread(new Consumer(transporter),"consumer2");
        consumer1.start();
        consumer2.start();
        producer1.start();
        producer2.start();
    }

    private static void testBlockingQueue() {
        Transporter<String> transporter = new BlockingQueueTransporter<>(2);
        int num = 5;
        Thread producer1 = new Thread(new Producer(transporter, num),"producer1");
        Thread producer2 = new Thread(new Producer(transporter, num),"producer2");
        Thread consumer1 = new Thread(new Consumer(transporter),"consumer1");
        Thread consumer2 = new Thread(new Consumer(transporter),"consumer2");
        consumer1.start();
        consumer2.start();
        producer1.start();
        producer2.start();
    }

    private static void testTest() {
        Transporter<String> transporter = new TestTransporter<>(2);
        int num = 5;
        Thread producer1 = new Thread(new Producer(transporter, num),"producer1");
        Thread consumer1 = new Thread(new Consumer(transporter),"consumer1");
        Thread producer2 = new Thread(new Producer(transporter, num),"producer2");
        Thread consumer2 = new Thread(new Consumer(transporter),"consumer2");
        consumer1.start();
        producer1.start();
        consumer2.start();
        producer2.start();
    }
}
