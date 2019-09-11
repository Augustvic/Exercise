import DataStructure.BinaryTreeNode;
import DataStructure.ComplexListNode;
import DataStructure.ListNode;
import Tools.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
//        String s = "abaccdeff";
//        String s = "afaccddff";
        String s = "afaccdeff";
        System.out.println(t.first(s));

        String s1 = "We are students.";
        String s2 = "aeiou";
        System.out.println(t.deleteCharsInString(s1, s2));

        String s3 = "google";
        System.out.println(t.deleteDumplicated(s3));

        String s4 = "silent";
        String s5 = "listen";
        String s6 = "silentes";
        String s7 = "listened";
        System.out.println(t.isAnagram(s4, s5));
        System.out.println(t.isAnagram(s6, s7));
    }

    public static test t = new test();

    public char first(String s) {
        if (StringUtil.isEmpty(s))
            return '1';
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int value = hm.getOrDefault(s.charAt(i), 0);
            hm.put(s.charAt(i), value + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (hm.get(s.charAt(i)) == 1)
                return s.charAt(i);
        }
        return '1';
    }

    public String deleteCharsInString(String s1, String s2) {
        if (StringUtil.isEmpty(s1))
            return null;
        if (StringUtil.isEmpty(s2))
            return s1;
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < s2.length(); i++) {
            hs.add(s2.charAt(i));
        }
        StringBuilder sb = new StringBuilder(s1);
        int index = 0;
        while (index < sb.length()) {
            if (hs.contains(sb.charAt(index))) {
                sb.replace(index, index + 1, "");
            }
            else
                index++;
        }
        return sb.toString();
    }

    public String deleteDumplicated(String s) {
        if (StringUtil.isEmpty(s))
            return null;
        HashSet<Character> hs = new HashSet<>();
        StringBuilder sb = new StringBuilder(s);
        int index = 0;
        while (index < sb.length()) {
            if (hs.contains(sb.charAt(index))) {
                sb.replace(index, index + 1, "");
            }
            else {
                hs.add(sb.charAt(index));
                index++;
            }
        }
        return sb.toString();
    }

    public boolean isAnagram(String s1, String s2) {
        if (StringUtil.isEmpty(s1) || StringUtil.isEmpty(s2))
            return false;
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            int value = hm.getOrDefault(s1.charAt(i), 0);
            hm.put(s1.charAt(i), value + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            if (hm.containsKey(s2.charAt(i))) {
                int value = hm.get(s2.charAt(i));
                if (value <= 0)
                    return false;
                hm.put(s2.charAt(i), value - 1);
            }
            else
                return false;
        }
        return true;
    }
}
