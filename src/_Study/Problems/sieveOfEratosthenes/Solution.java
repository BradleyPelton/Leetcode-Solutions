package _Study.Problems.sieveOfEratosthenes;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> getListOfPrimes(int limit) {
        boolean[] isComposite = new boolean[limit + 1]; // every number is prime until proven otherwise.
        isComposite[0] = true;
        isComposite[1] = true;

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < limit + 1; i++) {
            if (!isComposite[i]) {
                primes.add(i); // if we've reached the number this far, all primes less than `i` do not divide it.
                for (int factor = 2; factor * i < limit + 1; factor++) {
                    isComposite[i * factor] = true;
                }
            }
        }
        return primes;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.getListOfPrimes(120);
    }
}
