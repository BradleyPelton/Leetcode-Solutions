package contests.contests2021.lc0904.mediumone;

import java.util.*;

class Solution {
    public int numberOfWeakCharacters(int[][] properties) {

        TreeMap<Integer, ArrayList<Integer>> attackMap = new TreeMap<>();

        for(int[] character : properties) {
            if (attackMap.containsKey(character[0])) {
                attackMap.get(character[0]).add(character[1]);
            } else {
                attackMap.put(character[0], new ArrayList<>(){{this.add(character[1]);}});
            }
        }

        for (ArrayList<Integer> val : attackMap.values()) {
            Collections.sort(val);
        }

        int ans = 0;


//        1 ->  2,3
//        2 -> 1,5
        for (Integer i : attackMap.keySet()) {
            ArrayList<Integer> iVals = attackMap.get(i);
            SortedMap<Integer, ArrayList<Integer>> tailMap = attackMap.tailMap(i, false);
            iValloop:
            for (Integer iVal : iVals) {
                for (Integer j : tailMap.keySet()) {
                    ArrayList<Integer> tailArr = tailMap.get(j);
                    for (Integer tailVal : tailArr) {
                            if (iVal < tailVal) {
                                ans++;
                                continue iValloop;
                            }
                    }
                }
            }
        }

        System.out.println("final ans " + ans);
        return ans;
    }
}


class Tests{
    public static void main(String[] args) {
        Solution sol = new Solution();


        sol.numberOfWeakCharacters(new int[][]{{5,5},{6,3},{3,6}});
        sol.numberOfWeakCharacters(new int[][]{{2,2},{3,3}});
        sol.numberOfWeakCharacters(new int[][]{{1,5},{10,4},{4,3}});
        sol.numberOfWeakCharacters(new int[][]{{1,1},{2,1},{2,2},{1,2}}); // expected 1
        sol.numberOfWeakCharacters(new int[][]{{7,7},{1,2},{9,7},{7,3},{3,10},{9,8},{8,10},{4,3},{1,5},{1,5}}); // expected 6

    }
}