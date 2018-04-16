package com.company;

import java.util.*;

class Column {
    public int key;
    public String value;
    public Column(int key, String value) {
        this.key = key;
        this.value = value;
    }
}

public class miniCassandra {

    static Map<String, NavigableMap<Integer, String>> hash = new HashMap<>();

//    public MiniCassandra() {
//        // do intialization if necessary
//        hash = new HashMap<>();
//    }

    /*
     * @param raw_key: a string
     * @param column_key: An integer
     * @param column_value: a string
     * @return: nothing
     */
    public static void insert(String raw_key, int column_key, String column_value) {
        // write your code here
        if (!hash.containsKey(raw_key)) {
            hash.put(raw_key, new TreeMap<>());
        }

        hash.get(raw_key).put(column_key, column_value);
    }

    /*
     * @param raw_key: a string
     * @param column_start: An integer
     * @param column_end: An integer
     * @return: a list of Columns
     */
    public static List<Column> query(String raw_key, int column_start, int column_end) {
        // write your code here
        List<Column> res = new ArrayList<>();
        if (!hash.containsKey(raw_key)) {
            return res;
        }

        for (Map.Entry<Integer, String> entry :
                hash.get(raw_key).subMap(column_start, true, column_end, true).entrySet()) {
            res.add(new Column(entry.getKey(), entry.getValue()));
        }
        return res;
    }

    public static void main(String[] args) {
        // write your code here

        insert("google", 1, "haha");
        List<Column> list = query("google", 0, 1);
        System.out.println(list);

    }
}