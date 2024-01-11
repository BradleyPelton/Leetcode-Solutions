package util;

import java.util.HashSet;
import java.util.Set;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode createLinkedList(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        ListNode headOfNewList = new ListNode(arr[0]);
        ListNode originalHead = headOfNewList;
        for (int i = 1; i < arr.length; i++) {
            ListNode nextNode = new ListNode(arr[i]);
            headOfNewList.next = nextNode;
            headOfNewList = headOfNewList.next;
        }
        return originalHead;
    }

    public static void printLinkedList(ListNode head) {
        if (head == null) {
            System.out.println("null");
        }
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public String serialize() {
        Set<Integer> valsSeen = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        ListNode head = this;
        while (head != null) {
            sb.append(head.val).append("->");
            if (valsSeen.add(head.val)) {
                head = head.next;
            } else {
                sb.append("{{{CYCLE_DETECTED}}}");
                return sb.toString();
            }
        }
        sb.append("null");
        return sb.toString();
    }

    public String toString() {
        return serialize();
    }
}