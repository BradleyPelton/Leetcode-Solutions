package contests.contests2021.lc1113.mediumone;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode currNode = head;

        int totalNumberOfNodes = 1;
        while(currNode.next != null) {
            totalNumberOfNodes++;
            currNode = currNode.next;
        }
        System.out.println("length = " + totalNumberOfNodes);

        currNode = head;

        int currGroupNumber = 1;
        int visitedNodeCount = 0;
        try {
            while (visitedNodeCount < totalNumberOfNodes) {
                int groupLength = Math.min(currGroupNumber, totalNumberOfNodes - visitedNodeCount);
                boolean isLastGroup = (visitedNodeCount + groupLength) ==  totalNumberOfNodes;
                //            System.out.println("groupLength = " + groupLength);

                if (groupLength % 2 == 0) {

                    ListNode originalNextNode;
                    if (!isLastGroup) {
                        ListNode tempNode = currNode.next;
                        for (int j = 0; j < groupLength; j++) {
                            tempNode = tempNode.next;  //step over
                        }
                        originalNextNode = tempNode;  // Keep track of what the next node after the end of the group was
                    } else {
                        originalNextNode = null;
                    }

                    ListNode reversedSubGroupHead = reverseSubGroup(currNode.next, groupLength);  // reverse subgroup
                    currNode.next = reversedSubGroupHead;
                    for (int j = 0; j < groupLength; j++) {
                        currNode = currNode.next;  //step over
                    }
                    currNode.next = originalNextNode;
                }

                // ELSE JUST SKIP OVER
                else {
                    for (int j = 0; j < groupLength; j++) {
                        currNode = currNode.next;
                    }
                }

                visitedNodeCount += groupLength;
                currGroupNumber++;
            }
        } catch(NullPointerException e) {
            System.out.println("fin");
        }

        return head;
    }

    public ListNode reverseSubGroup(ListNode node, int groupLength) {
        ListNode prev = null;
        ListNode current = node;
        ListNode next = null;
        while (current != null && groupLength > 0) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            groupLength--;
        }
        node = prev;
        return node;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nodeOne = new int[]{5,2,6,3,9,1,7,3,8,4};


        ListNode prev = new ListNode(nodeOne[0]);
        ListNode curr = null;

        ListNode head = prev;
        for (int i = 1; i < nodeOne.length; i++) {
            ListNode newNode = new ListNode(nodeOne[i]);
            prev.next = newNode;
            prev = newNode;
        }


        ListNode node = sol.reverseEvenLengthGroups(head);

        System.out.print("final ans = [");
        for (int i = 0; i < nodeOne.length; i++) {
            System.out.print(node.val + ",");
            node = node.next;
        }
    }

}