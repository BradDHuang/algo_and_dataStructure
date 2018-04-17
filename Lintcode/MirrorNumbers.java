package com.company;

// LC 644. Mirror Numbers

import java.util.HashMap;
import java.util.Map;

public class MirrorNumbers {

    public static boolean isStrobogrammatic(String num) {
        // write your code here
        Map<Character, Character> map = new HashMap<>();

        if ( num == null) {
            return false;
        }

        map.put('0', '0');
        map.put('1', '1');
        // map.put('2', '2');
        // map.put('3', '3');
        // map.put('4', '4');
        // map.put('5', '5');
        map.put('6', '9');
        // map.put('7', '7');
        map.put('8', '8');
        map.put('9', '6');

        for (int i = 0; i < num.length(); i++) {

            if (!map.containsKey(num.charAt(i))) {
                return false;
            }

            if (map.get(num.charAt(i)) != num.charAt(num.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // write your code here

        String str = "69";
        System.out.println(isStrobogrammatic(str));
    }

}