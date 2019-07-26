import java.util.*;

public class test {

    public static void main(String[] args) {
        System.out.println(t.hammingDistance(1, 4));
    }

    public static test t = new test();

    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        return Integer.bitCount(z);
    }
}
