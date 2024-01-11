
# accepted on third attempt. First attempt I forgot to join the list back together
# second attempt was wrong because line 10 I tried to get fancy and sort by index
# but the index for duplicate words "by" and 'by' broke the solution
class contests2020q4.leetcode20201017.Solution:
    def arrangeWords(self, text: str) -> str:

        words = text.split(" ")
        print(words)

        # words.sort(key=lambda x: (len(x), text.index(x)))
        words.sort(key=lambda x: len(x))
        print(words)

        for i in range(len(words)):
            if i==0:
                words[i] = words[i].title()
            else:
                words[i] = words[i].lower()
        print(words)

        ans = " ".join(words)
        print(ans)
        return ans


a = contests2020q4.leetcode20201017.Solution()
# a.arrangeWords("Leetcode is cool")
# a.arrangeWords("Keep calm and code on")
a.arrangeWords("To be or not to be")