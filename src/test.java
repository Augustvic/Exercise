import java.util.*;

public class test {

    public static void main(String[] args) {
        int mask = 1 << 30;
        System.out.println(mask);
        System.out.println(Integer.toBinaryString(mask));
    }

    public static test t = new test();

    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        return Integer.bitCount(z);
    }
}
