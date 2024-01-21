package contests.contests2023.lc0408.easy;

// First attempt wrong answer
// Second attempt TLE. TLE on a freaking easy, wth.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int diagonalPrime(int[][] nums) {

        int largestPrime = 0;
        // Forward diagonal
        List<Integer> candidates = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i][i];
            candidates.add(num);
        }
        
        // backward diagonal
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i][nums.length - i - 1];
            candidates.add(num);
        }

        Collections.sort(candidates, Collections.reverseOrder());
        for (Integer e : candidates) {
            if (isPrime(e)) {
                largestPrime = e;
                break;
            }
        }

        System.out.println("ans = " + largestPrime);
        return largestPrime;

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
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.diagonalPrime(new int[][]{{1,2,3},{5,6,7},{9,10,11}});
        sol.diagonalPrime(new int[][]{{1,2,3},{5,17,7},{9,11,10}});

    }
}
