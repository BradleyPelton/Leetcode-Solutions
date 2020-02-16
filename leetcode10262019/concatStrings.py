import itertools as it


class Solution:
    def maxLength(self, arr: List[str]) -> int:
        

        #arr is a list of strings
        #return the longest

        for a in arr:
            c = a 
            for b in arr:
                c+= b
                pr
                if list(dict.fromkeys(c)) != list(c):
                    break
            print(c)