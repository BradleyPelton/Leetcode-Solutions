package _Study.deleteme;


import util.ListNode;
import util.TreeNode;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;


class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i] = new int[]{profits[i], capital[i]};
        }
        Arrays.sort(projects, Comparator.comparingInt(a -> a[1])); // sort by capital requirement
        PriorityQueue<int[]> projectQueue = new PriorityQueue<>(Comparator.comparingInt(a -> -a[0]));

        int currCapital = w;
        int nextIndex = 0;
        for (int i = 0; i < n; i++) {
            if (projects[i][1] <= currCapital) {
                nextIndex = i + 1;
//                if (projects[i][0] - projects[i][1] > 0) {
                    projectQueue.add(projects[i]);
//                }
                // else  skip this worthless project
            } else {
                break;
            }
        }


        int projectsCompleted = 0;
        while (projectsCompleted < k && !projectQueue.isEmpty()) {
            projectsCompleted++;
            int[] nextProject = projectQueue.remove();
            currCapital += nextProject[0];

            for (int i = nextIndex; i < n; i++) {
                if (projects[i][1] <= currCapital) {
                    nextIndex = i + 1;
//                    if (projects[i][0] - projects[i][1] > 0) {
                        projectQueue.add(projects[i]);
//                    }
                    // else  skip this worthless project
                } else {
                    break;
                }
            }
        }
        System.out.println(currCapital);
        return currCapital;

    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.findMaximizedCapital(
//                2,
//                0,
//                new int[]{1,2,3},
//                new int[]{0,1,1}
//        );
//        sol.findMaximizedCapital(
//                3,
//                0,
//                new int[]{1,2,3},
//                new int[]{0,1,2}
//        );
        sol.findMaximizedCapital(
                11,
                11,
                new int[]{1,2,3},
                new int[]{11,12,13}
        );
    }
}