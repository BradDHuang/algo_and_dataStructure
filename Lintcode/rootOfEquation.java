
// lc 239. root of equation

public class Solution {
    /*
     * @param a: parameter of the equation
     * @param b: parameter of the equation
     * @param c: parameter of the equation
     * @return: a double array, contains at most two root
     */
    public double[] rootOfEquation(double a, double b, double c) {
        // write your code here
        // double[] res;
        double delta = b * b - 4 * a * c;
        if (delta < 0) {
            double[] res = new double[0];
            return res;
        } else if (delta == 0) {
            double[] res = new double[1];
            res[0] = -b / (2 * a);
            return res;
        } else {
            double[] res = new double[2];
            res[0] = (-b - Math.sqrt(delta)) / (2 * a);
            res[1] = (-b + Math.sqrt(delta)) / (2 * a);
            
            Arrays.sort(res);
            
            return res;
        }
        // return res;
    }
}


