# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


# Accepted after 1st "real" submission (real meaning I didnt accidentally click submit instead
# of run code to test what the output was)

# MY FIRST BINARY TREE PROBLEM ACCEPTANCE!!!!!!!!!!!
# solved after 58 minutes

class contests2020q4.leetcode20201017.Solution:
    def goodNodes(self, root: TreeNode) -> int:
        """ """
        num_good_nodes = 1  # the first node is automatically included

        def print_path(node, current_path):
            nonlocal num_good_nodes
            if node is None:
                return

            current_path.append(node.val)
            # print(current_path)

            if node.val >= max(current_path):
                num_good_nodes += 1
                # print(f"incremeting good nodes, curent path is {current_path}")
                # print(f"value after increment is {num_good_nodes}")

            print_path(node.left, current_path)
            print_path(node.right, current_path)
            current_path.pop()

        print_path(root.left, [root.val])  # current path always includes the root node
        print_path(root.right, [root.val])
        # print("finished")
        return num_good_nodes
