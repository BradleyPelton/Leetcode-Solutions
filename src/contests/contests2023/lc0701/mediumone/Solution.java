package contests.contests2023.lc0701.mediumone;

import java.util.*;

// 6 wrong answers
// Then a TLE
// Then a TLE x2
// Then a TLE x3
// Then a TLE x4

class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> primePairs = new ArrayList<>();
        if (n == 1 || n == 2) {
            System.out.println("one or two");
            return primePairs;
        } else if (n == 4) {
            primePairs.add(List.of(2,2));
            System.out.println("4");
            return primePairs;
        } else if (n == 5) {
            primePairs.add(List.of(2,3));
            System.out.println("5");
            return primePairs;
        } else if (n ==  6) {
            primePairs.add(List.of(3,3));
            System.out.println("6");
            return primePairs;
        }

        int left = 2;
        int right = n - 2;
        if (left  <= right && right % 2 != 0 && isPrime(right)) {
            primePairs.add(List.of(left, right));
        }
        left = 3;
        right = n - 3;
        if (right >= 3 && right % 2 != 0 && isPrime(right)) {
            primePairs.add(List.of(left, right));
        }
        left += 2;
        right -= 2;

        while (left <= right) {
            if (isPrime(left)) {
                if (isPrime(right)) {
                    primePairs.add(List.of(left, right));
                }
            }
            left += 2;
            right -= 2;
        }



        System.out.println(primePairs);
        return primePairs;
    }

    boolean isPrime(long n) {
        // SPECIAL isPrime, DO NOT COPY PASTE
        // ASSUMED ODD
        if(n%3 == 0) {
            return false;
        }
        long sqrtN = (long)Math.sqrt(n)+1;
        for(long i = 6L; i <= sqrtN; i += 6) {
            if(n % (i-1) == 0 || n % (i+1) == 0) {
                return false;
            }
        }
        return true;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findPrimePairs(7);
        sol.findPrimePairs(10);
        sol.findPrimePairs(2);
        sol.findPrimePairs(1);
        sol.findPrimePairs(4);
        sol.findPrimePairs(5);
        sol.findPrimePairs(9);
        sol.findPrimePairs(6);
    }
}
