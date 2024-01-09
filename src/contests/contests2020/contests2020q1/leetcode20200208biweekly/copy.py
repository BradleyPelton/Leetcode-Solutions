class contests2020q4.leetcode20201017.Solution:
    def angleClock(self, hour: int, minutes: int) -> float:

        def minutes_hand(hour,minutes):
            if minutes >= 0 and minutes <= 15:
                return(90-minutes*6)
            elif minutes > 15 and minutes <= 60:
                 # minutes = 20 returns is 330 degress
                 # minutes = 25 returns 300 degrees
                 # minutes = 30 returns 270 degrees
                 return(360 - (minutes-15)*6)
            # elif minutes > 30 and minutes < 45:
            #     # minutes = 35 returns 240
            #     # minutes  = 40 eturns 210
            #     # minutes  = 45 returns 180
            #     return(360 - (minutes-15)*6)


        def hour_hand(hour,minutes):
            mysum = 0
            mydict = {12:90,1:60,2:30,3:0,4:330,5:300,6:270,7:240,8:210,9:180,10:150,11:120}

            minu_offset = minutes/2

            if hour == 3:
                ans = 360 - minu_offset
            else:
                ans = mydict[hour] - minu_offset

            # print("degree of hour hand is ", ans)
            return(ans)

        print(minutes_hand(hour,minutes),hour_hand(hour,minutes))

        angle_a = minutes_hand(hour,minutes) - hour_hand(hour,minutes)
        angle_b = hour_hand(hour,minutes) - minutes_hand(hour,minutes)

        if angle_a < 0:
            angle_a = 360 + angle_a
        if angle_b < 0:
            angle_b = 360 + angle_b
        
        ans = min(angle_a,angle_b)
        print(ans)
        return(ans)

        

a = contests2020q4.leetcode20201017.Solution()
a.angleClock(12,30)