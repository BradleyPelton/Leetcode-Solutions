import string 
import random

class Solution:
    def modifyString(self, s: str) -> str:
        full_alpha = 'abcdefghijklmnopqrstuvwxyz'


        for i in range(len(s)-1):
            if s[i] == '?':
                







                # banned_indecies = []

                # prev_char = s[i-1]
                # prev_index = full_alpha.index(prev_char)

                # next_char = s[i-1]
                # if next_char == '?':
                #     pass
                # else:
                #     next_index = full_alpha.index(next_char)
                #     banned_indecies.append(next_index -1)
                #     banned_indecies.append(next_index)
                #     banned_indecies.append(next_index + 1)

                # banned_indecies.append(prev_index + 1)
                # banned_indecies.append(prev_index)
                # banned_indecies.append(prev_index + 1)

                # for _ in range(10):
                #     random_index = random.randint(5, 20)
                #     if random_index not in banned_indecies:
                #         break
                
                # target_char = full_alpha[random_index]
                # s = s[:i] + target_char + s[i+1:]

                
        
        print(s)
        return s



a = Solution()
a.modifyString(s = "?zs")
a.modifyString(s = "ubv?w")
a.modifyString(s = "j?qg??b")
a.modifyString(s="??yw?ipkj?")