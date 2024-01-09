package contests.contests2023.lc0128.easy;

class Solution {
    public int distinctIntegers(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return n - 1;
        }
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
    }
}
