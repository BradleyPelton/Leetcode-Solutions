package _Study.Problems.mergeKSortedLinkedLists;

import util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


/**
 * 23. Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 */
class Solution {
    public ListNode mergeKListsITERATIVE(ListNode[] lists) {
        ListNode originalHead = new ListNode();
        ListNode head = originalHead;

        Queue<int[]> listPQ = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < lists.length; i++) {
            ListNode iList = lists[i];
            if (iList == null) {
                continue;
            }
            int[] temp = new int[]{iList.val, i};
            listPQ.add(temp);
        }

        while (!listPQ.isEmpty()) {
            int[] nextArr = listPQ.poll();
            ListNode nextNode = lists[nextArr[1]];

            // Update Head
            head.next = nextNode;
            head = head.next;

            // Update truncated list
            nextNode = nextNode.next;
            lists[nextArr[1]] = nextNode;
            if (nextNode == null) {
                continue;
            } else {
                int[] temp = new int[]{nextNode.val, nextArr[1]};
                listPQ.add(temp);
            }
        }
        return originalHead.next;
    }
}