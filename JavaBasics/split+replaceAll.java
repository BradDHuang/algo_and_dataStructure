package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException{

        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
//            List<Integer> list = new ArrayList<>();
            line = line.replaceAll("\\(| |\\)", "");
            System.out.println(line);
//            line = line.replace(")", "");
//            line = line.replace(" ", "");
            String[] newLine = line.split(",");
            System.out.println(newLine.length);
            for (int i = 0; i < newLine.length; i++) {
                System.out.println(newLine[i]);
            }
        }
    }
}