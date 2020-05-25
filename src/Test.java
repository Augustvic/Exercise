import DataStructure.TreeNode;
import com.oracle.jrockit.jfr.Producer;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Consumer;

public class Test {

    public static void main(String[] args) {
        ExecutorService executor = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.SECONDS, new SynchronousQueue<>());
        for (int i = 0; i < 100; i++) {
            executor.execute(new Task());
            System.out.println(i);
        }
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

