package contests.contests2024.lc0622biweekly.mediumtwo;

// Accepted after 9 minutes
// Cool problem. Fumbled around with indices for a few minutes

class Solution {
    public int minOperations(int[] nums) {

        int n = nums.length;
        int right = n - 1;
        int ans = 0;
        boolean isOneToTheRight = false;

        while (right >= 0) {
            if (nums[right] == 1) {
                isOneToTheRight = true;
                right--;
                continue;
            }
            // else nums[right] == 0;

            while (right > 0 && nums[right - 1] == 0) {
                right--;
            }

            if (isOneToTheRight) {
                ans += 2;
            } else {
                isOneToTheRight = true;
                ans++;
            }
            right--;
        }

        System.out.println(ans);
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minOperations(
                new int[]{0,1,1,0,1}
        ); // 4
        sol.minOperations(
                new int[]{1,0,0,0}
        ); // 1






    }
}