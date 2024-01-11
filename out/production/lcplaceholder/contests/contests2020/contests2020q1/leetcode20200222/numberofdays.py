import datetime

class contests2020q4.leetcode20201017.Solution:
    def daysBetweenDates(self, date1: str, date2: str) -> int:
        list1 = date1.split("-")
        list2 = date2.split("-")
        # print(list1,list2)

        datetime_1 = datetime.datetime(int(list1[0]),int(list1[1]),int(list1[2]))
        datetime_2 = datetime.datetime(int(list2[0]),int(list2[1]),int(list2[2]))

        print(datetime_1)
        print(datetime_2)

        num_of_days = abs((datetime_2 - datetime_1).days)
        print(num_of_days)
        return(num_of_days)

a = contests2020q4.leetcode20201017.Solution()
# a.daysBetweenDates('contests2019-06-29','contests2019-06-30')
a.daysBetweenDates('2020-01-15','contests2019-12-31')