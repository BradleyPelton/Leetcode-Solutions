package contests.contests2024.lc0615.easy;

// Accepted after 1 minute
// Trivial

class Solution {
    public int countCompleteDayPairs(int[] hours) {

        int ans = 0;
        for (int i = 0; i < hours.length; i++) {
            for (int j = i + 1; j < hours.length; j++) {
                if ((hours[i] + hours[j]) % 24 == 0) {
                    ans++;
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
        sol.countCompleteDayPairs(
                new int[]{12,12,30,24,24}
        );
        sol.countCompleteDayPairs(
                new int[]{72,48,24,3}
        );






    }
}
