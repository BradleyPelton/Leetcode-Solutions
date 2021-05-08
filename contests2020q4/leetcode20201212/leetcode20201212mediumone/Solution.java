package contests2020q4.leetcode20201212.leetcode20201212mediumone;

// Accepted after first attempt
// Accepted after 10 minutes

// Brain teaser with a simple answer

class Solution {
    public int minPartitions(String n) {

        if (n.contains("9")){
            return 9;
        } else if (n.contains("8")){
            return 8;
        } else if (n.contains("7")){
            return 7;
        } else if (n.contains("6")){
            return 6;
        } else if (n.contains("5")){
            return 5;
        } else if (n.contains("4")){
            return 4;
        } else if (n.contains("3")){
            return 3;
        } else if (n.contains("2")){
            return 2;
        } else if (n.contains("1")){
            return 1;
        } else if (n.contains("0")){
            return 0;
        }

        return 134325;
    }
}

class Tests {
  public static void main(String[] args) {
      Solution sol = new Solution();
      System.out.println(sol.minPartitions("32"));
      System.out.println(sol.minPartitions("82734"));
      System.out.println(sol.minPartitions("27346209830709182346"));
  }
}