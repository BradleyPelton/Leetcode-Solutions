package util;


/**
 * Segment Tree ArrayBacked:
 * <p>
 *     "BOTTOM UP"
 * This is effectively a serialized version of a binary tree.
 * The array that backs the Segment is tree is 2*n size.
 *
 * if i is not a leaf node, 2i and 2i+1 are the left and right children
 * </p>
 */
class SegmentTree {
    int[] segmentArr;
    int originalArrSize;
    public SegmentTree(int[] arr) {
        originalArrSize = arr.length;
        segmentArr = new int[originalArrSize * 2]; // Create array of twice the size

        // STEP ONE: FILL SECOND HALF: memcpy the original array to the second half of
        // [0,0,...,1,2,3,4,5]  ({0} * n + arr)
        for (int i = 0; i < originalArrSize; i++) {
            segmentArr[originalArrSize + i] = arr[i];
        }

        // STEP TWO: FILL FIRST HALF
        for (int i = originalArrSize - 1; i > 0; --i) {
            segmentArr[i] = segmentArr[i * 2]       // LEFT CHILD
                          + segmentArr[i * 2 + 1];  // RIGHT CHILD
        }
    }


    // TODO - I don't like this implementation.
    public int rangeQuery(int leftIndex, int rightIndex) {
        int leftSegmentIndex = leftIndex + originalArrSize;
        int rightSegmentIndex = rightIndex + originalArrSize;

        // Least comment ancestor
        int sum = 0;
        while (leftSegmentIndex <= rightSegmentIndex) {
            // CHECK IF leftSegmentIndex is a left or right childNode of its parent
            if (leftSegmentIndex % 2 == 1) { // if RIGHT CHILD
                sum += segmentArr[leftSegmentIndex];
                leftSegmentIndex++;
            }
            if (rightSegmentIndex % 2 == 0) {
                sum += segmentArr[rightSegmentIndex];
                rightSegmentIndex--;
            }
            leftSegmentIndex /= 2;
            rightSegmentIndex /= 2;
        }
        return sum;
    }

    public void updateNode(int index, int newValue) {
        int indexInSegmentArr = index + originalArrSize;

        // STEP ONE: Update the original element
        segmentArr[indexInSegmentArr] = newValue;

        // STEP TWO: Update all parent nodes
        int currIndex = indexInSegmentArr;
        while (currIndex > 0) {
            int leftChildIndex;
            int rightChildIndex;

            // Determine if currIndex corresponds to the left or right child of it's parentNode.
            if (currIndex % 2 == 0) {
                leftChildIndex = currIndex;
                rightChildIndex = currIndex + 1;
            } else {
                leftChildIndex = currIndex - 1;
                rightChildIndex = currIndex;
            }

            int parentNodeIndex = currIndex / 2;
            segmentArr[parentNodeIndex] = segmentArr[leftChildIndex] + segmentArr[rightChildIndex];
            currIndex = parentNodeIndex;
        }
    }

    public static SegmentTree buildSegmentTree(int[] arr) {
        return new SegmentTree(arr);
    }
}

/**
 * Segment Tree (Binary Tree-backed)
 *
 */
public class SegmentNode {
    SegmentNode leftChild;
    SegmentNode rightChild;
    int val;
    int start;
    int end;

    public SegmentNode(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int rangeQuery(int leftIndex, int rightIndex) {
        // CASE ONE: Perfect fit
        if (leftIndex == start && rightIndex == end) {
            return val;
        }

        // CASE TWO: Proper subset of leftChild or rightChild
        if (rightIndex <= leftChild.end) {          // ALL IN LEFT
            return leftChild.rangeQuery(leftIndex, rightIndex);
        } else if (leftIndex >= rightChild.start) { // ALL IN RIGHT
            return rightChild.rangeQuery(leftIndex, rightIndex);
        }

        // CASE THREE: SPLIT between leftChild and rightChild

        int splitLeft = leftChild.rangeQuery(leftIndex, leftChild.end);
        int splitRight = rightChild.rangeQuery(rightChild.start, rightIndex);
        return splitLeft + splitRight;
    }

    public void updateNode(int index, int oldValue, int newValue) {
        if (start == index && end == index) {
            val = newValue;
            return;
        }

        val +=  (newValue - oldValue);

        // CASE ONE: in left
        if (index <= leftChild.end) {
            leftChild.updateNode(index, oldValue, newValue);
        } else if (index >= rightChild.start) {
            rightChild.updateNode(index, oldValue, newValue);
        } else {
            throw new IllegalStateException("updateNode failure, not in left or right");
        }
    }

    public static SegmentNode buildSegmentTree(int[] arr, int left, int right) {
        SegmentNode ans = new SegmentNode(left, right);

        if (left == right) {
            ans.val = arr[left];
        } else {
            int midPoint = left + (right - left) / 2;

            ans.leftChild = buildSegmentTree(arr, left, midPoint);
            ans.rightChild = buildSegmentTree(arr, midPoint + 1, right);

            ans.val = ans.leftChild.val + ans.rightChild.val;
        }
        return ans;
    }
}
