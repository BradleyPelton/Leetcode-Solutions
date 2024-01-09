package contests.contests2021.lc0821.mediumone;

// Accepted after 8 minutes

// Thisd is cantors famous proof for uncountability of real numbers

// Always choose a digit different from nums[i] and i
// Brilliant mathematical proof

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i].charAt(i) == '0') {
                sb.append(1);
            } else {
                sb.append(0);
            }
        }
        return sb.toString();
    }
}

class Tests {
    public static void main(String[] args) {

        Solution sol = new Solution();
        sol.findDifferentBinaryString(new String[]{"01","10"});
        sol.findDifferentBinaryString(new String[]{"00","01"});
        sol.findDifferentBinaryString(new String[]{"111","011","001"});


    }

}