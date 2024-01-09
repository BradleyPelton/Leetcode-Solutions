from typing import List

# compeltely stuck, no idea where to go
# my hypothesis was that the number of childless nodes had to be < n*.5
class contests2020q4.leetcode20201017.Solution:
    def validateBinaryTreeNodes(self, n: int, leftChild: List[int], rightChild: List[int]) -> bool:
        

        # n nodes
        # each node can have at most 2 children
        # no child can have more than 2 children
        # child relationship is one way

        dead_end_count = 0
        for i in range(n):
            # print("has left child",leftChild[i], "and right child",rightChild[i])
            if leftChild[i] == -1 and rightChild[i] == -1:
                print("reached dead end")
                dead_end_count += 1
        print(dead_end_count)

a = contests2020q4.leetcode20201017.Solution()
# a.validateBinaryTreeNodes(6,[1,-1,-1,4,-1,-1],[2,-1,-1,5,-1,-1]) #dead end =4, false
# a.validateBinaryTreeNodes(4,[1,-1,3,-1],[2,-1,-1,-1]) # 2, true
a.validateBinaryTreeNodes(4,[1,-1,3,-1],[2,3,-1,-1]) # 1, false