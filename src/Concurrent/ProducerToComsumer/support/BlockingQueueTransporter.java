package Concurrent.ProducerToComsumer.support;

import Concurrent.ProducerToComsumer.Transporter;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTransporter<E> implements Transporter<E> {

    private final BlockingQueue<E> queue;

    public BlockingQueueTransporter(int capacity) {
        queue = new ArrayBlockingQueue<>(capacity);
    }

    @Override
    public E get() {
        try {
            return queue.take();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void put(E obj) {
        try {
            queue.offer(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
