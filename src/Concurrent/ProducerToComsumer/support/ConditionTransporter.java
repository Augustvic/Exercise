package Concurrent.ProducerToComsumer.support;

import Concurrent.ProducerToComsumer.Transporter;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTransporter<E> implements Transporter<E> {

    private final LinkedList<E> buffer;
    private int capacity;
    private final Lock lock;
    private final Condition notFull;
    private final Condition notEmpty;

    public ConditionTransporter(int capacity) {
        this.buffer = new LinkedList<>();
        this.capacity = capacity;
        this.lock = new ReentrantLock();
        this.notFull = lock.newCondition();
        this.notEmpty = lock.newCondition();
    }

    @Override
    public E get() {
        try {
            lock.lock();
            while (buffer.isEmpty()) {
                notEmpty.await();
            }
            E val = buffer.removeFirst();
            notFull.signalAll();
            return val;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }

    @Override
    public void put(E obj) {
        try {
            lock.lock();
            while (buffer.size() >= capacity) {
                notFull.await();
            }
            buffer.addLast(obj);
            notEmpty.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
