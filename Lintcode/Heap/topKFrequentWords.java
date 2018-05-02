package com.company;

// lc 471.

import java.util.*;

class Pair {
    String key;
    int val;
    Pair(String key, int val) {
        this.key = key;
        this.val = val;
    }
}
public class Main {

    public static String[] topKFrequentWords(String[] words, int k) {
        // Write your code here

        HashMap<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 1) + 1);
        }
        // Heap.
        PriorityQueue<Pair> maxHeap =
                new PriorityQueue<>(new Comparator<Pair>() {
                    @Override
                    public int compare(Pair o1, Pair o2) {
                        if (o1.val != o2.val) return o2.val - o1.val;
                        // If two words has the same frequency,
                        // the one with lower alphabetical order come first.
                        return o1.key.compareTo(o2.key);
                    }
                });
        for (String key : map.keySet()) {
            maxHeap.offer(new Pair(key, map.get(key)));
        }
        String[] res = new String[k];
        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll().key;
        }
        return res;
    }

    public static void main(String[] args) {

        String[] s = {"yes", "lint", "code",
                      "yes", "code", "baby",
                      "you", "baby", "chrome",
                      "safari", "lint", "code",
                      "body", "lint", "code"};
        String[] res = topKFrequentWords(s, 3);
        System.out.println(Arrays.asList(res)); // return ["code", "lint", "baby"]
    }

}