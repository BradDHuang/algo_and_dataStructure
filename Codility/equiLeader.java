package com.company;

import java.util.HashMap;

public class Main {

    public static int solution(int[] A) {
        // write your code in Java SE 8

        if (A == null || A.length <= 1) return 0;

        // find the leader of the whole arr.(if any)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            if (!map.containsKey(a)) {
                map.put(a, 1);
            } else {
                map.put(a, map.get(a) + 1);
            }
        }
        int leaderVal = 0;
        int leaderCnt = 0;
        for (int key : map.keySet()) {
            if (map.get(key) > A.length / 2) {
                leaderCnt = map.get(key);
                leaderVal = key;
            }
        }
        int equiNums = 0;
        int leftLeaderCnt = 0;
        int rightLeaderCnt;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == leaderVal) {
                leftLeaderCnt++;
            }
            if (leftLeaderCnt > (i + 1) / 2) {
                rightLeaderCnt = leaderCnt - leftLeaderCnt;
                if (rightLeaderCnt > (A.length - (i + 1)) / 2) {
                    equiNums++;
                }
            }
        }
        return equiNums;
    }

    public static void main(String[] args) {

        int[] A = {4,3,4,4,4,2};
        System.out.println(solution(A));
    }

}