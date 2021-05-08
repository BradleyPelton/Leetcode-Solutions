from collections import deque
# Accepted after 2nd attempt, just had to work smarter
# storing the string and incremeting, decrementing 1 if the appendright is vowel
class contests2020q4.leetcode20201017.Solution:
    def maxVowels(self, s: str, k: int) -> int:
        
        vowels = ['a','e','i','o','u']

        max_num_vowels = 0

        start = 0
        end = k  # NOT INCLUDING
        sub_deque = deque(s[start:end])
        print(sub_deque)

        current_vowel_count = 0
        for vowel in vowels:
            current_vowel_count += sub_deque.count(vowel)
        
        max_num_vowels = current_vowel_count
        # print(current_vowel_count)


        while end < len(s):
            pop_left = sub_deque.popleft()
            if pop_left in vowels:
                current_vowel_count -= 1

            if s[end] in vowels:
                current_vowel_count += 1
            if current_vowel_count > max_num_vowels:
                max_num_vowels = current_vowel_count

            sub_deque.append(s[end])
            # print(sub_deque)
            # print(f"current vowel count is {current_vowel_count}")

            start += 1
            end += 1 
        
        print(f"FINAL ANSWER {max_num_vowels}")
        return max_num_vowels

        # for i in range(len(s)):
        #     substring = s[i:i+k]
        #     substring_vowel_count = 0
        #     for vowel in vowels:
        #         substring_vowel_count += substring.count(vowel)

        #     if substring_vowel_count > max_num_vowels:
        #         max_num_vowels = substring_vowel_count
        #     # print(substring, substring_vowel_count)
        # print(max_num_vowels)
        # return max_num_vowels


a = contests2020q4.leetcode20201017.Solution()
# a.maxVowels('abciiidef',3)
# a.maxVowels('aeiou', 2)
# a.maxVowels('leetcode', 3)
# a.maxVowels('rhythms', 4)
a.maxVowels('tryhard', 4)