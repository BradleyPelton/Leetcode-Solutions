package _Study.Problems.lcm;


import static _Study.Problems.gcd.Solution.gcdByEuclidsAlgorithm;

public class Solution {
    // NOTE: gcd(a, b) * lcm(a, b) = |a * b|.
    // Thus, lcm(a, b) = |a * b| / gcd(a, b).
    public int getLCM(int a, int b) {
        if (a == 0 || b == 0)
            return 0;
        else {
            int gcdVal = gcdByEuclidsAlgorithm(a, b);
            return Math.abs(a * b) / gcdVal;
        }
    }
}
