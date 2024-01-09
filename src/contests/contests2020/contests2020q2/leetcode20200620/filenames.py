from typing import List
from collections import defaultdict

# Incorrect answer on submission 1.
class contests2020q4.leetcode20201017.Solution:
    def getFolderNames(self, names: List[str]) -> List[str]:
        """ """

        res = []

        words = defaultdict(list)

        for name in names:
            if name[-1] == ')' and name[-3] == '(':
                real_name = name[:-3]
                # weird edge case 'kaido(1)(1)'
                if int(name[-2]) in words[real_name]:
                    # someone tried to manually name a file using (k) and messed up
                    real_name = name

            else:
                real_name = name
            print(name, real_name)


            if words[real_name] == []:
                res.append(name)
                words[real_name].append(0)
            else:
                # Unused number was requested as filename
                if real_name != name and int(name[-2]) not in words[real_name]:
                    words[real_name].append(int(name[-2]))
                    res.append(name)
                    continue

                # We need to find the smallest number, k, such that filename(k) is unique
                current_length = len(words[real_name])
                if words[real_name] == list(range(current_length)):
                    # if the naming is conventional (no stupid cases where people name with ())
                    new_num = current_length
                    res.append(name + '(' + str(new_num) + ')')
                    words[real_name].append(new_num)
                else:
                    # stupid case where someone manually used the name including (k)
                    for i in range(current_length):
                        if i not in words[real_name]:
                            new_num = i
                            res.append(name + '(' + str(new_num) + ')')
                            words[real_name].append(new_num)
                            break
        
        print(res)
        return res

a = contests2020q4.leetcode20201017.Solution()
# a.getFolderNames(["gta","gta(1)","gta","avalon"])
# a.getFolderNames(["onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"])
a.getFolderNames(["kaido","kaido(1)","kaido","kaido(1)"])
