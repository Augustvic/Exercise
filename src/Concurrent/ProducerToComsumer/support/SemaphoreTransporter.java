package Concurrent.ProducerToComsumer.support;

import Concurrent.ProducerToComsumer.Transporter;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class SemaphoreTransporter<E> implements Transporter<E> {

    private final LinkedList<E> buffer;
    private final Semaphore semProducer;
    private final Semaphore semConsumer;

    public SemaphoreTransporter(int capacity) {
        buffer = new LinkedList<>();
        semProducer = new Semaphore(capacity);
        semConsumer = new Semaphore(0);
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
