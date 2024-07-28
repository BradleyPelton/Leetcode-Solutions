package contests.contests2024.lc0727.mediumone;

// First attempt TLE
// SEcond attempt TLE

// Third attempt accepted
// Had to use the Sieve of Eratosthenes. was not aware isPrime was so slow.

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int nonSpecialCount(int l, int r) {

        int numberOfSquares = 0;
        int lowestVal = (int) Math.sqrt(l);
        int largestVal = (int) Math.sqrt(r) + 1;

        List<Integer> primes = getListOfPrimes(largestVal);
        for (int prime : primes) {
            long square = prime * prime;
            if (square > r) {
                break;
            } else if (square >= l && square <= r) {
                numberOfSquares++;
            }
        }


//        for (int i = lowestVal; i < largestVal; i++) {
//            long square = ((long) i) * i;
//
//            if (square > r) {
//                break;
//            } else if (square >= l && square <= r) {
//
//                if (isPrime(i)) {
//                    numberOfSquares++;
//                }
//            }
//        }

        int ans = r - l + 1 - numberOfSquares;
        System.out.println(ans);
        return ans;
    }

    private boolean isPrime(int e) {
        if (e == 0 || e == 1) {
            return false;
        }

        for(int i=2;i<=e/2;i++) {
            int temp=e % i;
            if(temp==0) {
                return false;
            }
        }
        return true;
    }

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
        sol.nonSpecialCount(5,7);
        sol.nonSpecialCount(4, 16);




    }
}