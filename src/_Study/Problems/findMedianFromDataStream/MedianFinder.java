package _Study.Problems.findMedianFromDataStream;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


/**
 * 295. Find Median from Data Stream
 * https://leetcode.com/problems/find-median-from-data-stream
 *
 * Fascinating application of two heaps working together.
 */
class MedianFinder {
    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;

    public MedianFinder() { // Two Heaps Solution - 24% runtime, 86% memory
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    // [0,1,2,3,4]
    // maxHeap is Left half [0,1,2]
    // minHeap is the Right half [3,4]

    public void addNum(int num) {
        maxHeap.add(num);

        minHeap.add(maxHeap.remove());

        if (minHeap.size() > maxHeap.size()) { // left heap should always be equal size or size + 1. (median is always left or left+right/2)
            maxHeap.add(minHeap.remove());
        }
    }

    public double findMedian() {
        double ans;
        if (minHeap.size() == maxHeap.size()) {
            int minVal = minHeap.peek();
            int maxVal = maxHeap.peek();
            ans = (minVal + maxVal) / 2.0;
        } else {
            ans = maxHeap.peek();
        }
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        mf.findMedian();
        mf.addNum(3);
        mf.findMedian();


        mf = new MedianFinder();
        mf.addNum(-1);
        mf.findMedian(); // -1.00000
        mf.addNum(-2);
        mf.findMedian(); // -1.50000
        mf.addNum(-3);
        mf.findMedian(); // -2.00000
        mf.addNum(-4);
        mf.findMedian(); // -2.50000
        mf.addNum(-5);
        mf.findMedian(); // -3.00000
    }
}
