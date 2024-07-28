import java.util.HashMap;
import java.util.Map;

/**
 * Title: Assignment 04 - COMPSCIX404.1-019
 *
 *
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 *              Resubmitted: 2024-07-10
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 *
 * Student: Bradley Pelton
 * Date: 2024-07-06
 */


//// Resubmitted: 2024-07-10
//// Misunderstanding around the wording of QuestionTwo.


public class Resubmitted_Assignment_Four_Bradley_Pelton {
    // The questions are broken up into the 4 classes below. This class does not execute anything.
    QuestionOne q1 = new QuestionOne();


    // EDIT: Only altered class during resubmission.
    QuestionTwo q2 = new QuestionTwo();


    QuestionThree q3 = new QuestionThree();
    QuestionFour q4 = new QuestionFour();
}

/////////////////////////////////////////////////
//////////////// Stub classes //////////////////
/////////////////////////////////////////////////
class SinglyLinkedListNode {
    int val;
    SinglyLinkedListNode next;
    SinglyLinkedListNode(int val) {this.val = val;}
}
class SinglyLinkedList {
    SinglyLinkedListNode head;
}
class DoublyLinkedListNode {
    int val;
    DoublyLinkedListNode next;
    DoublyLinkedListNode prev;
}
class DoublyLinkedList {
    DoublyLinkedListNode head;
    DoublyLinkedListNode tail;
}
class BinaryTreeNode {
    public int val;
    public BinaryTreeNode left;
    public BinaryTreeNode right;
}
/////////////////////////////////////////////////
/////////////////////////////////////////////////
/////////////////////////////////////////////////

class QuestionOne {
    public DoublyLinkedList reverseDoublyLinkedList(DoublyLinkedList originalList) {
        if (originalList == null || originalList.head == null || originalList.head.next == null) {
            return originalList; // if head == null, the reverse of nothing is nothing
        } //  Similarly, reverse of 1 node is just itself

        DoublyLinkedList reversedList = new DoublyLinkedList();
        reversedList.tail = originalList.head;

        DoublyLinkedListNode head = originalList.head;
        DoublyLinkedListNode previousNode = null;
        while (head != null) { // iteratively reverse the head node
            DoublyLinkedListNode cachedNextNode = head.next; // save the next value so information is not lost.

            // Reverse the (next) and (prev) pointers
            head.next = previousNode;
            head.prev = cachedNextNode;

            // Set up the next iteration
            previousNode = head;
            head = cachedNextNode;
        }

        reversedList.head = previousNode; // prev is the last non-null node. This is now the front of the list
        return reversedList;
    }
}

class QuestionTwo {
    /**
     * Union two Singly-Linked lists by "concatenating" them
     */
    public SinglyLinkedList unionTwoSinglyLinkedLists(
            SinglyLinkedList listOne,
            SinglyLinkedList listTwo) {

        // "Sentinel"/Dummy node
        SinglyLinkedListNode head = new SinglyLinkedListNode(Integer.MIN_VALUE);
        SinglyLinkedListNode ansPointer = head;

        Map<Integer, Boolean> seenValues = new HashMap<>();         // NEW LINE
        SinglyLinkedListNode headOne = listOne.head;
        while (headOne != null) {
            seenValues.put(headOne.val, true);                      // NEW LINE
            head.next = headOne;
            headOne = headOne.next;
            head = head.next;
        }

        SinglyLinkedListNode headTwo = listTwo.head;
        while (headTwo != null) {
            if (!seenValues.containsKey(headTwo.val)) {            // NEW LINE
                head.next = headTwo;
                head = head.next;
            } // No need to update seenValues with headTwo.val since headTwo values are locally unique.
            headTwo = headTwo.next;
        }

        SinglyLinkedList ansList = new SinglyLinkedList();
        ansList.head = ansPointer.next; // remove the "Sentinel"/Dummy node at the start
        return ansList;
    }
}

class QuestionThree {
    /**
     * Return the smallest element in a binary search tree
     */
    public int getMinimumValue(BinaryTreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException("getMinimumValue called with a null tree");
        } else if (root.left != null) {
            return getMinimumValue(root.left);
        } else {
            return root.val;
        }
    }

    /**
     * Return the largest element in a binary search tree
     */
    public int getMaximumValue(BinaryTreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException("getMaximumValue called with a null tree");
        } else if (root.right != null) {
            return getMinimumValue(root.right);
        } else {
            return root.val;
        }
    }

    /**
     * Return the sum
     */
    public int getSumOfAllNodes(BinaryTreeNode root) {
        return getSumOfSubTree(root); // NOTE: if root == null, the sum of zero nodes is zero.
    }

    private int getSumOfSubTree(BinaryTreeNode currentNode) {
        if (currentNode == null) {
            return 0;
        }

        // The sum of a subtree is recursively the sum of (currentNode + sum of left + sum of right)
        int ans = currentNode.val
                + getSumOfSubTree(currentNode.left)
                + getSumOfSubTree(currentNode.right);
        return ans;
    }
}

class QuestionFour {
    /**
     * Return true if the Tree is a valid binary search tree
     *
     * NOTE: Depending on how you define the binary search condition, the solution changes.
     * Definitions vary on whether duplicate values can exist, or whether they should be the left or right subtree.
     *
     * This solution insists on no duplicates.
     */
    public boolean isValidBinarySearchTree(BinaryTreeNode root) {
        // Debatable if the null tree is a valid binary search tree. "Trivially true"
        return isValidBinarySearchTree(root, Long.MIN_VALUE, Long.MAX_VALUE); // set the limits to (-inf, inf)
    }

    /**
     * Keep track of the constraints the values in subtrees must have.
     * Return true if all nodes meet the constraints.
     */
    private boolean isValidBinarySearchTree(BinaryTreeNode currentNode, long minValue, long maxValue) {
        if (currentNode == null) {
            return true;
        } else if (currentNode.val >= maxValue
                   || currentNode.val <= minValue) { // if the current node violates the condition, immediately return
            return false;
        } else {
            // narrow the constraints for the values in the subtrees
            long adjustedMaxValue = Math.min(maxValue, currentNode.val);
            long adjustedMinValue = Math.max(minValue, currentNode.val);

            boolean isLeftTreeValid = isValidBinarySearchTree(
                    currentNode.left,
                    minValue,
                    adjustedMaxValue // Limit the values in the left subtree to be less than currentNode.val
            );
            boolean isRightTreeValid = isValidBinarySearchTree(
                    currentNode.right,
                    adjustedMinValue, // Limit the values in the right subtree to be greater than currentNode.val
                    maxValue
            );
            return isLeftTreeValid && isRightTreeValid; // short circuit operator for efficiency
        }
    }
}

