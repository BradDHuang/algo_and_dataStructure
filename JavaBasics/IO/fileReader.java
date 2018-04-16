package com.company;

import java.io.*;
import java.nio.charset.*;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws IOException{

//        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        FileReader reader = new FileReader("C:\\Users\\huang\\testout.txt");
        BufferedReader in = new BufferedReader(reader);
//        String line;
//        while ((line = in.readLine()) != null) {
//            System.out.println(line);
//        }
        int i;
        while((i = in.read()) != -1){ // reads to the end of the stream
            System.out.print((char)i);
        }
        in.close();
        reader.close();
    }
}