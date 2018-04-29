/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    /**
     * @param n a party with n people
     * @return the celebrity's label or -1
     */
    public int findCelebrity(int n) {
        // Write your code here
        if (n == 1) return 0;
        int t = 0; // 't' is the target who is known by others.
        for (int i = 1; i < n; i++) {
            if (knows(t, i)) t = i;
        }
        // verity t.
        for (int i = 0; i < n; i++) {
            // The definition of a celebrity is that all the other n - 1 people know him/her, 
            // but he/she does not know any of them.
            if (i != t && (knows(t, i) || !knows(i, t))) return -1;
        }
        return t;
    }
}