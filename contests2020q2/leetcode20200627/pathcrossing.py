
## Accepted first try. Leetcode was DDOS'd and was down for 30 minutes
# I solved this after about 5 minutes.

class contests2020q4.leetcode20201017.Solution:
    def isPathCrossing(self, path: str) -> bool:
        current_x = 0
        current_y = 0

        visited_points = [(0,0)]
        
        for char in path:
            if char == 'N':
                current_y += 1
                new_point = (current_x, current_y)
                visited_points.append(new_point)
            elif char == 'W':
                current_x -= 1
                new_point = (current_x, current_y)
                visited_points.append(new_point)
            elif char == 'E':
                current_x += 1
                new_point = (current_x, current_y)
                visited_points.append(new_point)
            elif char == 'S':
                current_y -= 1
                new_point = (current_x, current_y)
                visited_points.append(new_point)

        print(visited_points)

        if len(list(set(visited_points))) == len(visited_points):
            print("no, it didnt cross, returning false")
            return False
        else:
            print("yes it did cross, returning true")
            return True

a = contests2020q4.leetcode20201017.Solution()
a.isPathCrossing("NES")
# a.isPathCrossing("NESWW")