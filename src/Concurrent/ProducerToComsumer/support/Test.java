package Concurrent.ProducerToComsumer.support;

import Concurrent.ProducerToComsumer.Transporter;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class Test<E> implements Transporter<E> {

    private LinkedList<E> buffer;
    private Semaphore semProducer;
    private Semaphore semConsumer;

    public Test(int capacity) {
        this.buffer = new LinkedList<>();
        this.semProducer = new Semaphore(capacity);
        this.semConsumer = new Semaphore(0);
    }

    @Override
    public E get() {
        try {
            semConsumer.acquire();
            synchronized (this) {
                return buffer.removeFirst();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            semProducer.release();
        }
        return null;
    }

    @Override
    public void put(E obj) {
        try {
            semProducer.acquire();
            synchronized (this) {
                buffer.addLast(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            semConsumer.release();
        }
    }
}
