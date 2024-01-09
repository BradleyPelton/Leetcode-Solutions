# First attempt Time Limit exceed, switching to vowels2
class contests2020q4.leetcode20201017.Solution:
    def maxVowels(self, s: str, k: int) -> int:
        
        vowels = ['a','e','i','o','u']

        max_num_vowels = 0

        for i in range(len(s)):
            substring = s[i:i+k]
            substring_vowel_count = 0
            for vowel in vowels:
                substring_vowel_count += substring.count(vowel)

            if substring_vowel_count > max_num_vowels:
                max_num_vowels = substring_vowel_count
            # print(substring, substring_vowel_count)
        print(max_num_vowels)
        return max_num_vowels


a = contests2020q4.leetcode20201017.Solution()
# a.maxVowels('abciiidef',3)
# a.maxVowels('aeiou', 2)
# a.maxVowels('leetcode', 3)
# a.maxVowels('rhythms', 4)
a.maxVowels('tryhard', 4)