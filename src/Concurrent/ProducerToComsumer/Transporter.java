package Concurrent.ProducerToComsumer;

// 从生产者到消费者
public interface Transporter<E> {
    // 获取
    E get();
    // 放入
    void put(E obj);
}
