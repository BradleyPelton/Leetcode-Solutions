# class Solution:
#     def numOfWays(self, n: int) -> int:
#         """ """
#         # Interesting problem.

#         # Theory: If a solution works for r,g,b then it works for g,b,r and b,r,g
#         # in words: the same exact positions but just shift the colors

#         # THUS THE ANSWER IS ALWAYS A MULTIPLE OF 3

#         # n <= 5000 means there are up to 3**5000 choices. Way too many to consider

#         # LET RED = 0 , YELLOW = 1, GREEN = 2

#         # THEN EVERY ROW IS IN [[0,1,0], [0,1,2],[0,2,0],[0,2,1]
#         #                       [1,0,1], [1,0,2], [1,2,0],

# # RED FIRST
# one = [0,1,0]
# two = [0,1,2]
# three = [0,2,0]
# four = [0,2,1]

# # YELLOW FIRST
# five = [1,0,1]
# six = [1,0,2]
# seven = [1,2,0]
# eight = [1,2,1]

# #GREEN FIRST
# nine = [2,0,1]
# ten = [2,0,2]
# eleven = [2,1,0]
# twelve = [2,1,2]

# if row_above = one:
#     posibilities = [five,six,eight, nine, ten]
# elif two:
#     posibilities = []




# # LINEAR DIFFERENCE
def f(x):
    res = (-75366367870196780/14842293442501
        +(138823173353674220/14842293442501)*x
        +(-2665965927520682500/519480270487535)*(x**2)
        +(451301652550437800/519480270487535)*(x**3)
        +(-36061482245807/207792108195014)*(x**4)
        )

    return(res)

print(f(1))
print(f(2))
print(f(3))
print(f(7))
print(f(5000))


# for obj in [1,2,3,7,5000]:
#     print(obj,obj**2,obj**3,obj**4)