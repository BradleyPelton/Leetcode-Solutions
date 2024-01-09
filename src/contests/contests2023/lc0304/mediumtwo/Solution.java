package contests.contests2023.lc0304.mediumtwo;

import java.util.*;

// First attempt: TLE
// Second attempt: TLE
// Third attempt: TLE

class Solution {
    public int findValidSplit(int[] nums) {



        Map<Integer, Integer> firstOccurenceMap = new TreeMap<>();
        Map<Integer, Integer> lastOccurenceMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> primeFacts = getUniquePrimeFactors(nums[i]);
            for (int e : primeFacts) {
                if (firstOccurenceMap.containsKey(e)) {
                    lastOccurenceMap.put(e, i);
                } else {
                    firstOccurenceMap.put(e, i);
                    lastOccurenceMap.put(e, i);
                }
            }
        }

        num_loop:
        for (int i = 0; i < nums.length - 1; i++) {

            // primes seen so far
            for (int key : firstOccurenceMap.keySet()) {
                if (firstOccurenceMap.get(key) <= i) {
                    if (lastOccurenceMap.get(key) > i) {
                        continue num_loop;
                    }
                    // else prime only occurs left of i
                }
            }
            // ans
            System.out.println("ans found at i = " + i);
            return i;







//            Set<Integer> newPrimeFacts = getUniquePrimeFactors(nums[i]);
//            beforePrimeFactors.addAll(newPrimeFacts);
//
//            for (int pFactor : beforePrimeFactors) {
//                int lastOccurence = lastOccurenceMap.get(pFactor);
//                if (lastOccurence > i) { // if the prime factor occurs in both left and right
//                    continue num_loop;
//                }
//            }
//            System.out.println("ans found at i = " + i);
//            return i;
        }
        System.out.println("no ans");
        return -1;
    }

    public static Set<Integer> getUniquePrimeFactors(int n) {
        Set<Integer> uniquePFactors = new HashSet<>();
        while (n % 2 == 0) {
            uniquePFactors.add(2);
            n /= 2;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                uniquePFactors.add(i);
                n /= i;
            }
        }

        if (n > 2) {
            uniquePFactors.add(n);
        }
        return uniquePFactors;
    }

//    private Set<Integer> getUniquePrimeFactors(int n) {
//        Set<Integer> pFactors = new HashSet<>();
//        for (int i = 2; i <= Math.sqrt(n); i++) {
//            if (n % i == 0) {
//                pFactors.add(i);
//                while (n % i == 0) {
//                    n /= i;
//                }
//            }
//        }
//        if (pFactors.)
//        return pFactors;
//    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findValidSplit(new int[]{4,7,8,15,3,5});
        sol.findValidSplit(new int[]{4,7,15,8,3,5});
    }
}