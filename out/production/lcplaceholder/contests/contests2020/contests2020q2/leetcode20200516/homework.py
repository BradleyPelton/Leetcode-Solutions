from typing import List

# accepted first attempt. solved in 5 mintues
class contests2020q4.leetcode20201017.Solution:
    def busyStudent(self, startTime: List[int], endTime: List[int], queryTime: int) -> int:
        """ """

        student_count = 0
        for i in range(len(startTime)):
            if startTime[i] <= queryTime and queryTime <= endTime[i]:
                student_count += 1

        print(student_count)
        return(student_count)


a = contests2020q4.leetcode20201017.Solution()
# a.busyStudent([1,2,3], [3,2,7], 4)
# a.busyStudent([4],[4], 4)
# a.busyStudent([4],[4],5)
a.busyStudent([1,1,1,1], [1,3,2,4], 7)
a.busyStudent([9,8,7,6,5,4,3,2,1], [10,10,10,10,10,10,10,10,10], 5)