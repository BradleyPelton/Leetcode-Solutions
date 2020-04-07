class Solution:
    answerDict = {
        '1': 31,
        '2': 28,
        '3': 31,
        '4': 30,
        '5': 31,
        '6': 30,
        '7': 31,
        '8': 31,
        '9': 30,
        '10': 31,
        '11': 30,
        '12': 31
    }

    def isLeapYear(self, Y):
        """returns True if February is Leap month in year Y, False if else"""
        if Y % 400 == 0:
            return(True)
        elif Y % 100 == 0:
            return(False)
        elif Y % 4 == 0:
            return(True)
        else:
            return(False)

    def numberOfDays(self, Y, M):
        """
        :type Y: int
        :type M: int
        :rtype: int
        """
        if M == 2 and isLeapYear(Y):
            return(29)
        else:
            return(answerDict[M])