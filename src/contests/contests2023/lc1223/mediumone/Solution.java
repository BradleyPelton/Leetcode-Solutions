package contests.contests2023.lc1223.mediumone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// Accepted after 40 minutes
// A lot of people struggled
// Fumbled with indices
// Brute force worked

// Tried two pointers, didnt work. Can't always choose the last square

class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Arrays.sort(hFences);
        Arrays.sort(vFences);

        List<Integer> hFencesList = Arrays.stream(hFences).boxed().collect(Collectors.toList());
        hFencesList.add(0, 1);
        hFencesList.add(m);

        List<Integer> vFencesList = Arrays.stream(vFences).boxed().collect(Collectors.toList());
        vFencesList.add(0, 1);
        vFencesList.add(n);

        Set<Integer> hFenceLengths = new HashSet<>();
        for (int i = 0; i < hFencesList.size(); i++) {
            for (int j = i + 1; j < hFencesList.size() ; j++) {
                int currLength = (hFencesList.get(j) - hFencesList.get(i));
                hFenceLengths.add(currLength);
            }
        }

        Set<Integer> vFenceLengths = new HashSet<>();
        for (int i = 0; i < vFencesList.size(); i++) {
            for (int j = i + 1; j < vFencesList.size() ; j++) {
                int currLength = (vFencesList.get(j) - vFencesList.get(i));
                vFenceLengths.add(currLength);
            }
        }

        List<Integer> hFenceLengthList = new ArrayList<>(hFenceLengths);
        Collections.sort(hFenceLengthList);

        final long rem = 1_000_000_007L;
        int maxArea = -1;
        for (int i = hFenceLengthList.size() - 1; i >= 0; i--) {
            int hFenceLength = hFenceLengthList.get(i);
            if (vFenceLengths.contains(hFenceLength)) {
                maxArea = (int)(((hFenceLength % rem) * (hFenceLength % rem)) % rem);
                break;
            }
        }

        System.out.println(maxArea);
        return maxArea;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maximizeSquareArea(
                4,
                3,
                new int[]{2,3},
                new int[]{2}
        ); // 4
        sol.maximizeSquareArea(
                6,
                7,
                new int[]{2},
                new int[]{4}
        ); // -1
        sol.maximizeSquareArea(
                3,
                9,
                new int[]{2},
                new int[]{8,6,5,4}
        ); // 4

    }
}
