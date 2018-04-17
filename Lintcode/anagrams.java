package com.company;

// LC 171. Anagrams

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class anagrams {

    public static List<String> anagrams(String[] strs) {
        // write your code here
        List<String> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }

        HashMap<String, String> map = new HashMap<>();
        // int count = 0;
        for (String str : strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String s = new String(chs);
            if (map.containsKey(s)) {
                String list = map.get(s);
                if (!res.contains(list)) {
                    res.add(list);
                }

                res.add(str);
            } else {
                // List<String> list = new ArrayList();
                // list.add(str);
                map.put(s, str);

            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"in","ni","ni","ii"};
        System.out.println(anagrams(strs));
    }
}