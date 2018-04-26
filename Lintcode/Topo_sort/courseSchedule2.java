package com.company;

// LC 616. Course Schedule II

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        // write your code here
        int[] indegree = new int[numCourses];
        List[] edges = new ArrayList[numCourses];

//        for (int i = 0; i < prerequisites.length; i++) {

        // 要记录 numCourses 个 edges！
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList();
        }

//        for (int i = 0; i < numCourses; i++) {

        // 遍历 prerequisites！
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        int[] res = new int[numCourses];
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            res[count] = pre;
            count++;

            int n = edges[pre].size();
            for (int i = 0; i < n; i++) {
                int p = (int)edges[pre].get(i);
                indegree[p]--;
                if (indegree[p] == 0) {
                    queue.offer(p);
                }
            }
        }

        if (count == numCourses) return res;
        return new int[0];
    }

    public static void main(String[] args) {

        int n = 4;
        int[][] pre = new int[][]{{1, 0}, {3, 1}, {2, 0}, {3, 2}};
        int[] res = findOrder(n, pre);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

    }
}