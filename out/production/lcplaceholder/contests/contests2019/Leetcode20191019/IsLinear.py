

# y - y_0 = m(x - x_0)


class contests2020q4.leetcode20201017.Solution:
    def checkStraightLine(self, coordinates: List[List[int]]) -> bool:
        x_0 = coordinates[0][0]
        y_0 = coordinates[0][1]
        x_1 = coordinates[1][0]
        y_1 = coordinates[1][1]

        m = (y_1 - y_0)/(x_1 - x_0)

        for entry in coordinates:
            if entry[1] - y_0 != m*(entry[0] - x_0):
                return(False)
        return(True)