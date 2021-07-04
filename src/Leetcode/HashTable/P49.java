package Leetcode.HashTable;

import java.util.*;

public class P49 {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> ret = groupAnagrams(strs);
        for (List<String> list : ret) {
            System.out.println(list.toString());
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String temp = String.valueOf(chars);
            if (!hm.containsKey(temp)) {
                hm.put(temp, new ArrayList<>());
            }
            hm.get(temp).add(str);
        }
        return new ArrayList<>(hm.values());
    }
}
