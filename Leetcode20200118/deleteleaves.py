
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def removeLeafNodes(self, root: TreeNode, target: int) -> TreeNode:
        

        def helper(root,target):
            if not root:
                return 
            
            ans.append(root.val)

            if root.left is not None:
                helper(root.left,target)
            if root.right is not None:
                helper(root.right,target)

            if root.left is None and root.right is None and root.val is target:
                del root

        return(helper(root,target))
 
