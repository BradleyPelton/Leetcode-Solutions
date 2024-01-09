package contests.contests2023.lc0513.easy;

import java.util.ArrayList;
import java.util.List;

// Accepted after 10 minutes
// Long word problem

// Struggled with ArrayList<Integer> -> int[] cast, again.

class Solution {
    public int[] circularGameLosers(int n, int k) {

        int[] seen = new int[n];
        int currPos = 0;
        for (int i = 0; i <= n+1; i++) {
            currPos = (currPos + (i * k)) % n;
            if (seen[currPos] == 1) {
                break;
            } else {
                seen[currPos] = 1;
            }
        }


        List<Integer> seenList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (seen[i] != 1) {
                seenList.add(i);
            }
        }
        int[] ans = new int[seenList.size()];
        for (int i = 0; i < seenList.size(); i++) {
            ans[i] = seenList.get(i) + 1;
        }
        return ans;

    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.circularGameLosers(5,2);
        sol.circularGameLosers(4,4);
    }
}
