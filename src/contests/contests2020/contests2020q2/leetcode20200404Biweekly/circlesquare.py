import math
# BRUTE FORCE DIDNT WORK. CHECKING 4000 POINTS ON THE SQUARE DIDNT WORK
class contests2020q4.leetcode20201017.Solution:
    def checkOverlap(self, radius: int, x_center: int, y_center: int,
                     x1: int, y1: int, x2: int, y2: int) -> bool:
        """ check overlap"""

        def euclidean_distance(vector_1, vector_2) -> float:
            """ returns the euclidean distance between vector 1 and vector 2"""


            before_square_root = 0
            for i in range(len(vector_1)):
                before_square_root += (vector_1[i] - vector_2[i])**2

            d = math.sqrt(before_square_root)
            print(d)
            return(d)

        def grab_40_vectors(x1,x2,y1,y2) -> list:
            """grab 10 points from each edge of the square"""

            if x1 > x2:
                x1,x2 = x2,x1
            if y1 > y2:
                y1,y2 = y2,y1

            height = abs(y2-y1)
            length = abs(x2-x1)

            height_delta = height/1000
            length_delta = length/1000

            left_vertical_edge = [(x1, y1+height_delta*i) for i in range(0,1001)]
            # print(left_vertical_edge)
            right_vertical_edge = [(x2,y1+height_delta*i) for i in range(0,1001)]
            # print(right_vertical_edge)
            bottom_horizontal_edge = [(x1+length_delta*i,y1) for i in range(0,1001)]
            # print(bottom_horizontal_edge)
            top_horizontal_edge = [(x1+length_delta*i,y2) for i in range(0,1001)]
            # print(top_horizontal_edge)

            all_vectors = left_vertical_edge+right_vertical_edge+bottom_horizontal_edge+top_horizontal_edge
            # print(len(all_vectors))
            return(all_vectors)

        # THIS CHECKS THAT ANY POINT ON THE EDGE OF THE SQUARE
        # CROSSES THE THE CIRCLE
        for vector in grab_40_vectors(x1,x2,y1,y2):
            if euclidean_distance(vector, (x_center,y_center)) <= radius:
                return(True)

        # IF NO POINT CROSSES THE CIRCLE, THEN EITHER CIRCLE IS ENTIRELY CONTAINED IN SQUARE
        # OR THEY NEVER INTERSECT

        if (x_center -radius > x1 and x_center + radius < x2
            and y_center -radius > y1 and y_center + radius < y2):
            print("REACHED TOTAL OVERLAP CASE")
            return(True)
        return(False)

















a = contests2020q4.leetcode20201017.Solution()
# print(a.checkOverlap(1,0,0,1,-1,3,1))
# print(a.checkOverlap(1,0,0,-1,0,0,1))
# print(a.checkOverlap(1,1,1,-3,-3,3,3))
# print(a.checkOverlap(1,1,1,1,-3,2,-1))


print(a.checkOverlap(5,7,2,12,0,19,3))