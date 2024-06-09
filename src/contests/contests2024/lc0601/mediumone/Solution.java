package contests.contests2024.lc0601.mediumone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// Accepted after 15 minutes
// Cool interval problem.
// FIrst attempt rejected wrong answer. Missed a start edge case.

class Solution {
    public int countDays(int days, int[][] meetings) {

        // Union together all of the meetings

        Arrays.sort(meetings, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt((int[] b) -> b[1]));

        List<int[]> combinedMeetings = new ArrayList<>();

        int[] previousMeeting = meetings[0];
        for (int i = 1; i < meetings.length; i++) {
            int[] currentMeeting = meetings[i];
            if (previousMeeting[1] < currentMeeting[0]) {
                combinedMeetings.add(previousMeeting);
                previousMeeting = currentMeeting;
            } else {
                previousMeeting[0] = Math.min(previousMeeting[0], currentMeeting[0]);
                previousMeeting[1] = Math.max(previousMeeting[1], currentMeeting[1]);
            }
        }
        combinedMeetings.add(previousMeeting);

        int ans = Math.max(combinedMeetings.get(0)[0] - 1, 0);
        int currDay = combinedMeetings.get(0)[1];
        for (int i = 1; i < combinedMeetings.size(); i++) {
            int[] meeting = combinedMeetings.get(i);
            int localAns = Math.max(
                    0,
                    (meeting[0] - 1) - (currDay + 1) + 1
            );
            ans += localAns;
            currDay = meeting[1];
        }

        ans += (days - currDay);
        System.out.println(ans);
        return ans;

    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.countDays(
                10,
                new int[][]{{5,7},{1,3},{9,10}}
        );
        sol.countDays(
                5,
                new int[][]{{2,4},{1,3}}
        );
        sol.countDays(
                6,
                new int[][]{{1,6}}
        );
        sol.countDays(
                8,
                new int[][]{{3,4},{4,8},{2,5},{3,8}}
        ); // 1





    }
}
