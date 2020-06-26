package Concurrent;

import java.util.Date;

public class DeadLock {

    public static void main(String[] args) {
        final NamedLock lock1 = new NamedLock("lock1");
        final NamedLock lock2 = new NamedLock("lock2");
        Thread thread1 = new Thread(new Task(lock1, lock2));
        Thread thread2 = new Thread(new Task(lock2, lock1));
        thread1.start();
        thread2.start();
    }
}

class Task implements Runnable {

    private final NamedLock lock1;
    private final NamedLock lock2;

    public Task(NamedLock lock1, NamedLock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        try {
            synchronized (lock1) {
                System.out.println("[" + new Date().toString() + "] " + Thread.currentThread().getName() + " acquired " + lock1.getName());
                Thread.sleep(2 * 1000);
                synchronized (lock2) {
                    System.out.println("[" + new Date().toString() + "] " + Thread.currentThread().getName() +" acquired " + lock2.getName());
                    Thread.sleep(60 * 1000);
                }
                System.out.println("[" + new Date().toString() + "] " + Thread.currentThread().getName() + " released " + lock2.getName());
            }
            System.out.println("[" + new Date().toString() + "] " + Thread.currentThread().getName() + " released " + lock1.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class NamedLock {
    private final String name;

    public NamedLock(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

