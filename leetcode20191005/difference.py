"""Given an integer array arr and an integer difference, return the length of the longest subsequence in arr which is 
an arithmetic sequence such that the difference between adjacent elements in the subsequence equals difference."""


# iterating backwards from through the list to check if tempArr is longest
#e.g. [1,3,5,7,8,9]
# homebase = 9 
#for all elements before homebase, if homebase - element % difference == 0, then add element to temparr
#compare the lengths of temparrs
#store the values of temparrs, saving the largest


class Solution:
    def longestSubsequence(self, arr: List[int], difference: int) -> int:
        longest = 0 
        difference = abs(difference)
        if difference >0:
            try:
                for i in range(len(arr)-1,-1,-1):
                    homebase = arr[i]
                    tempArr = []
                    for i in range(1000000):
                        if (homebase - difference*i) in arr 
                            tempArr.append(homebase-difference*i)
                        else:
                            break
                    if len(tempArr) > longest:
                        longest = len(tempArr)
            except IndexError:
                pass 
            return(longest)
    