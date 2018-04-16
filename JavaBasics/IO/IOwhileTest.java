package com.company;

import java.io.*;
import java.nio.charset.*;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws IOException{

        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
//        String line;
//        while ((line = in.readLine()) != null) {
//            System.out.println(line);
//        }

        String name="";
        while(!name.equals("stop")){
            System.out.println("Enter data: ");
            name = in.readLine();
            System.out.println("data is: " + name);
        }
        in.close();
        reader.close();
    }
}