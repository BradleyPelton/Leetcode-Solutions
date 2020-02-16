# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def maxProduct(self, root: TreeNode) -> int:
        
        temp = 0
        def treeSum(root):
            temp = 0
            while root.left is not None:
                temp += root.left.val
            return(temp)
        treeSum(root)
        return(temp)
