package leetcode20201024MediumProblemOne;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Accepted after 39 minutes. (delta of 22 minutes after 17 minutes first easy problem)
// Accepted after first try.

// NOTES: This was a super easy Medium problem. 2700 people solved it before I did.
// NOTES: Just a matter some nested for loops. I added some edge case handling just in case, but I'm not sure
// if it was needed.


class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        ArrayList<Boolean> boolList = new ArrayList<>();

        for(int i=0; i<l.length; i++) {
            int[] subArr = Arrays.copyOfRange(nums, l[i], r[i] + 1);
//            System.out.println(Arrays.toString(subArr));
            Arrays.sort(subArr);
            if (subArr.length > 1) {
                int delta = subArr[1] - subArr[0];
                int numOfErrors = 0;
                for (int j = 1; j < subArr.length; j++) {
                    if (subArr[j] - subArr[j - 1] != delta) {
                        numOfErrors += 1;
                        break;
                    }
                }
                if (numOfErrors > 0) {
                    boolList.add(false);
                } else {
                    boolList.add(true);
                }
            } else {
                boolList.add(true);
            }
        }


        System.out.println(Arrays.toString(boolList.toArray()));
        return boolList;

    }
}


class Tests {
    public static void main(String[] args) {
        int[] firstNums = {4,6,5,9,3,7};
        int[] firstLeft = {0,0,2};
        int[] firstRight = {2,3,5};

        int[] secondNums = {-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10};
        int[] secondLeft = {0,1,6,4,8,7};
        int[] secondRight = {4,4,9,7,9,10};

        Solution sol = new Solution();
        sol.checkArithmeticSubarrays(firstNums, firstLeft, firstRight);
        sol.checkArithmeticSubarrays(secondNums, secondLeft, secondRight);
    }
}