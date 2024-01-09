package contests2020q4.leetcode20201205.leetcode20201205easy;

// Accepted after 8 minutes
// Accepted first try


// Sloppy solution... I know there are a million ways to do this cleaner, but this was the fastest to type


class Solution {
    public String interpret(String command) {
        String ans = "";

        for (int i=0; i<command.length(); i++){
            char currChar = command.charAt(i);
            if (currChar == 'G'){
                ans += "G";
            } else if (currChar == '('){
                char nextChar = command.charAt(i+1);
                if (nextChar == ')'){
                    ans += "o";
                } else {
                    ans += "al";
                }
            }
        }

//    System.out.println(ans);

    return ans;

    }
}

class Tests {
  public static void main(String[] args) {
    //

      String firstString = "G()(al)";
      String secondString = "G()()()()(al)";
      String thirdString = "(al)G(al)()()G";

      Solution sol = new Solution();
      sol.interpret(firstString);
      sol.interpret(secondString);
      sol.interpret(thirdString);
  }
}