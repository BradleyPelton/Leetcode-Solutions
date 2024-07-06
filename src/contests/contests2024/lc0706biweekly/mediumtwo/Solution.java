package contests.contests2024.lc0706biweekly.mediumtwo;

// Accepted third attempt
// Two wrong answers. Index hell. Frustrating circular array.
// Sloppy index handling. Overshooting.

class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {

        int n = colors.length;
        int ans = 0;

        OUTER_LOOP:
        for(int left = 0; left < n; left++) {
            int prevColor = colors[left % n];
            for (int diff = 1; diff < k; diff++) {
                int currColor = colors[(left + diff) % n];
                if (currColor == prevColor) {
                    // jump
                    left = left + diff - 1;
                    continue OUTER_LOOP;
                }
                prevColor = currColor;
            }

            ans++;


            // WE NOW HAVE A ALTERNATING SUBARRAY
            while (left < n - 1) {
                int currFirstColor = colors[(left % n)];
                int currLastColor = colors[(left + k - 1) % n];
                int nextColor = colors[(left + k) % n]; // element after the end of subarray

                if (nextColor != currLastColor) {
                    // the next subarray is also good
                    ans++;
                    left++;
                } else {
                    break;
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
        sol.numberOfAlternatingGroups(
                new int[]{0,1,0,1,0},
                3
        ); // 3
        sol.numberOfAlternatingGroups(
                new int[]{0,1,0,0,1,0,1},
                6
        ); // 2
        sol.numberOfAlternatingGroups(
                new int[]{1,1,0,1},
                4
        ); // 0
        sol.numberOfAlternatingGroups(
                new int[]{0,1,0,1},
                3
        ); // 4






    }
}
