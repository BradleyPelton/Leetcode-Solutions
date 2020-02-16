class Solution:
    def reverse(self, x: int) -> int:
        if x < 0:
            strX = str(abs(x))
            strY = ""
            for i in range(len(strX)-1,-1,-1):
                strY +=strX[i]
                strY = strY.lstrip("0")
            if abs(int(str(strY))) > 2147483648:
                return "0"
            return("-"+strY)
        elif x > 0:
            strY = ""
            strX = str(x)
            for i in range(len(strX)-1,-1,-1):
                strY +=strX[i]
                strY = strY.lstrip("0")
            if abs(int(str(strY))) > 2147483648:
                return "0"
            return(strY)
        else:
            return("0")

