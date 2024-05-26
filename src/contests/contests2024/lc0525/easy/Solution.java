package contests.contests2024.lc0525.easy;

// Accepted after 90 seconds. Trivial

class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {

        int ans = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] % (nums2[j] * k) == 0) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
        return ans;
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