package contests.contests2024.lc0210.mediumone;


// Accepted first attempt
// Accepted after 12 minutes

// Lost 5 minutes debugging off by one bug



class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int slidingWindowLength = pattern.length;

        int numberOfGoodSubarrays = 0;
        OUTER_LOOP:
        for (int left = 0; left < n - slidingWindowLength; left++) {
            int previousVal = nums[left];
            for (int i = 0; i < slidingWindowLength; i++) {
                int currVal = nums[left + i + 1];
                if (pattern[i] ==  0) {
                    if (currVal != previousVal) {
                        continue OUTER_LOOP;
                    }
                } else if (pattern[i] == 1) {
                    if (currVal <= previousVal) {
                        continue OUTER_LOOP;
                    }
                } else if (pattern[i] == -1) {
                    if (currVal >= previousVal) {
                        continue OUTER_LOOP;
                    }
                }
                previousVal = currVal;
            }
            numberOfGoodSubarrays++;
        }

        System.out.println(numberOfGoodSubarrays);
        return numberOfGoodSubarrays;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.countMatchingSubarrays(
                new int[]{1,2,3,4,5,6},
                new int[]{1,1}
        );
        sol.countMatchingSubarrays(
                new int[]{1,4,4,1,3,5,5,3},
                new int[]{1,0,-1}
        );



    }
}