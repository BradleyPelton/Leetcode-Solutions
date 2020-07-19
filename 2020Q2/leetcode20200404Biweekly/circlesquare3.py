import math
# BRUTE FORCE DIDNT WORK. CHECKING 4000 POINTS ON THE SQUARE DIDNT WORK
class Solution:
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

            height_delta = height/100
            length_delta = length/100

            left_vertical_edge = [(x1, y1+height_delta*i) for i in range(0,101)]
            # print(left_vertical_edge)
            right_vertical_edge = [(x2,y1+height_delta*i) for i in range(0,101)]
            # print(right_vertical_edge)
            bottom_horizontal_edge = [(x1+length_delta*i,y1) for i in range(0,101)]
            # print(bottom_horizontal_edge)
            top_horizontal_edge = [(x1+length_delta*i,y2) for i in range(0,101)]
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

        # CHECK the 4 "corners" of the circle
        top_corner = (x_center, y_center+radius)
        bottom_corner = (x_center, y_center-radius)
        left_corner = (x_center-radius, y_center)
        right_corner = (x_center+radius,y_center)
        corners = [top_corner,bottom_corner,left_corner,right_corner]

        for corner in corners:
            if euclidean_distance(corner)

