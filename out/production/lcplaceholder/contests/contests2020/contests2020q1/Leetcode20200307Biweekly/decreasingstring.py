from collections import Counter

# answer accepted on the first submission.
# particullarly beatuiful solution in my opinion
class contests2020q4.leetcode20201017.Solution:
    def sortString(self, s: str) -> str:

        """
        Pick the smallest character from s and append it to the result.
        Pick the smallest character from s which is greater than the last appended character to the result and append it.
        Repeat step 2 until you cannot pick more characters.
        Pick the largest character from s and append it to the result.
        Pick the largest character from s which is smaller than the last appended character to the result and append it.
        Repeat step 5 until you cannot pick more characters.
        Repeat the steps from 1 to 6 until you pick all characters from s.
        """

        copy = s[:]
        copy = ''.join(sorted(list(copy)))
        
        counter_dict = dict(Counter(copy))
        # print(counter_dict)

        ans = ''
        def forward(cdict,ans):
            """ decrements each element in cdict, appends element to ans"""
            for key,val in cdict.items():
                if val > 0:
                    ans += key
                    cdict[key] -= 1
            return(cdict,ans)

        def backward(cdict,ans):
            """ decrements each element in cdict, appends element to ans"""
            for key,val in reversed(cdict.items()):
                if val > 0:
                    ans += key
                    cdict[key] -= 1
            return(cdict,ans)
        
        # print(forward(counter_dict,ans)[0])
        # print(backward(counter_dict,ans)[1])

        while sum(counter_dict.values()) > 0:
            temp = forward(counter_dict,ans)
            counter_dict, ans = temp[0], temp[1]
            temp = backward(counter_dict,ans)
            counter_dict, ans = temp[0], temp[1]
        print(ans)
        return(ans)


a = contests2020q4.leetcode20201017.Solution()
a.sortString("leetcode")
a.sortString("spo")
a.sortString("rat")
a.sortString("ggggggg")
a.sortString("aaaabbbbcccc")