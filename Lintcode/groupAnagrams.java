package com.company;
// lc 772.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static List<List<String>> groupAnagrams(String[] strs) {
//        List<List<String>> res = new ArrayList<>();
//        if (strs == null || strs.length == 0) {
//            return res;
//        }
//
//        HashMap<String, Integer> map = new HashMap<>();
//        for (String str : strs) {
//            char[] chs = str.toCharArray();
//            Arrays.sort(chs);
//
//            String s = new String(chs);
//
//            if (map.containsKey(s)) {
//                List<String> list = res.get(map.get(s));
//                list.add(str);
//            } else {
//                List<String> list = new ArrayList<>();
//                list.add(str);
//                map.put(s, res.size());
//                res.add(list);
//            }
//        }
//        return res;

        // do not sort!
        // counting 26 characters.
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) return res;
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] chs = new int[26];
            for (char ch : str.toCharArray()) {
                chs[ch - 'a']++;
            }
            String s = "";
            for (int i = 0; i < 26; i++) {
                if (chs[i] != 0) {
                    s += String.valueOf(chs[i]) + String.valueOf((char)i + 'a');
                }
            }
            if (!map.containsKey(s)) {

                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, list);
                res.add(list);
            } else {
                List<String> list = map.get(s);
                list.add(str);
            }
        }
        return res;
//        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"hata", "ahah", "taah", "ein", "nie", "nei"};
        List<List<String>> res = groupAnagrams(strs);
        System.out.println(res);
        System.out.println(groupAnagrams(new String[]{}));
        
//        for (int i = 0; i < res.size(); i++) {
//            System.out.println(res.get(i));
//        }
    }
}