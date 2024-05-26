package contests.contests2024.lc0525.mediumtwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// First Attempt TLE

class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        long ans = 0L;

        // nums1[i] % (nums2[j] * k) == 0

        // nums1[i] = a*b*c

        Map<Integer, List<Integer>> primeMap = new HashMap<>();
        for (int val : nums2) {
            List<Integer> facts = primeFactors(val);

            for (int fact : facts) {
                primeMap.computeIfAbsent(fact, a -> new ArrayList<>()).add();
            }

        }

        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] % k != 0) {
                continue;
            }

            int nums1Val = nums1[i] / k;

            List<Integer> facts = primeFactors(nums1Val);
            facts.add(1);
            Set<Integer> uniqueCombos = uniqueDivisors(facts, nums1Val);

            for (int val : uniqueCombos) {
                ans += occMap.getOrDefault(val, 0);
            }
        }

        System.out.println(ans);
        return ans;
    }

    public static List<Integer> primeFactors(int n) {
        List<Integer> factors = new ArrayList<>();
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

    public static Set<Integer> uniqueDivisors(List<Integer> factors, int max) {
        Set<Integer> uniqueCombos = new HashSet<>();

        for (int i = 0; i < factors.size(); i++) {
            List<Integer> all = new ArrayList<>();
            all.add(factors.get(i));

            for (int j = i + 1; j < factors.size(); j++) {
                List<Integer> local = new ArrayList<>();
                int localVal = factors.get(j);
                for (int val : all) {
                    if (val * localVal <= max) {
                        local.add(val * localVal);
                    }
                }
                all.addAll(local);
            }
            uniqueCombos.addAll(all);
        }
        return uniqueCombos;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.numberOfPairs(
                new int[]{1,3,4},
                new int[]{1,3,4},
                1
        );
        sol.numberOfPairs(
                new int[]{1,2,4,12},
                new int[]{2,4},
                3
        );






    }
}