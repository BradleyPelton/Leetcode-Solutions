package contests.contests2023.lc1118.mediumone;

class Solution {
    public long minimumSteps(String s) {

        StringBuilder sb = new StringBuilder(s);


        long numOfOperations = 0;
        int right = s.length() - 1;
        while (right != -1) {
            if (sb.charAt(right) == '1') {
                right--;
            }
            // now right points to the first zero

            for (int left = right - 1; left >= 0 ; left--) {
                if (sb.charAt(left) == '1') {
                    // Now left points to the first '1' to the left of the first zero
                    // we want to swap left and right
                    numOfOperations += right - left;
                    sb.replace(left - 1, right, sb.substring(left, right));
                    sb.setCharAt(right, '1');
                    break;
                }
            }
        }
        System.out.println(numOfOperations);
        return numOfOperations;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.minimumSteps("101");
//        sol.minimumSteps("100");
//        sol.minimumSteps("0111");
        sol.minimumSteps("1100");
    }
}
