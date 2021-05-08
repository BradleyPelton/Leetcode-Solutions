from itertools import combinations
from itertools import permutations
class contests2020q4.leetcode20201017.Solution(object):
    def numTilePossibilities(self, tiles):
        rawList = tiles.split("")
        pureList = []
        for i in range(len(rawList)):
            if rawList[i] not in pureList:
                pureTiles.append(rawList[i])
                while rawList[i] in rawList:
                    rawList.remove(rawList[i])
        print(pureTiles)
