import DataStructure.*;
import Tools.*;
import com.sun.javafx.css.parser.LadderConverter;
import javafx.util.Pair;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(t.ladderLength(beginWord, endWord, wordList));
    }

    public static test t = new test();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        int begin = wordList.size() - 1;
        int end = wordList.indexOf(endWord);
        List<Integer>[] graph = buildGraph(wordList);
        return getShortestPath(wordList, graph, begin, end);
    }

    private List<Integer>[] buildGraph(List<String> wordList) {
        List<Integer>[] graph = new List[wordList.size()];
        for (int i = 0; i < wordList.size(); i++) {
            graph[i] = new LinkedList<>();
            for (int j = 0; j < wordList.size(); j++) {
                if (j != i && isConnect(wordList.get(i), wordList.get(j)))
                    graph[i].add(j);
            }
        }
        return graph;
    }

    private boolean isConnect(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length() && diff <= 1; i++) {
            if (s1.charAt(i) != s2.charAt(i))
                diff++;
        }
        return diff == 1;
    }

    private int getShortestPath(List<String> wordList, List<Integer>[] graph, int begin, int end) {
        Deque<Integer> aq = new ArrayDeque<>();
        boolean[] visited = new boolean[wordList.size()];
        aq.offer(begin);
        visited[begin] = true;
        int path = 0;
        while (!aq.isEmpty()) {
            int len = aq.size();
            path++;
            while (len-- > 0) {
                int curr = aq.poll();
                for (int k : graph[curr]) {
                    if (curr == end)
                        return path + 1;
                    if (visited[k])
                        continue;
                    visited[k] = true;
                    aq.offer(k);
                }
            }
        }
        return 0;
    }
}
