package com.company;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        // write your code here
        // create hash map
        HashMap newmap = new HashMap();

        // populate hash map
        newmap.put(1, "tutorials");
        newmap.put(2, "point");
        newmap.put(3, "is best");

        System.out.println("Map value before change: "+ newmap);

        // put new values at key 3
        String prevvalue = (String) newmap.put(3,"is great");

        // check returned previous value
        System.out.println("Returned previous value: "+ prevvalue);
        System.out.println(newmap.get(3));

        System.out.println("Map value after change: "+ newmap);

//        Map value before change: {1=tutorials, 2=point, 3=is best}
//        Returned previous value: is best
//        is great
//        Map value after change: {1=tutorials, 2=point, 3=is great}
    }
}