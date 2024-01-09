package contests2020q4.leetcode20201003a.attempt1MediumProblem;

import java.util.ArrayList;

// Almost had it. First attempt submited with 2 minutes left to go
// Ran out of time
// I successfully implemented BFS in java, which is very nice!
// Excellent progress to be able to implement something like this on my first try
// I slipped up at the end once I had all of the levels stored in an ArrayList though

class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        ArrayList<int[]> allLevelsArr = new ArrayList<int[]>();

        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();


        int[] rootVal = {root.val};
        allLevelsArr.add(rootVal);

        queue.add(root);
        while(!queue.isEmpty()) {
            ArrayList<TreeNode> nextLevel = new ArrayList<TreeNode>();

            for (TreeNode node : queue) {
                if (node.left != null) nextLevel.add(node.left);
                if (node.right != null) nextLevel.add(node.right);
            }

            // we have all of our nodes in nextLevel
            int[] vals = new int[nextLevel.size()];
            for(int i=0; i<nextLevel.size(); i++){
                int v = nextLevel.get(i).val;
                vals[i] = v;
            }
//            System.out.println(Arrays.toString(vals));
            allLevelsArr.add(vals);

            queue = nextLevel;
        }
//        for(int[] larr:allLevelsArr){
//            System.out.println(Arrays.toString(larr));
//        }

//        int[] finalArr = allLevelsArr.toArray();

        for(int j=0; j<allLevelsArr.size();j++) {
            int[] tempArr = allLevelsArr.get(j);
            for(int k=0; k<tempArr.length; k++){
                if(k!=0 && tempArr[k-1] > tempArr[k]){return false;}
                if( tempArr[k]%2 != j%2){return false;}
            }
        }

        return true;
    }

}