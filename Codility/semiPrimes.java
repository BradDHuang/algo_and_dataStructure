package com.company;
// count semi primes
import java.util.Arrays;

public class Main {

    public static int[] solution(int N, int[]P, int[] Q) {
        // write your code in Java SE 8

        if (N < 4) return new int [P.length]; //If Max Number is Less Than 4, Return Array of Zeroes (4 is First Semiprime)

        int M = P.length; //Number of Queries
        int [] semiRanges = new int[M]; //Array of Semiprime Counts Between Ranges
        int [] semisCount = getSemis(N); //Get Count of Semiprimes of Each Number Up to Max

        for (int k = 0; k < M; k++) //Loop Through Queries
            semiRanges[k] = (Q[k] < 4) ? 0 : semisCount[Q[k]] - semisCount[P[k] - 1]; //Subtract Counts to Get Semiprimes Count Between Range

        return semiRanges; //Return Array of Semiprimes Between Ranges
    }

    static int [] getSemis(int N)
    {
        int [] sieve = sifter(N); //Get Array of Minimum Prime Factors
        int [] rsc = new int [N + 1]; //Array of Counts of Semiprimes
        int sc = 0; //Semiprimes Count

        for (int i = 4; i < rsc.length; i++) //Loop From 4 To One More Than Max Number
        {
            if (sieve[i] != 0 && sieve[i / sieve[i]] == 0) sc++; //If Semiprime, Increase Count
            rsc[i] = sc; //Set Count of Semiprimes at Integer
        }

        return rsc; //Return Array of Counts of Semiprimes
    }

    static int [] sifter(int N) //Get Array of Minimum Prime Factors
    {
        int [] sieve = new int [N + 1]; //Array of Minimum Prime Factors

        for (int i = 2; i <= Math.sqrt(N); i++) //Loop From 2 till Max Number
        {
            if (sieve[i] == 0) //If Prime Number
            {
//                Notice that we need not cross out multiples of i which are less than i^2.
//                Such multiples are of the form k · i, where k < i.
//                These have already been removed by one of the prime divisors of k.
                for (int j = i * i; j <= N; j += i) //Find All Multiples
                    if (sieve[j] == 0) sieve[j] = i; //If Prime Factor Isn't Listed, Update
            }
        }

        return sieve; //Return Array of Minimum Prime Factors
    }

    public static void main(String[] args) {

        int[] P = {1, 4, 6};
        int[] Q = {3, 6,11};
        System.out.println(Arrays.toString(solution(11, P, Q)));
    }
}