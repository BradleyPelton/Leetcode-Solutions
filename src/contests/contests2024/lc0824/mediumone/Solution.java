package contests.contests2024.lc0824.mediumone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Two wrong answers.
// Really frustrating problem. Not learning.

class Solution {
    public int countPairs(int[] nums) {
        int n = nums.length;

//        Map<Integer, List<Integer>> digitIndexMap = new HashMap<>();
//        for (int i = 0; i < 10; i++) {
//            digitIndexMap.put(i, new ArrayList<>());
//        }
//
//        for (int i = 0; i < n; i++) {
//            int num = nums[i];
//            if (num == 0) {
//                digitIndexMap.get(0).add(i);
//            }
//
//            String numAsString = String.valueOf(num);
//            for (char c : numAsString.toCharArray()) {
//                digitIndexMap.get(Integer.valueOf(String.valueOf(c))).add(i);
//            }
//        }


        int ans = 0;
        for (int i = 0; i < n; i++) {
            int originalNum = nums[i];

            for (int j = i + 1; j < n; j++) {
                if (isAlmostEqual(originalNum, nums[j])) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
        return ans;
    }

    private boolean isAlmostEqual(int valOne, int valTwo) {
        if (valOne == valTwo) {
            return true;
        }
        String valOneAsString = String.valueOf(valOne);
        String valTwoAsString = String.valueOf(valTwo);

        if (Math.abs(valOneAsString.length() - valTwoAsString.length()) > 1) {
            return false;
        }

        if (valOneAsString.length() > valTwoAsString.length()) {
            valTwoAsString = "0" + valTwoAsString;
        } else if (valOneAsString.length() < valTwoAsString.length()) {
            valOneAsString = "0" + valOneAsString;
        }

        List<Integer> indicesDifferent = new ArrayList<>();
        for (int i = 0; i < valOneAsString.length(); i++) {
            if (valOneAsString.charAt(i) != valTwoAsString.charAt(i)) {
                indicesDifferent.add(i);
            }
        }

        if (indicesDifferent.isEmpty()) {
            return true;
        } else if (indicesDifferent.size() == 2) {
            int firstDiffIndex = indicesDifferent.get(0);
            int secondDiffIndex = indicesDifferent.get(1);


            // Swap values in valOne
            StringBuilder valOneBuilder = new StringBuilder(valOneAsString);
            char originalFirst = valOneAsString.charAt(firstDiffIndex);
            char originalSecond = valOneAsString.charAt(secondDiffIndex);
            valOneBuilder.setCharAt(secondDiffIndex, originalFirst);
            valOneBuilder.setCharAt(firstDiffIndex, originalSecond);

            int valOneAltered = Integer.parseInt(valOneBuilder.toString());
            if (valOneAltered == valTwo) {
                return true;
            }
            if (valOneBuilder.toString().equals(valTwoAsString)) {
                return true;
            }

//            StringBuilder valTwoBuilder = new StringBuilder(valTwoAsString);
//            char originalFirstValTwo = valTwoAsString.charAt(firstDiffIndex);
//            char originalSecondValTwo = valTwoAsString.charAt(secondDiffIndex);
//            valTwoBuilder.setCharAt(secondDiffIndex, originalFirstValTwo);
//            valTwoBuilder.setCharAt(firstDiffIndex, originalSecondValTwo);
//
//            int valTwoAltered = Integer.parseInt(valTwoBuilder.toString());
//            if (valTwoAltered == valOne) {
//                return true;
//            }
//            if (valTwoBuilder.toString().equals(valOneAsString)) {
//                return true;
//            }

            return false;

        } else {
            return false;
        }
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.countPairs(
//                new int[]{3,12,30,17,21}
//        );
//        sol.countPairs(
//                new int[]{1,1,1,1,1}
//        );
//        sol.countPairs(
//                new int[]{123,231}
//        );
//        sol.countPairs(
//                new int[]{11,8,10,5,14,8}
//        ); // 1
        sol.countPairs(
                new int[]{886595,767627,6691,593887,857750,919155,830918,593887,593788,593788,660078,598873,310196,668007,597883,983587,897853,668700,435383,953887,631608,897853,953887,240754,593887,597883,455127,627877,643862,660087,893587,129173,228736,627877,775850,875750,50701,830255,751,729113,684778,114586,154186,593887,668700,238726}
        ); // 59







    }
}