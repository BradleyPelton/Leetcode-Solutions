package contests.contests2023.lc0527.mediumtwo;

class Solution {
    public long minimumCost(String s) {


        int allZeroCost = 0;
        int allOneCost = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                allOneCost += 1 + i;
            } else { // else '1'
                allZeroCost += 1 + i;
            }
        }

        int ans = Math.min(allZeroCost, allOneCost);
        System.out.println("ans = " + ans);
        return ans;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minimumCost("0011");
        sol.minimumCost("010101");
    }
}