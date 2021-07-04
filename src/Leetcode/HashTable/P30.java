package Leetcode.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P30 {

    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word", "good", "best", "good"};
        List<Integer> ret = findSubstring(s, words);
        System.out.println(ret.toString());
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<>();
        // words statistic
        HashMap<String, Integer> wordMap = new HashMap<>();
        for (String st : words) {
            if (wordMap.containsKey(st)) {
                wordMap.put(st, wordMap.get(st) + 1);
            } else {
                wordMap.put(st, 1);
            }
        }
        // number of words in array
        int wordsNum = words.length;
        // length of one word
        int wordLength = words[0].length();
        // partition the lookup operation into 'wordLength' loops
        for (int i = 0; i < wordLength; i++) {
            HashMap<String, Integer> hm = new HashMap<>();
            int num = 0;
            for (int j = i; j + wordsNum * wordLength < s.length() + 1; j += wordLength) {
                // move forward sliding window until the number of words
                // in the window reaches 'wordsNum'
                while (num < wordsNum && j + (num + 1) * wordLength < s.length() + 1) {
                    String word = s.substring(j + num * wordLength, j + (num + 1) * wordLength);
                    if (wordMap.containsKey(word)) {
                        if (hm.containsKey(word)) {
                            if (hm.get(word) + 1 > wordMap.get(word)) {
                                // plus the start index of window in order to
                                // decrease the number of 'word'
                                int pos = j;
                                while (pos + num * wordLength < s.length() + 1) {
                                    String st = s.substring(pos, pos + wordLength);
                                    decreaseMap(hm, st);
                                    num--;
                                    if (st.equals(word)) {
                                        break;
                                    }
                                    pos += wordLength;
                                }
                                j = pos + wordLength;
                            } else {
                                hm.put(word, hm.get(word) + 1);
                                num++;
                            }
                        } else {
                            hm.put(word, 1);
                            num++;
                        }
                    } else {
                        // the error word occur, clear everything and
                        // restart window sliding from the next index
                        hm.clear();
                        num = 0;
                        j += num * wordLength;
                        break;
                    }
                }
                if (num == wordsNum) {
                    ret.add(j);
                    decreaseMap(hm, s.substring(j, j + wordLength));
                    num--;
                }
            }
        }
        return ret;
    }

    public static void decreaseMap(HashMap<String, Integer> hm, String st) {
        if (hm.get(st) <= 1) {
            hm.remove(st);
        } else {
            hm.put(st, hm.get(st) - 1);
        }
    }
}
