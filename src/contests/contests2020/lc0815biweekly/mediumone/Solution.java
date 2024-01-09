package contests.contests2020.lc0815biweekly.mediumone;

import util.ListNode;

// Accepted after 8 minutes
// Accepted first try
// Somehow I figured out the linkedList problem faster than the mod easy problem.

class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {

        final ListNode originalHead = head;

        while (head != null && head.next != null) {
            int currVal = head.val;
            int nextVal = head.next.val;
            int gcdVal = getGCD(currVal, nextVal);
            ListNode gcdNode = new ListNode();
            gcdNode.val = gcdVal;
            gcdNode.next = head.next;

            head.next = gcdNode;

            // move forward two
            head = head.next;
            head = head.next;
        }
        return originalHead;
    }

    public int getGCD(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.getGCD(18,6));
        System.out.println(sol.getGCD(6,10));
    }
}