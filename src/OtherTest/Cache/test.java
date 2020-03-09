package OtherTest.Cache;

import java.text.NumberFormat;
import java.util.Random;

public class test {

    private static final String lru = "lru";
    private static final String lfu = "lfu";

    private static final int N = 1000000;
    private static final double rate = 1;

    private static NumberFormat numberFormat = NumberFormat.getInstance();

    public static void main(String[] args) {
        Random rand = new Random();
        int[] nums = new int[N];
        // 生成随机数
        for(int i = 0; i < rate * N; i++) {
            nums[i] = rand.nextInt(100) + 1;
        }
        for (int i = (int)Math.floor(rate * N); i < N; i++) {
            nums[i] = rand.nextInt(1000) + 1;
        }
        LRUCache<Integer, String> lruCache = new LRUCache<>(100);
        LFUCache<Integer, String> lfuCache = new LFUCache<>(100);
        numberFormat.setMaximumFractionDigits(4);
        int lruHit = 0;
        for(int i = 0; i < N; i++) {
            if (lruCache.containsKey(nums[i]))
                lruHit++;
            lruCache.put(nums[i], lru);
        }
        System.out.println(numberFormat.format(((float)lruHit) / N));
        int lfuHit = 0;
        for(int i = 0; i < N; i++) {
            if (lfuCache.containsKey(nums[i]))
                lfuHit++;
            lfuCache.put(nums[i], lfu);
        }
        System.out.println(numberFormat.format(((float)lfuHit) / N));
    }
}
