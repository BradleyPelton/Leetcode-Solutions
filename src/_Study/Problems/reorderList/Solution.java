package _Study.Problems.reorderList;

import util.ListNode;

import java.util.ArrayDeque;


/**
 * 143. Reorder List
 * https://leetcode.com/problems/reorder-list/
 *
 * // TODO - two runner solution
 *
 */
class Solution {
    public void reorderList(ListNode head) { // Deque - 19% runtime, 33% memory

        ListNode originalHead = head;

        ArrayDeque<ListNode> nodeStack = new ArrayDeque<>();
        while (head != null) {
            nodeStack.addLast(head);
            head = head.next;
        }
        head = new ListNode(Integer.MIN_VALUE);
        boolean forwardTurn = true;
        while (!nodeStack.isEmpty()) {
            if (forwardTurn) { // forward
                ListNode popFirst = nodeStack.removeFirst();
                popFirst.next = null;
                head.next = popFirst;
            } else { // backward
                ListNode popLast = nodeStack.removeLast();
                popLast.next = null;
                head.next = popLast;
            }
            forwardTurn = !forwardTurn;
            head = head.next;
        }
        System.out.println(originalHead);
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.reorderList(ListNode.fromArray(new int[]{1,2,3,4}));
        sol.reorderList(ListNode.fromArray(new int[]{1,2,3,4,5}));
    }
}
