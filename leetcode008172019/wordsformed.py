from collections import Counter

class Solution:
    def countCharacters(self, words: List[str], chars: str) -> int:
        charCounter  = list(Counter(chars))
        print(charCounter)
        for word in words:
            wordCounter = list(Counter(word))
            print(wordCounter)








class Solution:
    def countCharacters(self, words: List[str], chars: str) -> int:
        answer = 0
        for word in words:
            charsList = list(chars)
            count = 0
            wordList = list(word)
            for character in wordList:
                if character in charsList:
                    charsList.remove(character)
                else:
                    count += 1
            if count == 0:
                print(word)
                answer += len(word)
        return(answer)
