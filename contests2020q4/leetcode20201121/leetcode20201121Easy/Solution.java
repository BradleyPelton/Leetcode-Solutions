package contests2020q4.leetcode20201121.leetcode20201121Easy;

// Acepted after 4 minutes
// Accepted after first try

// This might be the easiest problem I've ever seen. Could have used Strinbbuilder for less space complexity

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        String word1String = "";
        String word2String = "";


        for(String s: word1){
            word1String += s;
        }

        for (String j: word2){
            word2String += j;
        }

        if(word1String.equals(word2String)){
            return true;
        }
        return false;
    }
}

class Tests{
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.arrayStringsAreEqual(new String[] {"ab", "c"}, new String[] {"a","bc"}));
        System.out.println(sol.arrayStringsAreEqual(new String[] {"a", "cb"}, new String[] {"ab","c"}));
    }
}