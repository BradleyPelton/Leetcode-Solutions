package contests2020q4.leetcode20201003a.leetcode20201003Easy;

import java.util.Arrays;

class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);

        int specialValue = -1;

        // a x is special if there are exactly

        for(int i=0; i<(nums.length + 2); i++) {
            System.out.println(i);
            for (int j = 0; j < nums.length; j++) {
                int numOfRemainingElements = nums.length - j - 1;
//                System.out.println("current index is " + j + ". Remaining elemnts is " + numOfRemainingElements);
                if (i == nums[j]) {
                    if (i == numOfRemainingElements) {
                        specialValue = i;
                        System.out.println("FOUND SPECIAL ELEMENT WITH VALUE " + i);
                    }
                }
            }
        }


        if(specialValue==-1) {
            System.out.println("no special value found, returning -1");
        } else{
            System.out.println("largest special value found is " + specialValue);
        }
        return specialValue;

    }
}

class Tests {
    public static void main(String[] args) {
        int[] first = {3,5};
        int[] second = {0,0};
        int[] third = {0,4,3,0,4};
        int[] fourth = {3,6,7,7,0};

        Solution sol = new Solution();

//        sol.specialArray(first);
//        sol.specialArray(first);
//        sol.specialArray(second);
        sol.specialArray(third);
//        sol.specialArray(fourth);
    }
}
