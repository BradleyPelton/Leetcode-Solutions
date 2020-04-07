from itertools import combinations

#CORRECT
class CombinationIterator:

    def __init__(self, characters: str, combinationLength: int):
        """A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments."""
        self.characters = characters
        self.combinationLength = combinationLength
        self.position = 0
        self.gene = list(combinations(characters,combinationLength))

    def next(self) -> str:
        """A function next() that returns the next combination of length combinationLength in lexicographical order."""
        res = self.gene[self.position]
        answ = ""
        for obj in res:
            answ += obj

        self.position += 1
        return(answ)


    def hasNext(self) -> bool:
        """A function hasNext() that returns True if and only if there exists a next combination."""
        # print(self.position, "current position is less than or equal", (len(self.characters)-2))
        if self.position <= (len(self.gene)-1):
            return(True)
        else:
            return(False)
        

        


# Your CombinationIterator object will be instantiated and called as such:
# obj = CombinationIterator(characters, combinationLength)
# param_1 = obj.next()
# param_2 = obj.hasNext()


a = CombinationIterator("chp",2)
# print(vars(a))
print(a.next())
print(a.hasNext())
# print(a.next())
# print(a.next())


