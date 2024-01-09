from typing import List
class contests2020q4.leetcode20201017.Solution:
    def hasValidPath(self, grid: List[List[int]]) -> bool:
        def street_one(xpos,ypos,came_from):
            if came_from == "left":
                return(xpos+1,ypos,"left")
            elif came_from == "right":
                return(xpos-1,ypos,"right")
            else:
                return(xpos,ypos,"broken")
        def street_two(xpos,ypos,came_from):
            if came_from == "up":
                return(xpos,ypos+1,"up")
            elif came_from == "down":
                return(xpos,ypos-1,"down")
            else:
                return(xpos,ypos,"broken")
        def street_three(xpos,ypos,came_from):
            if came_from == "left":
                return(xpos,ypos+1,"up")
            elif came_from == "down":
                return(xpos-1,ypos-1,"right")
            else:
                return(xpos,ypos,"broken")
        def street_four(xpos,ypos,came_from):
            if came_from == "down":
                return(xpos+1,ypos,"left")
            elif came_from == "right":
                return(xpos-1,ypos+1,"up")
            else:
                return(xpos,ypos,"broken")
        def street_five(xpos,ypos,came_from):
            if came_from == "left":
                return(xpos,ypos-1,"down")
            elif came_from == "up":
                return(xpos-1,ypos+1,"right")
            else:
                return(xpos,ypos,"broken")
        def street_six(xpos,ypos,came_from):
            if came_from == "up":
                return(xpos+1,ypos,"left")
            elif came_from == "right":
                return(xpos-1,ypos-1,"down")
            else:
                return(xpos,ypos,"broken")


        came_from = "up"
        current_x = 0
        current_y = 0

        for _ in range(100):
            temp = grid[current_y][current_x]
            print(f"invoking {temp} street")
            print(f"before values {current_x},{current_y},{came_from}")
            if temp == 1:
                current_x,current_y,came_from = street_one(current_x,current_y,came_from)
            elif temp == 2:
                current_x,current_y,came_from = street_two(current_x,current_y,came_from)
            elif temp == 3:
                current_x,current_y,came_from = street_three(current_x,current_y,came_from)
            elif temp == 4:
                current_x,current_y,came_from = street_four(current_x,current_y,came_from)
            elif temp == 5:
                current_x,current_y,came_from = street_five(current_x,current_y,came_from)
            elif temp == 6:
                current_x,current_y,came_from = street_six(current_x,current_y,came_from)
            print(f"after values {current_x},{current_y},{came_from}")
            if came_from == "broken":
                print("shit broke")
                return(False)
            if current_y == len(grid) - 1 and current_x == len(grid[0]) - 1:
                print("reached the goal")
                return(True)

a = contests2020q4.leetcode20201017.Solution()
a.hasValidPath([[2,4,3],[6,5,2]])