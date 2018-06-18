
// lc 235. prime factorization

public class Solution {
    /**
     * @param num: An integer
     * @return: an integer array
     */
    public List<Integer> primeFactorization(int num) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            while (num % i == 0) {
                res.add(i);
                num /= i;
            }
        }
        
        // corner case:
        if (num != 1) res.add(num);
        // e.g. Given 10, return [2, 5].
        
        return res;
    }
}

