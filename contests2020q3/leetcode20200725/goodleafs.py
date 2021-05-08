# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class contests2020q4.leetcode20201017.Solution:
    def countPairs(self, root: TreeNode, distance: int) -> int:
        # Create a dictionary that represents NODE_VAL : NODE_LEVEL
        # dist(p,q) = depth(p) + depth(q) - 2 * depth(lca(p,q))
        root.parent = None

        def mark_parents(node):
            if node is None:
                return 
            if node.left:
                node.left.parent = node.val
            if node.right:
                node.right.parent = node.val
            mark_parents(node.left)
            mark_parents(node.right)

        mark_parents(root)

        # def print_parent(node):
        #     if node is None:
        #         return
        #     print(node.parent)

        #     print_parent(node.left)
        #     print_parent(node.right)
        # print_parent(root)

        def within_distance(node, current_distance, distance):
            """ return the number of nodes within distance of node"""

            queue = [node.val]
            visited = [node.val]
            count = 0

            while queue and current_distance <= distance:
                next_level = []
                for node in queue:
                    if node.parent is not None: 
                        if node.parent.val not in visited:
                            next_level.append(node.parent)
                            visited.append(node.parent.val)
                            count +=1

                    if node.left and node.left.val not in visited:
                        next_level.append(node.left)
                        visited.append(node.left.val)
                        count += 1

                    if node.right and node.right.val not in visited:
                        next_level.append(node.right)
                        visited.append(node.right.val)
                        count +=1
                print(f"next_level at current distance = {current_distance} is")
                print(current_level)
                current_distance += 1

                queue = next_level
                # return result
                print(result)
                return result

        print(within_distance(root, 0, distance))



