package contests.contests2022.lc0219.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public long coutPairs(int[] nums, int k) {

        List<Integer> primeFactorsOfK = primeFactors(k);

        Map<Integer, ArrayList<Integer>> primeMap = new HashMap<>();

        for (int num : nums) {
            for (int primeFactor : primeFactorsOfK) {
                if ( num % k == 0) {
                    if (primeMap.containsKey(primeFactor)) {
                        ArrayList<Integer> curr =  primeMap.get(primeFactor);
                        curr.add(num);
                        primeMap.put(primeFactor, curr);
                    } else {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(num);
                        primeMap.put(primeFactor, temp);
                    }
                }
            }
        }

        return 10;

    }


    public static List<Integer> primeFactors(int numbers) {
        int n = numbers;
        List<Integer> factors = new ArrayList<Integer>();
        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
    }
}