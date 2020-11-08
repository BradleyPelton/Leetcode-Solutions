package leetcode20201107Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// Accepted after 12 minutes
// Acepted after second attempt

// Dumb edge case where n=0 ...
// They literally provide the values for 0 and 1, but whatever. Misleading edge case.

class Solution {
    public int getMaximumGenerated(int n) {

        if(n==0){
            return 0;
        } else if(n==1){
            return 1;
        }

        ArrayList<Integer> intArr = new ArrayList<>();

        intArr.add(0);
        intArr.add(1);

        for(int i=2; i<n+1; i++){

            if(i%2 == 0){
                int halfI = i/2;
                int halfIVal = intArr.get(halfI);
                intArr.add(halfIVal);
            } else {
                int offSet = (i-1)/2;
                int offSetVal = intArr.get(offSet);
                int offSetPlusOneVal = intArr.get(offSet + 1);
                int newVal = offSetVal + offSetPlusOneVal;

                intArr.add(newVal);
            }

        }


//        System.out.println(Arrays.toString(intArr.toArray()));

        int ans = Collections.max(intArr);
        System.out.println("final ans is " + ans);

        return ans;
    }
}

class tests{
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.getMaximumGenerated(7);
        sol.getMaximumGenerated(2);
        sol.getMaximumGenerated(3);

    }
}