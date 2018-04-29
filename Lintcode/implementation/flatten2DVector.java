package com.company;

// lc 601. Flatten 2D Vector
// By calling next repeatedly until hasNext returns false.

import java.util.Iterator;
import java.util.List;

public class Vector2D implements Iterator<Integer> {

    // 2 indices are needed.
    int idxList, idxEle;
    List<List<Integer>> res;
    public Vector2D(List<List<Integer>> vec2d) {
        // Initialize your data structure here
        idxList = 0;
        idxEle = 0;
        res = vec2d;
    }

    @Override
    public Integer next() {
        // Write your code here
        return res.get(idxList).get(idxEle++);
    }

    @Override
    public boolean hasNext() {
        // Write your code here
        while (idxList < res.size()) {
            if (idxEle < res.get(idxList).size()) {
                return true;
            }
            idxList++;
            idxEle = 0;
        }
        return false;
    }

    @Override
    public void remove() {}
}

/*
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */