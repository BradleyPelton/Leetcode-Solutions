package contests.contests2023.lc0520.mediumone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Accepted after 30 minutes
// Accepted first attempt

// Had to google algorithm for partitioning a string.

class Solution {
    public int punishmentNumber(int n) {

        int punishmentSum = 0;
        for (int i = 0; i < n + 1; i++) {
            if (canPartition(i)) {
                punishmentSum += i * i;
            }
        }

        System.out.println("final ans " + punishmentSum);
        return punishmentSum;
    }

    private boolean canPartition(int e) {
        final String stringOfSquare = String.valueOf(e * e);
        List<String> partitions = allPartitions(stringOfSquare);

        for (final String partition : partitions) {
//            String[] integerValues = partition.split(",");
//            int partitionSum = 0;
            int partitionSum = Arrays.stream(partition.split(","))
                    .filter(s -> s.length() != 0)
                    .mapToInt(Integer::parseInt)
                    .sum();
//            for (String splitString : integerValues) {
//                if (splitString.length() > 0) {
//                    partitionSum += Integer.parseInt(splitString);
//                }
//            }

            if (partitionSum == e) {
                return true;
            }
        }
        return false;
    }

    private List<String> allPartitions(String s) {
        return findAllCombos(new ArrayList<>(), s, 0, "");
    }

    static List<String> findAllCombos(List<String> combos, String str, int index, String out) {
        // Common algorithm to find partitions
        if (index == str.length()) {
            combos.add(out);
        }

        for (int i = index; i < str.length(); i++) {
            findAllCombos(combos, str, i + 1, out + "," + str.substring(index, i + 1));
        }
        return combos;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.punishmentNumber(10);
        sol.punishmentNumber(37);

    }
}
