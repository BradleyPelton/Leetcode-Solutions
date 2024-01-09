package contests.contests2023.lc0729.mediumtwo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// accepted after 41 minutes
// Cool problem
// first attempt wrong answer. forgot to consider the contains case

class Solution {
    public String minimumString(String a, String b, String c) {

        if (a.contains(b)) {

        }

        String abc = mergeStrings(mergeStrings(a, b), c);
        String acb = mergeStrings(mergeStrings(a, c), b);
        String bac = mergeStrings(mergeStrings(b, a), c);
        String bca = mergeStrings(mergeStrings(b, c), a);
        String cab = mergeStrings(mergeStrings(c, a), b);
        String cba = mergeStrings(mergeStrings(c, b), a);

        List<String> candidates = new ArrayList<>();
        candidates.add(abc);
        candidates.add(acb);
        candidates.add(bac);
        candidates.add(bca);
        candidates.add(cab);
        candidates.add(cba);


        if (a.contains(b)) {
            if (a.contains(c)) {
                candidates.add(a);
            } else {
                String ac = mergeStrings(a, c);
                String ca = mergeStrings(c, a);
                candidates.add(ac);
                candidates.add(ca);
            }
        }
        if (a.contains(c)) {
            if (a.contains(b)) {
                candidates.add(a);
            } else {
                String ab = mergeStrings(a, b);
                String ba = mergeStrings(b, a);
                candidates.add(ab);
                candidates.add(ba);
            }
        }
        if (b.contains(a)) {
            if (b.contains(c)) {
                candidates.add(b);
            } else {
                String bc = mergeStrings(b, c);
                String cb = mergeStrings(c, b);
                candidates.add(bc);
                candidates.add(cb);
            }
        }
        if (b.contains(c)) {
            if (b.contains(a)) {
                candidates.add(b);
            } else {
                String ba = mergeStrings(b, a);
                String ab = mergeStrings(a, b);
                candidates.add(ba);
                candidates.add(ab);
            }
        }
        if (c.contains(a)) {
            if (c.contains(b)) {
                candidates.add(c);
            } else {
                String cb = mergeStrings(c, b);
                String bc = mergeStrings(b, c);
                candidates.add(cb);
                candidates.add(bc);
            }
        }
        if (c.contains(b)) {
            if (c.contains(a)) {
                candidates.add(c);
            } else {
                String ca = mergeStrings(c, a);
                String ac = mergeStrings(a, c);
                candidates.add(ca);
                candidates.add(ac);
            }
        }


        candidates.sort(Comparator.comparing(String::length).thenComparing(String::valueOf));

        String ans = candidates.get(0);
        System.out.println(ans);
        return ans;
    }

    private String mergeStrings(String one, String two) {
        // check for overlap when concat one + two
        // abc + bcd

        String maxOverlap = "";
        for (int right = 1; right < two.length() + 1; right++) {
            String currSubString = two.substring(0, right);
            if (one.endsWith(currSubString)) {
                maxOverlap = currSubString;
            }
        }
        if (maxOverlap.length() == 0) {
            return one + two;
        } else {
            String overlapString = one.substring(0, one.length() - maxOverlap.length())
                    + maxOverlap
                    + two.substring(maxOverlap.length());
            return overlapString;
        }
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minimumString(
                "abc",
                "bca",
                "aaa"
        ); //expect
        sol.minimumString(
                "ab",
                "ba",
                "aba"
        );
        sol.minimumString(
                "cab",
                "a",
                "b"
        ); // expected "cab"
    }
}