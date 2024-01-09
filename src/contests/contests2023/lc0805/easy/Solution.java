package contests.contests2023.lc0805.easy;

// Accepted after 2 minutes
// trivial

class Solution {
    public String finalString(String s) {

        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == 'i') {
                sb.reverse();
            } else {
                sb.append(c);
            }
        }

        String ans = sb.toString();
        System.out.println(ans);
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol =  new Solution();
        sol.finalString("string");
        sol.finalString("poiinter");






    }
}
