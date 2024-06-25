package COMPSCIX404.AssignmentTwo;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Title: Assignment 02 - COMPSCIX404.1-019
 * Student: Bradley Pelton
 * Date: 2024-06-22
 */


public class Assignment_Two_Bradley_Pelton {
    // The questions are broken up into the 4 classes below. This class does not execute anything.
    QuestionOne q1 = new QuestionOne();
    QuestionTwo q2 = new QuestionTwo();
    QuestionThree q3 = new QuestionThree();
    QuestionFour q4 = new QuestionFour();
}

class QuestionOne {
    // Write a description and at least two examples (in real life and in programming) for:
    // Stacks
        // Definition: An abstract data type where you can only append to the end, view the end, or remove from the end.
        // 1. (real life) A Stack of pizza boxes
        // 2. (programming) The "back" button on Web browsers (stack of previously visited URLs)
    // Queues
        // Definition: An abstract data type where you can only append to the end, view the front, or remove the front.
        // 1. (real life) A line at the movie theaters
        // 2. (programming) A task scheduler where the priority of a task is the amount of time the
                // element has been waiting.
    // Deques
        // Definition: An abstract data type that supports the functionality of both Queues and Stacks (and nothing else)
        // 1. (real life) A parking lot with an entrance at the front and at the back.
        // 2. (programming) A doubly-linked list where you maintain a HEAD and TAIL pointer.
}

class QuestionTwo {
    public boolean hasBalancedBraces(String inputString) {
        Stack<Character> charStack = new Stack<>();

        for (char c : inputString.toCharArray()) {
            if (c == '[' || c == '{' || c == '(') {
                charStack.push(c);
            } else {
                if (charStack.isEmpty()) {
                    return false;
                }
                char charAtTopOfStack = charStack.pop();
                if (c == ')') {
                    if (charAtTopOfStack != '(') {
                        return false;
                    }
                } else if (c == ']') {
                    if (charAtTopOfStack != '[') {
                        return false;
                    }
                } else if (c == '}') {
                    if (charAtTopOfStack != '{') {
                        return false;
                    }
                } else {
                    throw new IllegalArgumentException("Unknown character detected. c = " + c);
                }
            }
        }

        return charStack.isEmpty(); // return true if there are no elements left "unmatched"
    }
}

class QuestionThree {
    static class DequeImpl<E> {
        private E[] elements; // This Deque is backed by a static array

        private int left;
        private int right;

        private int capacity;
        private int numberOfElements;

        /**
         * Initialize the Deque object.
         *
         *  <p>
         *      Initialize the static array that backs this implementation with capacity set to 10
         *      (and left = 0, right = 0, and numberOfElements = 0)
         * </p>
         *
         * <p>
         *     DESIGN PRINCIPLE: Just like add/remove/getFirst/getLast, this Deque throws
         *     exceptions if something unexpected happens. This is opposed
         *     to push/poll/peek pattern where unexpected things return null,
         * </p>
         */
        public DequeImpl() {
            left = 0;
            right = 0;

            capacity = 10; // Default capacity is 10, just like ArrayList<E>
            numberOfElements = 0;

            elements = (E[])(new Object[capacity]); // Weakness with Java generics. `new E[]` is not possible
        }

        public void append_left(E ele) {
            if (ele == null) throw new IllegalArgumentException("Deque does not support appending null elements");
            if (numberOfElements == capacity) { // expand if necessary
                expandCapacity();
            }

            if (!isEmpty()) { // if empty, leave the left/right index where it is
                left = ((left - 1) + capacity) % capacity; // else, circular index
            }
            elements[left] = ele;
            numberOfElements++;
        }

        public void append_right(E ele) {
            if (ele == null) throw new IllegalArgumentException("Deque does not support appending null elements");
            if (numberOfElements == capacity) {  // expand if necessary
                expandCapacity();
            }


            if (!isEmpty()) { // if empty, leave the left/right index where it is
                right = (right + 1) % capacity;  // else, circular index
            }
            elements[right] = ele;
            numberOfElements++;
        }

        public E pop_left() {
            if (isEmpty()) throw new NoSuchElementException("pop_left called when Deque was empty");
            numberOfElements--;

            E leftPop = elements[left];

            elements[left] = null;
            if (isEmpty()) { // If the Deque is empty now, we have to change both left and right indices.
                left = 0;
                right = 0;
            } else {
                left = (left + 1) % capacity; // else, circular index
            }

            return leftPop;
        }

        public E pop_right() {
            if (isEmpty()) throw new NoSuchElementException("pop_right called when Deque was empty");
            numberOfElements--;

            E rightPop = elements[right];

            elements[right] = null;
            if (isEmpty()) { // If the Deque is empty now, we have to change both left and right indices.
                left = 0;
                right = 0;
            } else {
                right = ((right - 1) + capacity) % capacity;  // else, circular index
            }

            return rightPop;
        }

        public E peek_left() {
            if (isEmpty()) throw new NoSuchElementException("peek_left called when Deque was empty");
            return elements[left];
        }

        public E peek_right() {
            if (isEmpty()) throw new NoSuchElementException("peek_right called when Deque was empty");
            return elements[right];
        }

        /**
         * Return the number of elements in the Dequeue
         */
        public int get_count() {
            return numberOfElements;
        }

        /**
         * Return true if the Deque has no elements.
         */
        public boolean isEmpty() {
            return get_count() == 0;
        }

        /**
         * Resize the Deque and move the elements back into regular order (from circular order)
         */
        private void expandCapacity() {
            E[] newArr = (E[])(new Object[capacity * 2]); // Weakness with Java generics. `new E[]` is not possible

            // Copy all the elements from `elements` into `newArr[0..numberOfElements]`. Fix the order while were here.
            for (int i = 0; i < numberOfElements; i++) {
                int nextIndex = (left + i + capacity) % capacity;
                newArr[i] = elements[nextIndex];
            }

            capacity *= 2; // Double the capacity similar to how dynamic arrays are resized
            left = 0; // since we moved the elements to the front, left and right are now the intuitive values
            right = numberOfElements - 1;

            elements = newArr; // replace the array
        }
    }
}

class QuestionFour {
    public int search(int[] intArr, int targetVal) {
        return binarySearchRecursive(intArr, targetVal, 0, intArr.length - 1);
    }

    private int binarySearchRecursive(int[] arr, int targetVal, int left, int right) {
        if (left >= right) { // base case
            if (arr[left] == targetVal) {
                return left;
            } else {
                return -1;
            }
        }

        int midPoint = left + (right - left)/2;  // regular binary search, but with indices
        if (arr[midPoint] == targetVal) {
            return midPoint;
        } else if (arr[midPoint] > targetVal) {
            return binarySearchRecursive(arr, targetVal, left, midPoint - 1);
        } else {
            return binarySearchRecursive(arr, targetVal, midPoint + 1, right);
        }
    }
}