package contests.contests2024.lc0113.hardone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {

        List<Integer> aIndices = new ArrayList<>();
        List<Integer> bIndices = new ArrayList<>();

        OUTER_LOOP:
        for (int i = 0; i <= s.length() - a.length(); i++) {
            if (s.charAt(i) == a.charAt(0)) {
                for (int j = 0; j < a.length(); j++) {
                    if (s.charAt(i + j) != a.charAt(j)) {
                        continue OUTER_LOOP;
                    }
                }
                aIndices.add(i);
                i = i + a.length();
            }
        }

        OUTER_LOOP:
        for (int i = 0; i <= s.length() - b.length(); i++) {
            if (s.charAt(i) == b.charAt(0)) {
                for (int j = 0; j < b.length(); j++) {
                    if (s.charAt(i + j) != b.charAt(j)) {
                        continue OUTER_LOOP;
                    }
                }
                bIndices.add(i);
                i = i + b.length();
            }
        }

        List<Integer> ans = new ArrayList<>();
        if (aIndices.isEmpty() || bIndices.isEmpty()) {
            return ans;
        }
        OUTER_LOOP:
        for (int aIndex : aIndices) {
            if (aIndex > bIndices.get(bIndices.size() - 1) + k + 2) { // a is larger than and b
                break OUTER_LOOP;
            }

            if (aIndex + k + 2 < bIndices.get(0)) { // a is smaller than the smallest b
                continue OUTER_LOOP;
            }

            int firstIndex = Collections.binarySearch(bIndices, aIndex - k);
            if (firstIndex < 0) {
                firstIndex = -firstIndex - 1;
            }
            firstIndex--;
            firstIndex = Math.max(firstIndex, 0);
            for(int i = firstIndex; i < bIndices.size(); i++) {
                int bIndex = bIndices.get(i);
                if (Math.abs(aIndex - bIndex) <= k) {
                    ans.add(aIndex);
                    continue OUTER_LOOP;
                }
                if (bIndex > aIndex + k + 2) {
                    continue OUTER_LOOP;
                }
            }
        }

//        System.out.println(ans);
        return ans;
    }
}






class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.beautifulIndices(
                "isawsquirrelnearmysquirrelhouseohmy",
                "my",
                "squirrel",
                15
        );
        sol.beautifulIndices(
                "abcd",
                "a",
                "a",
                4
        );
        sol.beautifulIndices(
                "onwawarwa",
                "wa",
                "r",
                2
        ); // [4,7]
        sol.beautifulIndices(
                "lgioimioim",
                "imsfs",
                "ioim",
                10
        );
        sol.beautifulIndices(
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "a",
                "a",
                1
        );

        sol.beautifulIndices(
                "vatevavakz",
                "va",
                "lbda",
                1
        );


    }
}
