# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

from typing import List
class contests2020q4.leetcode20201017.Solution:
    def balanceBST(self, root: TreeNode) -> TreeNode:
        all_node_vals = []
            def get_all_nodes(root):
                if root == None:
                    return
                    
                if root.left != None or root.right != None:
                    return self.minDepth(root.left)+self.minDepth(root.right)+1
                return min(self.minDepth(root.right),self.minDepth(root.left))+1
        

        # step down the tree one node at a time, adding two branches to every node
        # until we run out of Nodes
        