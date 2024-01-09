package contests.contests2023.lc1111biweekly.mediumone;

import java.util.Arrays;

class Solution {
    public long distributeCandies(int n, int limit) {
        int originalN = n;
        if (limit * 3 < n) {
            System.out.println("too many candies");
            return 0;
        }

        int[] child = new int[3];
        for (int i = 0; i < 3; i++) {
            if (n < limit) {
                child[i] = n;
                break;
            } else {
                child[i] = limit;
                n -= limit;
            }
        }
        int[] childClone = Arrays.copyOf(child, child.length);

        long ans = numberOfUniquePermutations(child);

        // Number of two permutations
        while(child[0] > child[1] + 1) {
            child[0]--;
            child[1]++;
            int newPermutations = numberOfUniquePermutations(child);
            ans += newPermutations;
        }

        child = childClone;
        while(child[2] != Math.min(limit, originalN)) {
            if (child[0] > child[1] + 1) {
                child[0]--;
                child[2]++;
            } else {
                break;
            }
            int newPermutations = numberOfUniquePermutations(child);
            ans += newPermutations;
        }


        System.out.println(ans);
        return ans;
    }

    private int numberOfUniquePermutations(int[] child) {
        int childZero = child[0];
        int childOne = child[1];
        int childTwo = child[2];

        if (childZero == childOne && childOne == childTwo) {
            // all 3 are the same
            return 1;
        } else if (childZero == childOne || childOne == childTwo || childZero == childTwo) {
            // Two identical children
            // 3, 3, 0
            return 3;
        } else {
            // else all 3 are different
            return 6;
        }
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.distributeCandies(5, 2);
        sol.distributeCandies(3, 3);



    }
}