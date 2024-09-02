package _Study.Problems.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * TODO - Fix
 *
 */
public class QuickSort {
    public int[] sortArray(int[] nums) {
        List<Integer> arrList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        arrList = sort(arrList);
        int[] arr2 = arrList.stream().mapToInt(i -> i).toArray();
        return arr2;
    }
    public List<Integer> sort(List<Integer> arrList) {
        if (arrList.isEmpty() || arrList.size() == 1) {
            return arrList;
        }

        int midPoint = arrList.size()/2;
        int midPointVal = arrList.get(midPoint);

        List<Integer> lessThan = new ArrayList<>();
        List<Integer> greaterThan = new ArrayList<>();
        for (int i = 0; i < arrList.size(); i++) {
            if (arrList.get(i) < midPointVal) {
                lessThan.add(arrList.get(i));
            } else if (arrList.get(i) > midPointVal) {
                greaterThan.add(arrList.get(i));
            }
        }

        sort(lessThan);
        sort(greaterThan);
        mergeTwoSortedLists(lessThan, greaterThan);
        List<Integer> ansList = new ArrayList<>(lessThan);
        ansList.add(midPointVal);
        ansList.addAll(greaterThan);
        return ansList;
    }

    private List<Integer> mergeTwoSortedLists(List<Integer> listOne, List<Integer> listTwo) {
        List<Integer> ansList = new ArrayList<>();

        int listOneIndex = 0;
        int listTwoIndex = 0;

        while (listOneIndex < listOne.size() || listTwoIndex < listTwo.size()) {
            int listOneVal = listOneIndex < listOne.size() ? listOne.get(listOneIndex) : Integer.MAX_VALUE;
            int listTwoVal = listTwoIndex < listTwo.size() ? listTwo.get(listTwoIndex) : Integer.MAX_VALUE;

            if (listOneVal < listTwoVal) {
                ansList.add(listOne.get(listOneIndex));
                listOneIndex++;
            } else {
                ansList.add(listTwo.get(listTwoIndex));
                listTwoIndex++;
            }
        }

        return ansList;
    }
}


class TesjTs {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        quickSort.sortArray(new int[]{5,2,3,1});
    }
}
