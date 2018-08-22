
package com.company;

//import java.util.*;

// StringBuilder is more efficient than StringBuffer.

public class Main {

    public static String removeVowels(String str) {

        StringBuilder sb = new StringBuilder();

        String vowels = "aeiouAEIOU";

        for (int i = 0; i < str.length(); i++) {
            if (vowels.indexOf(str.charAt(i)) >= 0) {
                continue;
            }
            sb.append(str.charAt(i));
        }
        return sb.toString();

    }

    public static void main(String[] args) {

        String str = "LAaeiopqopqrt";
        System.out.println(removeVowels(str)); // Lpqpqrt

    }

}








