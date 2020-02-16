"""Input: [2,7,4,1,8,1]
Output: 1
Explanation: 
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone."""


class Solution(object):
    def lastStoneWeight(self, stones):
        """
        :type stones: List[int]
        :rtype: int
        """
        while len(stones) > 1:
            print(stones)
            newList = stones
            if newList[-1] == newList[-2]:
                newList.pop()
                newList.pop()              ##same size
            elif newList[-1] > newList[-2]:
                newStone = newList[-1] - newList[-2]
                newList.pop()
                newList.pop()
                print(newList)
                newList.append(newStone)
                print(newList)
            else:
                newStone = newList[-2] - newList[-1]
                newList.pop()
                newList.pop()
                newList.append(newStone)
            newList.sort()
            stones = newList
            if len(stones) == 1:
                return(stones[0])
            else:
                return(0)