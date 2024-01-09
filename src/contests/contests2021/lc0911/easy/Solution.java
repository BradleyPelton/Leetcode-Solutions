package contests.contests2021.lc0911.easy;

// Accepted after 5 minutes, trivial

class Solution {
    public String reversePrefix(String word, char ch) {

        int firstIndex = word.indexOf(ch);

        String ans = "";
        if (firstIndex == -1) {
            System.out.println("no occ");
            return word;
        } else {
            String beforeStr = word.substring(0, firstIndex+1);
            String reversedBefore = new StringBuilder(beforeStr).reverse().toString();
            ans = reversedBefore + word.substring(firstIndex+1);
        }

//        System.out.println("final ans is = " + ans);
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.reversePrefix("abcdefd", 'd');
        sol.reversePrefix("xyxzxe", 'z');
        sol.reversePrefix("abcd", 'z');





    }
}