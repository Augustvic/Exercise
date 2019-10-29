import DataStructure.*;
import Tools.*;
import javafx.util.Pair;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
        t.probablity(2);
    }

    public static test t = new test();

    private int dim = 6;

    private void probablity(int n) {
        int[][] ret = new int[2][dim * n + 1];
        int index = 0;
        for (int i = 1; i <= dim; i++)
            ret[index][i] = 1;
        for (int i = 2; i <= n; i++) {
            index = 1 - index;
            for (int j = i; j <= i * dim; j++) {
                ret[index][j] = 0;
                for (int t = 1; t <= dim && j- t >= i - 1; t++)
                    ret[index][j] += ret[1 - index][j - t];
            }
        }
        double sum = Math.pow(dim, n);
        for (int i = n; i <= n * dim; i++) {
            System.out.println(i + ":" + String.format("%.5f", ret[index][i] / sum));
        }
    }
}
