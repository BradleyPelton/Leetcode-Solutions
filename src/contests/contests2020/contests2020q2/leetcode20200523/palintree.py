# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


from collections import Counter


# Accepted after 3 attempt. Solved at 11:26.
# Fell into a famous trap where I was appending the pointer to current_path
# Instead of appending a copy of the current_path. Otherwise the solution was pretty contests2020q4.leetcode20201226biweekly.easy.
# Finding all root to leaf node paths is a great exercise to have memorized
# TODO- FIND ALL ROOT TO LEAF NODE PATHS
# I had to reference last weeks solution on how to find all paths (biweekly 20200516)
class contests2020q4.leetcode20201017.Solution:
    def pseudoPalindromicPaths(self, root: TreeNode) -> int:
        """ """
        def is_palindromable(nodelist):
            """return true if list can be converted to a palindrome"""
            # palindrome iff Counter(nodelist) contains only one odd
            node_counter = Counter(nodelist)

            num_of_odds = 0
            for key in node_counter.keys():
                if node_counter[key] % 2 == 1:
                    num_of_odds += 1

            if len(nodelist) % 2 == 0:
                if num_of_odds > 0:
                    return False
                else:
                    return True
            elif len(nodelist) % 2 == 1:
                if num_of_odds > 1:
                    return False
                else:
                    return True

        all_paths = []

        def get_all_root_to_leaf_paths(node, current_path):
            """ """
            nonlocal all_paths

            if node is None:
                return

            current_path.append(node.val)

            if node.left is None and node.right is None:
                # print(f"NEW PATH is {current_path}")
                # add the current path to all_paths
                all_paths.append(current_path[:])
                # remove the last node from current path
                current_path.pop()
                return
            else:
                get_all_root_to_leaf_paths(node.left, current_path)
                get_all_root_to_leaf_paths(node.right, current_path)
                current_path.pop()

        get_all_root_to_leaf_paths(root, current_path=[])
        # print("finsihed tree")
        # print(f'all paths is {all_paths}')

        good_paths = 0
        for path in all_paths:
            if is_palindromable(path):
                good_paths += 1
        # print(good_paths)
        return good_paths

