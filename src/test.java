import DataStructure.*;
import Tools.*;
import com.sun.javafx.css.parser.LadderConverter;
import javafx.util.Pair;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

public class test {

    private static SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");

    public static void main(String[] args) {
        // 创建 newFixedThreadPool 仅用作示例
        ExecutorService service = Executors.newFixedThreadPool(7);
        Semaphore semaphore = new Semaphore(3);
        CountDownLatch latch = new CountDownLatch(7);
        System.out.println(Thread.currentThread().getName() + " 在线程池开启之前，查询到当前许可证数量为 " + semaphore.availablePermits());
        for (int i = 0; i < 7; i++) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + " 获取到许可证，当前时间为 " + df.format(new Date()));
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + " 准备释放许可证，释放前查询到当前可使用许可证数量为 " + semaphore.availablePermits());
                        System.out.println(Thread.currentThread().getName() + " 准备释放许可证，当前时间为 " + df.format(new Date()));
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        latch.countDown();
                    }
                }
            };
            service.execute(task);
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }
        System.out.println(Thread.currentThread().getName() + " 在线程池关闭之后，查询到当前许可证数量为 " + semaphore.availablePermits());
    }
}
