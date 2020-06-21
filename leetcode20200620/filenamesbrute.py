from typing import List
from collections import defaultdict

# Incorrect answer on submission 1.
# Brute force time limited exceeded. Exactly why I didnt start with brute force. Switching filenames2
class Solution:
    def getFolderNames(self, names: List[str]) -> List[str]:
        """ """

        res = []

        words = defaultdict(list)

        for name in names:
            if name in res:
                for i in range(1,1000):
                    temp_str = name + '(' + str(i) +')'
                    if temp_str not in res:
                        res.append(temp_str)
                        break
            else:
                res.append(name)

        print(res)
        return res

a = Solution()
a.getFolderNames(["gta","gta(1)","gta","avalon"])
# a.getFolderNames(["onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"])
# a.getFolderNames(["kaido","kaido(1)","kaido","kaido(1)"])
