package Concurrent.ProducerToComsumer.support;

import Concurrent.ProducerToComsumer.Transporter;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestTransporter<E> implements Transporter<E> {

    private final LinkedList<E> buffer;
    private final Semaphore producer;
    private final Semaphore consumer;

    public TestTransporter(int capacity) {
        producer = new Semaphore(capacity);
        consumer = new Semaphore(0);
        this.buffer = new LinkedList<>();
    }

    @Override
    public E get() {
        try {
            consumer.acquire();
            synchronized (this) {
                return buffer.removeFirst();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.release();
        }
        return null;
    }

    @Override
    public void put(E obj) {
        try {
            producer.acquire();
            synchronized (this) {
                buffer.addLast(obj);
            }
            consumer.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
