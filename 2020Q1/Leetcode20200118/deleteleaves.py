
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

### MY INCORRECT SOLUTION
class Solution:
    def removeLeafNodes(self, root: TreeNode, target: int) -> TreeNode:
        

        def helper(root,target):
            if not root:
                return 

            if root.left is not None:
                helper(root.left,target)
            if root.right is not None:
                helper(root.right,target)


            if root.left is None and root.right is None and root.val is target:
                del root
            else:
                return
        return(helper(root,target))
 

### TOP VOTED PYTHON SOLUTION
def removeLeafNodes(self, root, target):
    if root:
        root.left = self.removeLeafNodes(root.left, target)
        root.right = self.removeLeafNodes(root.right, target)
        if root.val == target and root.left is root.right:
            return None
        return root