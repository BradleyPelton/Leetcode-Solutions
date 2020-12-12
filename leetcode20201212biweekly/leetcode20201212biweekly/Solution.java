package leetcode20201212biweekly;

// Accepted after first try
// ACcepted after 9 minutes

// Lost 2 minutes because I had to convert char to string. It is dumb that .contains doesnt have a String method.
// Maybe there is another method I should have been using.

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {

        int ans = 0;

        firstloop:
        for (String word : words){
            for (int i=0; i<word.length(); i++){
                if (! allowed.contains(Character.toString(word.charAt(i)))){
                    continue firstloop;


                }

            }
            ans += 1;
        }

//        System.out.println("final ans is: " + ans);

        return ans;

    }
}

class Tests {
  public static void main(String[] args) {
    Solution sol = new Solution();
    String allowedOne = "ab";
    String allowedTwo = "abc";
    String allowedThree = "cad";
   String[] wordsOne = {"ad","bd","aaab","baa","badab"};
    String[] wrodsTwo = {"a","b","c","ab","ac","bc","abc"};
    String[] wordsThree = {"cc","acd","b","ba","bac","bad","ac","d"};
      sol.countConsistentStrings(allowedOne, wordsOne);
      sol.countConsistentStrings(allowedTwo, wrodsTwo);
      sol.countConsistentStrings(allowedThree, wordsThree);
  }
}
