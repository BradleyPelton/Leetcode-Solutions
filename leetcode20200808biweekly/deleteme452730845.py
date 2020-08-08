
# Depth first search

class Solution():
    def mysearch(root):
        def dfs(node):
            if node is None:
                return

            print(node.val)

            dfs(node.left)
            dfs(node.right)
        
        dfs(root)



# Bredth first search
class BFSSolution():
    def mysearch(root):


        all_nodes = []
        que = [root]

        while que:
            next_level = []
            for node in que:
                if node.left is not None:
                    next_level.append(node.left)
                if node.right is not None:
                    next_level.append(node.right)
            
            vals = [node.val for node in next_level]
            all_nodes.extend(vals)
            que = next_level


def reverseList(list):
  previous = None         # `previous` initially points to None
  current = list.head     # `current` points at the first element
  following = current.next    # `following` points at the second element

  while current:
      current.next = previous # reverse the link
      previous = current      # move `previous` one step ahead
      current = following         # move `current` one step ahead
      if following:               # if this was not the last element
          following = following.next    # move `following` one step ahead

  list.head = previous
