import DataStructure.*;
import Tools.*;
import com.sun.javafx.css.parser.LadderConverter;
import javafx.util.Pair;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService service = Executors.newFixedThreadPool(3);
        CountDownLatch latch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("子线程 " + Thread.currentThread().getName() + " 开始执行");
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("子线程 " + Thread.currentThread().getName() + " 执行完毕");
                        latch.countDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            service.execute(runnable);
        }
        try{
            System.out.println("主线程 " + Thread.currentThread().getName() + " 等待子线程完成");
            latch.await();
            System.out.println("主线程 " + Thread.currentThread().getName() + " 执行完毕");
            service.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
