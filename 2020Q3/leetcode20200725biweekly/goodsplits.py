from collections import Counter

# FIrst attempt rejected, brute force, time liit exceeded

class Solution:
    def numSplits(self, s: str) -> int:
        
        total_count = 0
        for i in range(1,len(s)):
            left = s[:i]
            right = s[i:]


            if len(list(set(left))) == len(list(set(right))):
                total_count += 1
        
        print(total_count)
        return total_count


a = Solution()
a.numSplits("aacaba")
a.numSplits("abcd")
a.numSplits("aaaaa")
a.numSplits("acbadbaada")