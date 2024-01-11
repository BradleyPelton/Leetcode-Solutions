
# accepted after first attempt.
# 6 minutes to complete
# Sloppy. I know there should be  simple one liner for reformatting dates just like in SQL

class contests2020q4.leetcode20201017.Solution:
    def reformatDate(self, date: str) -> str:

        split_date = date.split(" ")
        print(split_date)

        if len(split_date[0]) == 4:
            day = split_date[0][0:2]
        else:
            day = split_date[0][0:1]

        if len(str(day)) == 1:
            day = '0' + str(day)
        
        # print(day)

        month_list = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"]
        
        month = month_list.index(split_date[1]) + 1
        if len(str(month)) == 1:
            month = '0' + str(month)
        # print(month)

        year = split_date[2]

        final_date = str(year) + '-' + str(month) + '-' + str(day)
        print(final_date)

        return final_date


a = contests2020q4.leetcode20201017.Solution()
a.reformatDate('20th Oct 2052')
a.reformatDate('6th Jun 1933')
a.reformatDate("26th May 1960")