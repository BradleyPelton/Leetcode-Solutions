package contests2020q4.leetcode20201010.leetcode20201010Easy;

import java.util.ArrayList;


// Accepted after first try
// Accepted after 19 minutes
// SLoppy that it took me 19 minutes to do such an contests2020q4.leetcode20201226biweekly.easy problem. I wonder if there is a better datatype to
// pop and push an Stacklist this. Maybe there is something similar to Queue?
// TODO- LOOK INTO DATATYPE TO USE FOR STACK POP/PUSH


class Solution {
    public int maxDepth(String s) {
        ArrayList<String> parenStack = new ArrayList<String>();
        int maxDepthVal = 0;
        int currentDepth = 0;

        for (int i = 0; i < s.length(); i++) {
            int lastIndex = parenStack.size()-1;

            if (s.charAt(i) == '(') {
                currentDepth += 1;
                parenStack.add("(");
            } else if (s.charAt(i) == ')') {
                if(parenStack.size() ==0 || parenStack.get(lastIndex) != "("){
                    System.out.println("INVALID VPS, RETRUNING -1");
                    return -1;
                } else{
                    currentDepth -= 1;
                    parenStack.remove(lastIndex);
//                    System.out.println(Arrays.toString(parenStack.toArray()));

                }
            }

            if (currentDepth > maxDepthVal) maxDepthVal=currentDepth;
        }
//        System.out.println(Arrays.toString(parenStack.toArray()));
        System.out.println(maxDepthVal);



        return maxDepthVal;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String firstString = "(1+(2*3)+((8)/4))+1";
        String secondString = "(1)+((2))+(((3)))";
        String thirdString = "1+(2*3)/(2-1)";
        String fourthString = "1";

        sol.maxDepth(firstString);
        sol.maxDepth(secondString);
        sol.maxDepth(thirdString);
        sol.maxDepth(fourthString);


    }
}
