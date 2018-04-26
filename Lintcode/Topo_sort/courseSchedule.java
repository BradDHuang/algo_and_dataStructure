package com.company;

// LC 615. Course Schedule

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
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
//        int[] res = new int[numCourses];
        while (!queue.isEmpty()) {
            int pre = queue.poll();
//            res[count] = pre;
            count++;

            int n = edges[pre].size();
            for (int i = 0; i < n; i++) {
                int p = (int)edges[pre].get(i); // Object should be cast to int.
                indegree[p]--;
                if (indegree[p] == 0) {
                    queue.offer(p);
                }
            }
        }

//        if (count == numCourses) return res;
//        return new int[0];
        return count == numCourses;
    }

    public static void main(String[] args) {

        int n = 2;
        int[][] pre = new int[][]{{1, 0}, {0, 1}};
//        int[] res = findOrder(n, pre);
//        for (int i = 0; i < res.length; i++) {
            System.out.println(canFinish(n, pre));
//        }
    }
}