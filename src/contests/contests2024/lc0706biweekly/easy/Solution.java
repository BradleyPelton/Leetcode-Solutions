package contests.contests2024.lc0706biweekly.easy;


// Accepted after 7 minutes
// Lost 4 minutes due to cloudflare nginx 404

class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        int prevprev = colors[n - 2];
        int prev = colors[n - 1];

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int curr = colors[i];

            if (curr == prevprev && curr != prev) {
                ans++;
            }

            prevprev = prev;
            prev = curr;
        }

        System.out.println(ans);
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.numberOfAlternatingGroups(
                new int[]{1,1,1}
        );
        sol.numberOfAlternatingGroups(
                new int[]{0,1,0,0,1}
        );




    }
}
