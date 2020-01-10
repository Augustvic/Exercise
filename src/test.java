import DataStructure.*;
import Tools.*;
import com.sun.javafx.css.parser.LadderConverter;
import javafx.util.Pair;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class test {
    public static void main(String[] args) {
        t.printProbability(4);
        System.out.println();
        t.printProbabilityOptimal(4);
    }

    private static test t = new test();

    private static final int dim = 6;

    public void printProbability(int n) {
        int[][] count = new int[2][dim * n + 1];
        int index = 0;
        for (int i = 1; i <= dim; i++)
            count[index][i] = 1;
        for (int i = 2; i <= n; i++) {
            index = 1 - index;
            for (int j = i; j <= i * dim; j++) {
                count[index][j] = 0;
                for (int t = j - 1; t >= i - 1 && t >= j - dim; t--)
                    count[index][j] += count[1 - index][t];
            }
        }
        double sum = Math.pow(dim, n);
        for (int i = n; i <= dim * n; i++) {
            System.out.println(i + ": " + String.format("%.5f", count[index][i] / sum));
        }
    }

    public void printProbabilityOptimal(int n) {
        if (n <= 0)
            return;
        int max = dim * n;
        int[][] arr = new int[2][max + 1];
        int index = 0;
        for (int i = 1; i <= dim; i++) {
            arr[index][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            index = 1 - index;
            for (int j = i; j <= i * dim; j++) {
                arr[index][j] = 0;
                for (int t = 1; t <= dim && j - t >= i - 1; t++) {
                    arr[index][j] += arr[1 - index][j - t];
                }
            }
        }
        double sum = Math.pow(dim, n);
        for (int i = n; i <= dim * n; i++) {
            System.out.println(i + ": " + String.format("%.5f", arr[index][i] / sum));
        }
    }
}
