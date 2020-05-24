
# Solved in 3 minutes. Easy peasy. startswith is important to learn and use. PEP8 recommended.
class Solution:
    def isPrefixOfWord(self, sentence: str, searchWord: str) -> int:
        

        words = sentence.split(" ")
        for i in range(len(words)):
            if words[i].startswith(searchWord):
                return i + 1
        else:
            return -1

a = Solution()
# print(a.isPrefixOfWord("i love eating burger", 'burg'))
# print(a.isPrefixOfWord("this problem is an easy problem", 'pro'))
print(a.isPrefixOfWord("i am tired", 'you'))
# print(a.isPrefixOfWord("this problem is an easy problem", 'pro'))
# print(a.isPrefixOfWord("this problem is an easy problem", 'pro'))
# print(a.isPrefixOfWord("this problem is an easy problem", 'pro'))
