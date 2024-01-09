package contests.contests2023.lc1202.easy;

import java.util.ArrayList;
import java.util.List;

// Accepted after 2 mintues
// trivial

class Solution {
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < mountain.length - 1; i++) {
            if (mountain[i - 1] < mountain[i]
                && (mountain[i + 1] < mountain[i])) {
                ans.add(i);
            }
        }
        //System.out.println(ans);
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findPeaks(new int[]{2,4,4});
        sol.findPeaks(new int[]{1,4,3,8,5});




    }
}
