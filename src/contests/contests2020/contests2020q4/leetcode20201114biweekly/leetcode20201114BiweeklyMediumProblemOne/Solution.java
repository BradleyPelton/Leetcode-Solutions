package contests2020q4.leetcode20201114biweekly.leetcode20201114BiweeklyMediumProblemOne;

class Solution {
    public int minimumDeletions(String s) {
        int numberOfADeletions = 0;
        int numberOfBDeletions = 0;
        StringBuilder sBuildA = new StringBuilder(s);
        StringBuilder sBuildB = new StringBuilder(s);
//        System.out.println(sBuildA);
//        System.out.println(sBuildB);

        if(isBalanced(sBuildA)){
            return 0;
        }




        // DELETING A's
        while(!isBalanced(sBuildA)){
            numberOfADeletions += 1;
            for(int j=sBuildA.length()-1; j>0; j--) {
                if(sBuildA.charAt(j)=='a'){
                    sBuildA.deleteCharAt(j);
//                    System.out.println("A deleting index " + j );
//                    System.out.println(sBuildA);
                    break;
                }
            }
//            System.out.println(numberOfADeletions);
            if(numberOfADeletions == s.length()){
                System.out.println("A deletions exceeded s.length");
                break;
            }
        }

        // DELETING B's
        while(!isBalanced(sBuildB)){
            numberOfBDeletions += 1;
            for(int j=0; j<sBuildB.length(); j++) {
                if(sBuildB.charAt(j)=='b'){
                    sBuildB.deleteCharAt(j);
//                    System.out.println("B deleting index " + j );
//                    System.out.println(sBuildB);
                    break;
                }
            }
//            System.out.println(numberOfBDeletions);
            if(numberOfBDeletions == s.length()){
                System.out.println("A deletions exceeded s.length");
                break;
            }
        }

        System.out.println("The A deletions is " + numberOfADeletions);
        System.out.println("The B deletions is " + numberOfBDeletions);

        int ans = Math.min(numberOfADeletions, numberOfBDeletions);
        System.out.println("final answer is " + ans);

        return ans;
    }

    public boolean isBalanced(StringBuilder inputString){
        // a string is balanced if
        int lastAOcc = inputString.lastIndexOf("a");
        int firstBOcc = inputString.indexOf("b");
        if(lastAOcc > firstBOcc){
            return false;
        }
        return true;

    }
}

class Tests{
    public static void main(String[] args) {
        String firstString = "aababbab";
        String secondString = "bbaaaaabb";


        Solution sol = new Solution();
//        System.out.println(sol.isBalanced(firstString));
        sol.minimumDeletions(firstString);
        sol.minimumDeletions(secondString);
    }
}


