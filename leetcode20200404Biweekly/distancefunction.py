import math
def euclidean_distance(vector_1, vector_2) -> float:
    """ returns the euclidean distance between vector 1 and vector 2"""


    before_square_root = 0
    for i in range(len(vector_1)):
        before_square_root += (vector_1[i] - vector_2[i])**2

    d = math.sqrt(before_square_root)
    print(d)
    return(d)
    


euclidean_distance((2,-1),(-2,2))


def grab_40_vectors(x1,x2,y1,y2) -> list:
    """grab 10 points from each edge of the square"""

    if x1 > x2:
        x1,x2 = x2,x1
    if y1 > y2:
        y1,y2 = y2,y1

    height = abs(y2-y1)
    length = abs(x2-x1)

    height_delta = height/10
    length_delta = length/10

    left_vertical_edge = [(x1, y1+height_delta*i) for i in range(0,11)]
    # print(left_vertical_edge)
    right_vertical_edge = [(x2,y1+height_delta*i) for i in range(0,11)]
    # print(right_vertical_edge)
    bottom_horizontal_edge = [(x1+length_delta*i,y1) for i in range(0,11)]
    # print(bottom_horizontal_edge)
    top_horizontal_edge = [(x1+length_delta*i,y2) for i in range(0,11)]
    # print(top_horizontal_edge)

    all_vectors = left_vertical_edge+right_vertical_edge+bottom_horizontal_edge+top_horizontal_edge
    return(all_vectors)


grab_40_vectors(0,1,0,1)