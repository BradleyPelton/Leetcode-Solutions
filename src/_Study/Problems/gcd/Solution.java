package _Study.Problems.gcd;

public class Solution {
    public static int gcdByEuclidsAlgorithm(int n1, int n2) {
        // the complexity of Euclid’s algorithm is O(Log min(n1, n2))
        if (n2 == 0) {
            return n1;
        }
        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }

    public static int getGCD(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
