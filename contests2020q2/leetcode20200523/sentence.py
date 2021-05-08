
# Solved in 3 minutes. Easy peasy. startswith is important to learn and use. PEP8 recommended.
class contests2020q4.leetcode20201017.Solution:
    def isPrefixOfWord(self, sentence: str, searchWord: str) -> int:
        

        words = sentence.split(" ")
        for i in range(len(words)):
            if words[i].startswith(searchWord):
                return i + 1
        else:
            return -1

a = contests2020q4.leetcode20201017.Solution()
# print(a.isPrefixOfWord("i love eating burger", 'burg'))
# print(a.isPrefixOfWord("this problem is an contests2020q4.leetcode20201226biweekly.easy problem", 'pro'))
print(a.isPrefixOfWord("i am tired", 'you'))
# print(a.isPrefixOfWord("this problem is an contests2020q4.leetcode20201226biweekly.easy problem", 'pro'))
# print(a.isPrefixOfWord("this problem is an contests2020q4.leetcode20201226biweekly.easy problem", 'pro'))
# print(a.isPrefixOfWord("this problem is an contests2020q4.leetcode20201226biweekly.easy problem", 'pro'))
