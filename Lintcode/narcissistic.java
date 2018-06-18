
// lc 147. Narcissistic Number

For example the 3-digit decimal number 153 is a narcissistic number because 153 = 1^3 + 5^3 + 3^3.
And the 4-digit decimal number 1634 is a narcissistic number because 1634 = 1^4 + 6^4 + 3^4 + 4^4.
Given n, return all narcissistic numbers with n digits.

You may assume n is smaller than 7.

要求一个整数幂，不能用Math.pow， 
因为Math.pow的return值是double，
所以系统会throw "possible loss of precision" 的exception。

在这种情况下，需要自己写一个power function。


public class Solution {
    /**
     * @param n: The number of digits
     * @return: All narcissistic numbers with n digits
     */
    public List<Integer> getNarcissisticNumbers(int n) {
        // write your code here
        List<Integer> result = new ArrayList<Integer>();
        if (n == 1) {
            for (int i = 0; i < 10; ++i) {
                result.add(i);
            }
            return result;
        }
        // if (n == 6) {
            // result.add(548834); // 节约时间，这是唯一的6位“水仙花数”。
            // return result;
        // }

        for (int i = pow(10, n - 1); i < pow(10, n); i++) {
        // e.g. n = 3, (int i = 100; i < 1000; i++)
            int j = i;
            int s = 0;
            while (j > 0) {
                s += pow((j % 10), n);
                j = j / 10;
            }
            if (s == i) {
                result.add(i);
            }
        }
        return result;
    }
    
    // pow func.
    public int pow(int a, int b) {
        int val = 1;
        for (int i = 1; i <=b; ++i) {
            val *=a;
        }
        return val;
    }
    
}

