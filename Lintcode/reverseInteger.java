
// lintcode 413. reverse integer

public class Solution {
    /**
     * @param n: the integer to be reversed
     * @return: the reversed integer
     */
    public int reverseInteger(int n) {
        // write your code here
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        char sign = '+';
        if (n < 0) {
            sign = '-';
        } 
        int abs = Math.abs(n);
        long res = 0;
        // while (abs > 10) {
        while (abs > 0) {
            // res += abs/10
            res = res * 10 + abs % 10;
            if (res > max) {
                return 0;
            }
            abs /= 10;
        }
        if (sign == '-') res *= -1;
        if (res < min) return 0;
        return (int) res;
    }
}


public class Solution {
    
    public int reverseInteger(int n) {
        // write your code here
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        
        long res = 0;
        
        while (n != 0) {
            
            res = res * 10 + n % 10;
            if (res > max) {
                return 0;
            }
            
            n /= 10;
        }
        
        if (res < min) return 0;
        return (int) res;
    }
}


