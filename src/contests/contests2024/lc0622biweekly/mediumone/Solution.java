package contests.contests2024.lc0622biweekly.mediumone;

// Accepted after 3 minutes
// Brute force. Surprised it worked, thought there was an edge case around optimization.

class Solution {
    public int minOperations(int[] nums) {

        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] == 0) {
                ans++;
                nums[i + 1] = (nums[i + 1] + 1)% 2;
                nums[i + 2] = (nums[i + 2] + 1 )% 2;
            }
        }

        if (nums[n - 1] == 0 || nums[n - 2] == 0) {
            ans = -1;
        }
        System.out.println(ans);
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minOperations(
                new int[]{0,1,1,1,0,0}
        );
        sol.minOperations(
                new int[]{0,1,1,1}
        );




    }
}