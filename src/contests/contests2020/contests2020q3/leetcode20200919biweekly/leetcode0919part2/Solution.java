package contests.contests2020.contests2020q3.leetcode20200919biweekly.leetcode0919part2;



// I ran out of time even though I knew how to find the solution.
// It is frustrating how hard Java makes it to sort and reverse Arrays. Maybe I'm just misunderstanding
// I can do both at the same time in Python in 15 key strokes.
// It's just a matter of learning these things. I hate having to work with ArrayLists and then switching back to Arrays
// But it's the price you pay for performances I guess.

import java.util.*;

class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {

        // CREATE AN ARRAY OF ALL OCCURENCES
        ArrayList<Integer> indexOccurences = new ArrayList<Integer>();
        for(int[] e: requests){
            for (int i=e[0]; i<=e[1]; i++){
//                System.out.println(i);
                indexOccurences.add(i);
            }
        }
//        System.out.println(indexOccurences);


        // Create a list of UNIQUE INDEX OCCURENCES
        Set<Integer> uniqueOccurences = new LinkedHashSet<>(indexOccurences);
//        System.out.println(uniqueOccurences);

        // CREATE A LIST OF {index, occurenceOfIndex}
        ArrayList<int[]> frequencyArrayList = new ArrayList<int[]>();
        for(int c: uniqueOccurences){
            int cOccurences = Collections.frequency(indexOccurences, c);
            int[] tempArr = {c, cOccurences};
            frequencyArrayList.add(tempArr);
//            System.out.println(Arrays.toString(tempArr));
        }

//        int[] tempPrintArr = frequencyArrayList.toArray();
//        System.out.println(Arrays.toString(frequencyArrayList.toArray()));

        int[] numsCopy = nums.clone();
        System.out.println("numsCopy before sort" + Arrays.toString(numsCopy));
        List<int[]> temppp = Arrays.asList(numsCopy);
//        List<> sortedArr = Collections.reverse(temppp);
//        Arrays.sort(sortedArr);
        System.out.println("numsCopy after sort" + Arrays.toString(numsCopy));



        return 5;

    }

    public Solution(){}

    public static void main(String[] args) {
        Solution sol = new Solution();
//        nums = [1,2,3,4,5], requests = [[1,3],[0,1]]
        int[] firstNums = {1,2,3,4,5};
        int[][] firstRequests = {{1,3},{0,1}};

        System.out.println(sol.maxSumRangeQuery(firstNums, firstRequests));


    }

}
