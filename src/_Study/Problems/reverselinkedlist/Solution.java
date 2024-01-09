package _Study.Problems.reverselinkedlist;

import util.ListNode;

/**
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/description/
 *
 * <p>
 *     Iterative Approach:
 *     Time Complexity: O(n) - Iterate through all n nodes
 *     Space Complexity: O(1) - We aren't creating a copy of data that is proportional to n
 * </p>
 *
 * <p>
 *     Recursive Approach: (less optimal, more space used)
 *     Time Complexity: O(n) - Traverse over every node
 *     Space Complexity: O(n) - Each recursive method call takes up space on the stack
 * </p>
 */
class Solution {
    public ListNode reverseListITERATIVE(ListNode head) {
        ListNode previousNode = null;
        ListNode currentNode = head;
        while (currentNode != null) {
            ListNode temp = currentNode.next;
            currentNode.next = previousNode;

            // Update pointers
            previousNode = currentNode;
            currentNode = temp;
        }
        return previousNode;  // important to return previousNode and not currentNode(which will always end on null)
    }

    public ListNode reverseListRECURSIVE0(ListNode head) {
        return reverseListRECURSIVE0(head, null);
    }

    private ListNode reverseListRECURSIVE0(ListNode head, ListNode prevNode) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            head.next = prevNode;
            return head;
        }
        ListNode temp = head.next;
        head.next = prevNode;
        return reverseListRECURSIVE0(temp, head);
    }

    public ListNode reverseListRECURSIVE1(ListNode head) { // canonical recursive approach
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reversedSublist = reverseListRECURSIVE1(head.next); // reverse everything to the right first. 1 -> (2 <- 3 <- 4 <- 5)
        head.next.next = head; // 1 -> (<- 2 <- 3 <- 4 <- 5)
        head.next = null; // null <- 1 (<- 2 <- 3 <- 4 <- 5)
        return reversedSublist;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode.printLinkedList(sol.reverseListRECURSIVE1(ListNode.createLinkedList(new int[]{1,2,3,4,5})));
        ListNode.printLinkedList(sol.reverseListRECURSIVE1(ListNode.createLinkedList(new int[]{1,2})));
        ListNode.printLinkedList(sol.reverseListRECURSIVE1(ListNode.createLinkedList(new int[]{1})));
        ListNode.printLinkedList(sol.reverseListRECURSIVE1(ListNode.createLinkedList(new int[]{})));
    }
}