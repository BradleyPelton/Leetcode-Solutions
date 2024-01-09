package contests.contests2023.lc0624biweekly.mediumone;


// Accepted after 20 minutes
// Accepted first try

// Pretty easy medium question
// Leetcode is having CloudFare issues though

class Solution {
    public int longestString(int x, int y, int z) {

        StringBuilder goodString = new StringBuilder();
        if (x > y) {
            // more "AA" than "BB"
            for (int i = 0; i < y; i++) {
                goodString.append("AA");
                goodString.append("BB");
            }
            x -= y;
            y = 0;

            for (int i = 0; i < z; i++) {
                goodString.append("AB");
            }
            z = 0;

            goodString.append("AA");
            x--;
        } else if (x < y) { // else x <= y
            // else more "BB" than "AA"
            for (int i = 0; i < x; i++) {
                goodString.append("BB");
                goodString.append("AA");
            }
            y -= x;
            x = 0;
            goodString.append("BB");
            y--;
            for (int i = 0; i < z; i++) {
                goodString.append("AB");
            }
            z = 0;

        } else {
            // else x = y
            for (int i = 0; i < y; i++) {
                goodString.append("AA");
                goodString.append("BB");
            }
            x = 0;
            y = 0;
            for (int i = 0; i < z; i++) {
                goodString.append("AB");
            }
             z = 0;
        }


        if (x < 0 || y < 0 || z < 0) {
            throw new IllegalStateException("Overincremented");
        }
        int ans = goodString.length();
        System.out.println("ans = " + ans);
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.longestString(2, 5, 1);
        sol.longestString(3, 2, 2);
    }
}
