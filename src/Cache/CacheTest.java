package Cache;

import java.lang.reflect.Method;
import java.util.*;

public class CacheTest {
    public static void main(String[] args) {
        // 缓存区大小
        final int nCache = 500;
        // 数据量
        final int nNum = 100000;
        // 数据出现 1 次的比率-数据出现 2 次的比率-数据出现 4 次的比率-数据出现 8 次的比率-数据出现 100 次的比率
        final Ratio[] ratioSet = {
                new Ratio(0, 0, 0, 0, 100),
                new Ratio(10, 10, 10, 20, 50),
                new Ratio(20, 20, 20, 20, 20),
                new Ratio(50, 20, 10, 10, 10),
                new Ratio(70, 20, 10, 0, 0)
        };
        // 缓存策略
        LFUCache<Integer, Object> lfuCache = new LFUCache<>(nCache);
        LRUCache<Integer, Object> lruCache = new LRUCache<>(nCache);
        LRU2Cache<Integer, Object> lru2Cache = new LRU2Cache<>(nCache);
        PureLRUCache<Integer, Object> pureLruCache = new PureLRUCache<>(nCache);
        // 开始测试
        for (Ratio ratio : ratioSet) {
            int[] data = test.getData(nNum, ratio);
            double lfuRate = test.hitRate(lfuCache, data);
            double lruRate = test.hitRate(lruCache, data);
            double lru2Rate = test.hitRate(lru2Cache, data);
            double pureLruRate = test.hitRate(pureLruCache, data);
            System.out.println("LFU-ratio-" + ratio.toString() + ": " + lfuRate);
            System.out.println("LRU-ratio-" + ratio.toString() + ": " + lruRate);
            System.out.println("LRU2-ratio-" + ratio.toString() + ": " + lru2Rate);
            System.out.println("PureLRU-ratio-" + ratio.toString() + ": " + pureLruRate);
        }
    }

    public static CacheTest test = new CacheTest();

    private static final Map<String, Integer> RATIO_CONSTANT = new HashMap<>();
    static {
        RATIO_CONSTANT.put("OneRatio", 1);
        RATIO_CONSTANT.put("TwoRatio", 2);
        RATIO_CONSTANT.put("FourRatio", 4);
        RATIO_CONSTANT.put("EightRatio", 8);
        RATIO_CONSTANT.put("HundredRatio", 100);
    };
    private static final Class<Ratio> RATIO_CLASS = Ratio.class;
    private static final Random RANDOM = new Random();

    // 获取数据
    public int[] getData(int n, Ratio ratio) {
        int[] data = new int[n];
        int num = 1;
        Map<String, Integer> ratioMap = calculateRatioNum(n, ratio);
        for (Map.Entry<String, Integer> entry : ratioMap.entrySet()) {
            final int constant = RATIO_CONSTANT.get(entry.getKey());
            int constantT = constant;
            for (int i = 0; i < entry.getValue(); i++) {
                if (constantT == 0) {
                    num++;
                    constantT = constant;
                }
                int index = nextRandomIndex(n, data);
                data[index] = num;
                constantT--;
            }
        }
        return data;
    }

    // 命中率
    public double hitRate(Object cache, int[] data) {
        Object value = new Object();
        if (cache instanceof LFUCache) {
            LFUCache<Integer, Object> cacheT = (LFUCache<Integer,Object>) cache;
            int hits = 0;
            for (int k : data) {
                if (cacheT.containsKey(k))
                    hits++;
                cacheT.put(k, value);
            }
            return ((double) hits) / data.length;
        } else if (cache instanceof Map){
            Map<Integer, Object> cacheT = (Map<Integer, Object>) cache;
            int hits = 0;
            for (int k : data) {
                if (cacheT.containsKey(k))
                    hits++;
                cacheT.put(k, value);
            }
            return ((double) hits) / data.length;
        } else if (cache instanceof PureLRUCache){
            PureLRUCache<Integer, Object> cacheT = (PureLRUCache<Integer, Object>) cache;
            int hits = 0;
            for (int k : data) {
                if (cacheT.containsKey(k))
                    hits++;
                cacheT.put(k, value);
            }
            return ((double) hits) / data.length;
        }
        return 0.0d;
    }

    private Map<String, Integer> calculateRatioNum(int n, Ratio ratio) {
        Map<String, Integer> ratioMap = new HashMap<>();
        for (String s : RATIO_CONSTANT.keySet()) {
            try {
                Method method = RATIO_CLASS.getMethod("get" + s);
                int num = (Integer)method.invoke(ratio) * n / 100;
                ratioMap.put(s, num);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ratioMap;
    }

    private int nextRandomIndex(int n, int[] data) {
        int index = RANDOM.nextInt(n);
        while (data[index] != 0) {
            index = (index + 1 == n) ? 0 : index + 1;
        }
        return index;
    }
}

class Ratio {
    private int oneRatio;
    private int twoRatio;
    private int fourRatio;
    private int eightRatio;
    private int hundredRatio;

    public Ratio(int oneRate, int twoRate, int fourRatio, int eightRatio, int hundredRatio) {
        this.oneRatio = oneRate;
        this.twoRatio = twoRate;
        this.fourRatio = fourRatio;
        this.eightRatio = eightRatio;
        this.hundredRatio = hundredRatio;
    }

    public int getOneRatio() {
        return oneRatio;
    }

    public int getTwoRatio() {
        return twoRatio;
    }

    public int getFourRatio() {
        return fourRatio;
    }

    public int getEightRatio() {
        return eightRatio;
    }

    public int getHundredRatio() {
        return hundredRatio;
    }

    @Override
    public String toString() {
        return "[one-" + oneRatio + "-two-" + twoRatio + "-four-" + fourRatio + "-eight-" + eightRatio + "-hundred-" + hundredRatio + "]";
    }
}
