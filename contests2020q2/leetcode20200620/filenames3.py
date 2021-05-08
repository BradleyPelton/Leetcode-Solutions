from typing import List
from collections import defaultdict

# Incorrect answer on submission 1.
# 3rd attempt incorrect answer.
class contests2020q4.leetcode20201017.Solution:
    def getFolderNames(self, names: List[str]) -> List[str]:
        """ """

        res = []

        suffix_dict = defaultdict(list)

        for name in names:
            split_name = name.split('(', 1)
            real_name = split_name[0]
            everthing_else = name[len(real_name):]
            print(name, real_name, everthing_else)

            if suffix_dict[real_name] == []:
                res.append(real_name)
                suffix_dict[real_name].append(-1)

            elif everthing_else in suffix_dict[real_name]:
                # case where suffix is already in the suffix dict
                suffix_dict[name] = 0

            else:
                print(f"current suffix is {suffix_dict[real_name]}")
                # case where suffic not in suffix dict
                current_length = len(suffix_dict[real_name])
                for i in range(1, current_length):
                    temp_str = '(' + str(i) + ')'
                    if temp_str not in suffix_dict[real_name]:
                        res.append(real_name + temp_str)
                        suffix_dict[real_name].append(temp_str)
                        break

        print(res)


a = contests2020q4.leetcode20201017.Solution()
a.getFolderNames(["gta","gta(1)","gta","avalon"])
# # a.getFolderNames(["onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"])
# # a.getFolderNames(["kaido","kaido(1)","kaido","kaido(1)"])
# a.getFolderNames(["kingston(0)","kingston","kingston"])