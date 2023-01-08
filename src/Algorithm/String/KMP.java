package Algorithm.String;

public class KMP {

    public static void main(String[] args) {
        System.out.println(indexOf("sadbutsad", "but"));
    }

    public static int indexOf(String s, String p) {
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return -1;
        }
        char[] sArr = s.toCharArray(), pArr = p.toCharArray();
        if (p.length() == 1) {
            for (int i = 0; i < sArr.length; i++) {
                if (sArr[i] == pArr[0]) {
                    return i;
                }
            }
        }
        int[] nextArr = buildNextArray(pArr);
        for (int i = 1, j = 0; i <= sArr.length; i++) {
            while (j > 0 && sArr[i - 1] != pArr[j]) j = nextArr[j];
            if (sArr[i - 1] == pArr[j]) j++;
            if (j == pArr.length) return i - pArr.length;
        }
        return -1;
    }

    public static int[] buildNextArray(char[] pArr) {
        int[] nextArr = new int[pArr.length];
        for (int i = 2, j = 0; i < pArr.length; i++) {
            while (j > 0 && pArr[i - 1] != pArr[j]) j = nextArr[j];
            if (pArr[i - 1] == pArr[j]) j++;
            nextArr[i] = j;
        }
        return nextArr;
    }
}
