package leetcode20201212easy;

// Accepted after 7 minutes
// Accepted first try at 9:37pm EST

// I misread the problem statement and coded the wrong solution. Wasted 3 minutes going back and fixing

class Solution {
    public int numberOfMatches(int n) {

        int numOfMatches = 0;
        int currVal = n;

        if (currVal == 1){
            return 0;
        }


        for (int i = 0; i<10000; i++){
            if (currVal % 2 == 0){
                numOfMatches += currVal/2;
                currVal /= 2;
            } else {
                currVal -= 1;
                numOfMatches += currVal/2;
                currVal /= 2;
                currVal += 1;
            }

            if (currVal == 1){
                break;
            }
        }

//    System.out.println("final ans is  " + numOfMatches);
        return numOfMatches;
    }
}

class tests{
  public static void main(String[] args) {

      Solution sol = new Solution();
      sol.numberOfMatches(7);
      sol.numberOfMatches(14);
    //
  }
}