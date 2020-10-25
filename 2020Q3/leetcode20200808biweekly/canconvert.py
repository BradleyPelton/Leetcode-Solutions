
# First solution index error, didnt count edge case
# Second solution wrong answer

## Accepted third solution after 30 minutes. SLoppy not considering the two edge cases.
# In my defense, the second edge case is pretty stupid(differnt lengths of s and t)

class Solution:
    def canConvertString(self, s: str, t: str, k: int) -> bool:
        
        
        current_string = s[:]

        alpha = "abcdefghijklmnopqrstuvwxyz"

        s_index_dict = {}
        t_index_dict = {}
        for i in range(len(s)):
            s_index_dict[i] = alpha.index(s[i])
            t_index_dict[i] = alpha.index(t[i])
        # print(s_index_dict)
        # print(t_index_dict)

        shifts_needed = []
        for i in range(len(s)):
            # current character is s[i]
            # character needs to be t[i]
            delta = t_index_dict[i] - s_index_dict[i]

            if delta < 0:
                delta += 26
            if delta != 0:
                shifts_needed.append(delta)
        # print(shifts_needed)

        shifts_needed.sort()
        corrected_shifts = []

        current_val = 0
        current_shift = 0
        for j in range(len(shifts_needed)):
            if shifts_needed[j] == current_val:
                current_shift += 26
                new_val = shifts_needed[j] + current_shift
                corrected_shifts.append(new_val)

            elif shifts_needed[j] != current_val:
                corrected_shifts.append(shifts_needed[j])
                current_shift = 0
                current_val = shifts_needed[j]
        # print(corrected_shifts)

        if len(s) != len(t):
            print("differnet length edge case, return False")
            return False
        if corrected_shifts == []:
            print("no shift edge case, return True")
            return True
        
        if max(corrected_shifts) <= k:
            print("true")
            return True
        else:
            print("false")
            return False





a = Solution()
# a.canConvertString(s = "input", t = "ouput", k = 9)
# a.canConvertString(s = "abc", t = "bcd", k = 10)
# a.canConvertString(s = "aab", t = "bbb", k = 27)
a.canConvertString(s= "abc", t="abcd", k=1000)