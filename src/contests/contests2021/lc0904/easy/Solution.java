package contests.contests2021.lc0904.easy;

import java.util.HashSet;
import java.util.Set;

// Spring is rotting my brain
// Accepted after 17 minutes

// I forgot to add i < j < k < l validation
// And i thought the bug was in the uniqueness

class Solution {
    public int countQuadruplets(int[] nums) {

        int count = 0;

        Set<int[]> uniquePairs = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    for (int l = j + 1; l < nums.length; l++) {

                        if (nums[i] + nums[j] + nums[k] == nums[l]
                                && i < j
                                && j < k
                                && k < l
                        ) {
                            count++;

////                            System.out.println(nums[i]);
////                            System.out.println(nums[j]);
////                            System.out.println(nums[k]);
////                            System.out.println(nums[l]);
//                            int[] ansArr = new int[]{i,j,k,l};
//                            Arrays.sort(ansArr);
//
//                            if (uniquePairs.size() == 0) {
//                                uniquePairs.add(ansArr);
//                                count++;
//                            } else {
//                                for (int[] pair : uniquePairs) {
//                                    if (!ansArr.equals(ansArr)) {
//                                        uniquePairs.add(pair);
//                                        count++;
//                                    }
//                                }
//                            }
//                        }
//                    }

                        }
                    }
                }
            }
        }


        System.out.println("final ans is " + count);
        return count;
    }
}
class Tests{
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.countQuadruplets(new int[]{1,2,3,6});
        sol.countQuadruplets(new int[]{3,3,6,4,5});
        sol.countQuadruplets(new int[]{1,1,1,3,5});
        sol.countQuadruplets(new int[]{28,8,49,85,37,90,20,8});
    }
}
