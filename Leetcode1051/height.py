class Solution(object):
    def heightChecker(self, heights):
        """
        :type heights: List[int]
        :rtype: int
        """
        newList = list(heights)
        newList.sort()
        count = 0
        for i in range(len(heights)):
            if newList[i] == heights[i]:
                count+=1
        return((len(heights)-count))