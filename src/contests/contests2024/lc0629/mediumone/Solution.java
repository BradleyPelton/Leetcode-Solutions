package contests.contests2024.lc0629.mediumone;

// Accepted after 8 minutes
// Tricky medium.
// Accepted first try.

class Solution {
    public int maximumLength(int[] nums) {

        int numberOfEvens = 0;
        int numberOfOdds = 0;
        int alternatingLength = 1;
        boolean isEven = nums[0] % 2 == 0;
        if (isEven) {
            numberOfEvens++;
        } else {
            numberOfOdds++;
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                numberOfEvens++;
                if (!isEven) {
                    alternatingLength++;
                    isEven = true;
                }
            } else {
                numberOfOdds++;
                if (isEven) {
                    alternatingLength++;
                    isEven = false;
                }
            }
        }

        int ans = Math.max(alternatingLength, Math.max(numberOfEvens, numberOfOdds));
        System.out.println(ans);
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maximumLength(
                new int[]{1,2,3,4}
        );
        sol.maximumLength(
                new int[]{1,2,1,1,2,1,2}
        );
        sol.maximumLength(
                new int[]{1,3}
        );





    }
}
