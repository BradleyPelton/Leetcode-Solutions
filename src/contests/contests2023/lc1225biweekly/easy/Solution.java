package contests.contests2023.lc1225biweekly.easy;

// accepted after 2 minutes, trivial


class Solution {
    public int mostWordsFound(String[] sentences) {

        int maxCount = 0;

        for (String sentence : sentences) {
            String[] splitArr = sentence.split(" ");
            if (maxCount < splitArr.length) {
                maxCount = splitArr.length;
            }
        }

        System.out.println("final ans = " + maxCount);
        return maxCount;

    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.mostWordsFound(new String[]{"alice and bob love leetcode", "i think so too", "this is great thanks very much"});
        sol.mostWordsFound(new String[]{"please wait", "continue to fight", "continue to win"});
    }
}
