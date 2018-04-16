package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws IOException{

        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;

        StringBuilder sb = new StringBuilder();

        while ((line = in.readLine()) != null) {
            String upCase = line.toUpperCase();
            String lowCase = line.toLowerCase();

            boolean up = true;

            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == ' ') {
                    sb.append(' ');
                    continue;
                }

                if (up) {
                    sb.append(upCase.charAt(i));
                    up = false;
                } else {
                    sb.append(lowCase.charAt(i));

                    up = true;
                }
            }
            System.out.println(sb);
        }
    }
}