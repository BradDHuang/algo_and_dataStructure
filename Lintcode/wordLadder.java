package com.company;

import java.util.*;

public class Main {

    public static int ladderLength(String start, String end, Set<String> dict) {
        if (start.equals(end)) {
            return 1;
        }
        int step = 2; // step用来记录跳数
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            // 控制size来确保一次while循环只计算同一层的节点
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curt = queue.poll();
                // 循环这个word 的第一个到最后一个字母
                for (int j = 0; j < curt.length(); j++) {

                    // 循环每个字母被替换成其他25个字母的情况
                    for (char k = 'a'; k <= 'z'; k++) {
                        StringBuilder sb = new StringBuilder(curt);
                        sb.setCharAt(j, k);
                        String newWord = sb.toString();
                        if (newWord.equals(end)) {
                            return step;
                        } else if (dict.contains(newWord)) {
                            dict.remove(newWord);
                            queue.offer(newWord);
                        }
                    }
                }
            }
            step++;
        }
        return 0;
    }

    public static void main(String[] args) {
        // write your code here
        String start = "cat";
        String end = "dot";
//        Set<String> dict = new HashSet<>();
//        dict.add("cot");
//        dict.add("cog");
        Set<String> dict = new HashSet<>(Arrays.asList("cot", "cog"));
        // this is not time efficient since you are constructing an array,
        // converting to a list and using that list to create a set.

        System.out.println(ladderLength(start, end, dict));
    }
}