package Concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintInorder {

    private static final int N = 10;

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();
        AtomicInteger count = new AtomicInteger(0);
        Thread threadA = new Thread(new TaskA(lock, conditionA, conditionB, conditionC, count));
        Thread threadB = new Thread(new TaskB(lock, conditionA, conditionB, conditionC, count));
        Thread threadC = new Thread(new TaskC(lock, conditionA, conditionB, conditionC, count));
        threadA.start();
        threadB.start();
        threadC.start();
    }

    static class TaskA implements Runnable {

        final Lock lock;
        final Condition conditionA;
        final Condition conditionB;
        final Condition conditionC;
        final AtomicInteger count;

        public TaskA(Lock lock, Condition conditionA, Condition conditionB,
                     Condition conditionC, AtomicInteger count) {
            this.lock = lock;
            this.conditionA = conditionA;
            this.conditionB = conditionB;
            this.conditionC = conditionC;
            this.count = count;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < N; i++) {
                    while ((count.get() % 3) != 0) {
                        conditionA.await();
                    }
                    System.out.print("A");
                    count.getAndIncrement();
                    conditionB.signal();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class TaskB implements Runnable {

        final Lock lock;
        final Condition conditionA;
        final Condition conditionB;
        final Condition conditionC;
        final AtomicInteger count;

        public TaskB(Lock lock, Condition conditionA, Condition conditionB,
                     Condition conditionC, AtomicInteger count) {
            this.lock = lock;
            this.conditionA = conditionA;
            this.conditionB = conditionB;
            this.conditionC = conditionC;
            this.count = count;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < N; i++) {
                    while ((count.get() % 3) != 1) {
                        conditionB.await();
                    }
                    System.out.print("B");
                    count.getAndIncrement();
                    conditionC.signal();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class TaskC implements Runnable {

        final Lock lock;
        final Condition conditionA;
        final Condition conditionB;
        final Condition conditionC;
        final AtomicInteger count;

        public TaskC(Lock lock, Condition conditionA, Condition conditionB,
                     Condition conditionC, AtomicInteger count) {
            this.lock = lock;
            this.conditionA = conditionA;
            this.conditionB = conditionB;
            this.conditionC = conditionC;
            this.count = count;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < N; i++) {
                    while ((count.get() % 3) != 2) {
                        conditionC.await();
                    }
                    System.out.print("C");
                    count.getAndIncrement();
                    conditionA.signal();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
