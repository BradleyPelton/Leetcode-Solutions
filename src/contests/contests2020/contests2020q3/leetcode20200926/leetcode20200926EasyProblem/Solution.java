package leetcode20200926EasyProblem;

import java.util.ArrayList;
import java.util.Arrays;


// Accepted after first attempt after 14 minutes
// Clean execution... I was surprised how contests2020q4.leetcode20201226biweekly.easy this was. The description was long for an Easy problem
// I didnt take into account the edge case of running "cd .." when cwd = "/". They were nice enough
// to add this as an example

class Solution {
    public int minOperations(String[] logs) {

        ArrayList<String> currentDir = new ArrayList<String>();
        currentDir.add("MAIN");

        for(String e: logs){
//            System.out.println(e);
            if(e.equals("../")){
                int curSize = currentDir.size();

                if(curSize!=1){
                    currentDir.remove(curSize-1);
                }

            } else if(e.equals("./")){
                ;
            } else {
                currentDir.add(e);
            }
        }

        System.out.println(Arrays.toString(currentDir.toArray()));

        int ans = currentDir.size() - 1;
        System.out.println(ans);

        return ans;
    }
}


class TestCases {
    public static void main(String[] args) {
        String[] firstExample = {"d1/","d2/","../","d21/","./"};
        String[] secondExample = {"d1/","d2/","./","d3/","../","d31/"};
        String[] thirdExample = {"d1/","../","../","../"};

        Solution sol = new Solution();
        sol.minOperations(firstExample);
        sol.minOperations(secondExample);
        sol.minOperations(thirdExample);
    }
}