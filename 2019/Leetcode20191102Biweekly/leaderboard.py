
#LEADERBOARD HOLDS THE VALUE OF ALL THE PLAYERS
class Leaderboard:

    def __init__(self):
        self.playerDict = dict()
        

    def addScore(self, playerId, score):
        try:
            self.playerDict[playerId] += score
        except KeyError:
            self.playerDict[playerId] = score

    def top(self, K):
        myList = list(sorted(self.playerDict.items(), key = lambda kv:(kv[1], kv[0])))
        mysum = 0
        print(myList[len(myList):len(myList)-K-1:-1])
        for obj in ((myList[len(myList):len(myList)-K-1:-1])):
            mysum += obj[1]
        return(mysum)
        

    def reset(self, playerId: int):
        self.playerDict[playerId] = 0
    


# Your Leaderboard object will be instantiated and called as such:
obj = Leaderboard()
obj.addScore(1,10)
obj.addScore(2,5)
obj.addScore(1,11)
obj.addScore(3,345)
obj.addScore(4,20)
obj.addScore(8,0)
obj.addScore(10,32)
obj.addScore(5,22)
# obj.top()
# print(dir(obj))
print(vars(obj))
param_2 = obj.top(3)
print(param_2)
# obj.reset(playerId)