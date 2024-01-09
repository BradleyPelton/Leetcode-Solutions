package contests.contests2023.lc0415biweekly.mediumone;

// Accepted after 10 minutes
// Took longer to understand the question than to implement a solution
// Accepted first try


class Solution {
    public long[] findPrefixScore(int[] nums) {

        long[] ans = new long[nums.length];
        long[] maxSoFar = new long[nums.length];
        long[] conversionArr = new long[nums.length];

        long scoreSoFar = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                maxSoFar[i] = nums[i];
                conversionArr[i] = nums[i] * 2L;
            } else {
                maxSoFar[i] = Math.max(nums[i], maxSoFar[i - 1]);
                conversionArr[i] = nums[i] + maxSoFar[i];
            }
            scoreSoFar += conversionArr[i];
            ans[i] = scoreSoFar;
        }

//        System.out.println(Arrays.toString(ans));
        return ans;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findPrefixScore(new int[]{2,3,7,5,10});
        sol.findPrefixScore(new int[]{1,1,2,4,8,16});
    }
}