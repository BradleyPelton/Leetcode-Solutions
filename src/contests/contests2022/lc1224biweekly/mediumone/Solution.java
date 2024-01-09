package contests.contests2022.lc1224biweekly.mediumone;

import java.util.*;

class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Arrays.sort(positive_feedback);
        Arrays.sort(negative_feedback);

        int[][] studentScores = new int[student_id.length][2];
        for (int i = 0; i < student_id.length; i++) {
            studentScores[i] = new int[]{student_id[i], 0};
        }

        for (int i = 0; i < report.length; i++) {
            String currentReport = report[i];
            String[] currentReportWords = currentReport.split(" ");
            for (String word : currentReportWords) {
                if (Arrays.binarySearch(positive_feedback, word) >= 0) {
                    studentScores[i][1] += 3;
                } else if (Arrays.binarySearch(negative_feedback, word) >= 0) {
                    studentScores[i][1] -= 1;
                }
            }
        }

        Arrays.sort(studentScores, (int[] a, int[] b) -> {
                    if (Integer.compare(a[1], b[1]) != 0) {
                        return -Integer.compare(a[1], b[1]);
                    } else {
                        return Integer.compare(a[0], b[0]);
                    }
            }
        );

        int[][] kBestStudents = Arrays.copyOfRange(studentScores, 0, k);

        List<Integer> answerList = new ArrayList<>();
        for (int[] student : kBestStudents) {
            answerList.add(student[0]);
        }
//        System.out.println("Final answer = " + answerList);
        return answerList;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.topStudents(new String[]{"smart","brilliant","studious"},
                new String[]{"not"},
                new String[]{"this student is studious","the student is smart"},
                new int[]{1,2},
                2
        );
        sol.topStudents(new String[]{"smart","brilliant","studious"},
                new String[]{"not"},
                new String[]{"this student is not studious","the student is smart"},
                new int[]{1,2},
                2
        );
    }
}