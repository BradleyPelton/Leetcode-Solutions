def eff(inputstring):
    if len(inputstring) == 1:
        return(1)
    smallest = ""
    smallest_index = len(inputstring)+1
    for i in range(len(inputstring)):
        temp = ord(inputstring[i])-97
        if temp < smallest_index:
            smallest_index = temp
            smallest = inputstring[i]
    return(inputstring.count(smallest))

class Solution:
    def numSmallerByFrequency(self, queries: List[str], words: List[str]) -> List[int]:
        wordList = []
        queriesList = []
        answer = []

        for word in queries:
            queriesList.append(eff(word))

        for w in words:
            wordList.append(eff(w))

        for i in range(len(queries)):
            count = 0
            for j in range(len(wordList)):
                if queriesList[i] < wordList[j]:
                    count += 1
            answer.append(count)
        return(answer)

