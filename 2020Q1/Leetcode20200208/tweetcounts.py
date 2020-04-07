from typing import List

class TweetCounts:

    def __init__(self):
        self.tweet_dict = dict()


    def recordTweet(self, tweetName: str, time: int) -> None:

        if tweetName in self.tweet_dict.keys():
            # print("found duplicate tweet name")
            self.tweet_dict[tweetName].append(time)
        else:
            self.tweet_dict[tweetName] = list()
            self.tweet_dict[tweetName].append(time)

    def getTweetCountsPerFrequency(self, freq: str, tweetName: str, startTime: int, endTime: int) -> List[int]:
        ans = []

        if freq == 'minute':
            ans = []
            timestamps = self.tweet_dict[tweetName]
            
            for i in range(10000):
                # we are checking [starttime + i*60, starttime + 60 + i*60] INTERVAL
                temp_interval = []
                if startTime + i*60 > endTime:
                    break
                else:
                    temp_interval.append(startTime+i*60)


                if startTime + 60 + i*60 > endTime:
                    temp_interval.append(endTime)
                else:
                    temp_interval.append(startTime + 60 + i*60)


                if temp_interval[0] == temp_interval[1]:
                    temp_interval[1] += 1
                print("current interval is ",temp_interval)
                
                count = 0
                for timestamp in timestamps:
                    if timestamp >= temp_interval[0] and timestamp < temp_interval[1]:
                        # print(timestamp, "worked")
                        count += 1
                ans.append(count)
            
            print(ans)
            return(ans)



        if freq == 'hour':
            ans = []
            timestamps = self.tweet_dict[tweetName]
            
            for i in range(10000):
                temp_interval = []
                if startTime + i*360 > endTime:
                    break
                else:
                    temp_interval.append(startTime+i*360)


                if startTime + 360 + i*360 > endTime:
                    temp_interval.append(endTime)
                else:
                    temp_interval.append(startTime + 360 + i*360)


                if temp_interval[0] == temp_interval[1]:
                    temp_interval[1] += 1
                print("current interval is ",temp_interval)
                
                count = 0
                for timestamp in timestamps:
                    if timestamp >= temp_interval[0] and timestamp < temp_interval[1]:
                        # print(timestamp, "worked")
                        count += 1
                ans.append(count)
            
            print(ans)
            return(ans)




        if freq == 'day':
            ans = []
            timestamps = self.tweet_dict[tweetName]
            
            for i in range(10000):
                # we are checking [starttime + i*60, starttime + 60 + i*60] INTERVAL
                temp_interval = []
                if startTime + i*86400 > endTime:
                    break
                else:
                    temp_interval.append(startTime+i*86400)


                if startTime + 86400 + i*86400 > endTime:
                    temp_interval.append(endTime)
                else:
                    temp_interval.append(startTime + 86400 + i*86400)


                if temp_interval[0] == temp_interval[1]:
                    temp_interval[1] += 1
                print("current interval is ",temp_interval)
                
                count = 0
                for timestamp in timestamps:
                    if timestamp >= temp_interval[0] and timestamp < temp_interval[1]:
                        # print(timestamp, "worked")
                        count += 1
                ans.append(count)
            
            print(ans)
            return(ans)

obj = TweetCounts()
obj.recordTweet('tweet3',0)
obj.recordTweet('tweet3',60)
obj.recordTweet('tweet3',10)
# param_2 = obj.getTweetCountsPerFrequency('minute','tweet3',0,59)
# param_3 = obj.getTweetCountsPerFrequency('minute','tweet3',0,60)
obj.recordTweet('tweet3',120)
param_5 = obj.getTweetCountsPerFrequency('hour','tweet3',0,210)
