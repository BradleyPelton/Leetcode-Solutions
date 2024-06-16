package contests.contests2024.lc0615.hard;

import java.util.ArrayList;
import java.util.List;

// No answer submitted.
// There was a really cool data structure for solving this called a "segment tree"
// TODO - lean "Segment Trees"

class Solution {
    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        boolean[] isPeak = new boolean[n];
        prefixSum[0] = 0;
        for (int i = 1; i < n - 1; i++) {
            prefixSum[i] = prefixSum[i - 1];
            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                isPeak[i] = true;
                prefixSum[i]++;
            }
        }
        prefixSum[n - 1] = prefixSum[n - 2];


        
        List<Integer> queryResults = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            if (queries[i][0] == 1) {
                int originalPeakSum = prefixSum[query[1]] - prefixSum[query[0] - 1];

                //queryResults.add();
            } else {
                int index = query[1];
                int updateValue = query[2];
                if (index == 0) {

                } else if (index == n - 1) {

                } else {
                    if (isPeak[index - 1]) {
                        if (nums[index - 1] <= updateValue) {
                            isPeak[index - 1] = false;
                        }
                    }

                    if (isPeak[index]) {
                        if (nums[index - 1] <= updateValue || nums[index + 1] >= updateValue) {
                            isPeak[index] = false;
                        }
                    }

                    if (isPeak[index + 1]) {
                        if (nums[index + 1] <= updateValue) {
                            isPeak[index + 1] = false;
                        }
                    }



                    // Update nums
                    nums[index] = updateValue;
                }
            }
            
        }
        
        
        System.out.println(queryResults);
        return queryResults;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();





    }
}