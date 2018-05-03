package com.company;

// lc 209.
// Find the first unique character in a given string.
// You can assume that there is at least one unique character in the string.

import java.util.HashMap;
//import java.util.Random;

public class Main {

    public static char firstUniqChar(String str) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
//        for (char ch : map.keySet()) { // HashMap keeps the mappings only, not the order.
//            if (map.get(ch) == 1) return ch;
//        }

        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) return str.charAt(i);
        }
        return str.charAt(0);
    }

    public static void main(String[] args) {

        String str = "aeaccdbff";
        System.out.println(firstUniqChar(str));

        System.out.println(Character.MIN_VALUE); // nothing shows on IDEA output window.
        System.out.println(Character.MAX_VALUE);

//        Random r = new Random();
//        System.out.println(r.nextInt(2));
    }

}