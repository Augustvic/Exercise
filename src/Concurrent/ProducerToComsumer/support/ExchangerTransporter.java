package Concurrent.ProducerToComsumer.support;

import Concurrent.ProducerToComsumer.Transporter;

import java.util.concurrent.Exchanger;

// 只能用于一对一
public class ExchangerTransporter<E> implements Transporter<E> {

    private final Exchanger<E> exchanger = new Exchanger<>();

    @Override
    public E get() {
        E obj = null;
        try {
            obj = exchanger.exchange(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public void put(E obj) {
        try {
            exchanger.exchange(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
