package com.company;

// leetcode 204.
//  Count the number of prime numbers less than a non-negative number, n.

public class Main {

    public static int countPrimes(int n) {
        // write your code here

        // Sieve of Eratosthenes. O(nloglogn).
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
                for (int j = 2; j * i < n; j++) {
                    notPrime[j * i] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        System.out.println(countPrimes(26)); // 9
        System.out.println(countPrimes(5)); // 2

    }

}