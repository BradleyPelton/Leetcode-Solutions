# Accepted after first attempt.
# I could have been quicker.

# I struggled with nonlocal again. I wonder if the optimal solution passes total_sum as a param to
# the dfs function or if the nonlocalize the variable like I did

class Solution:
    def rangeSumBST(self, root: TreeNode, L: int, R: int) -> int:
        total_sum = 0

        def dfs(node):
            nonlocal total_sum
            if node is None:
                return
            # print(node.val)
            if node.val <= R and node.val >= L:
                total_sum += node.val

            dfs(node.left)
            dfs(node.right)
        
        dfs(root)
        # print(total_sum)
        return total_sum