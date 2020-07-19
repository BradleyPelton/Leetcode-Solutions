from typing import List

# time limit exceeded. Switching to XOR2.py
class Solution:
    def countTriplets(self, arr: List[int]) -> int:
        """XOR IS (a | b), meaning a or b BUT NOT BOTH A AND B"""
        def bitwise_list(sublist: list):
            """ return the value of running bitwise or over entire list"""
            if len(sublist) == 0:
                return "WAS GIVEN AN EMPTY LIST"
            elif len(sublist) == 1:
                return sublist[0]

            val = sublist[0] ^ sublist[1]
            for ele in sublist[2:]:
                val ^= ele
            return val

        length = len(arr)

        running_count = 0
        for i in range(length):
            for j in range(i+1, length):
                ij = bitwise_list(arr[i:j])

                for k in range(j, length):
                    # print(arr[i],arr[j],arr[k])
                    # print(i,j,k)
                    jk = bitwise_list(arr[j:k+1])
                    if ij == jk:
                        running_count += 1
                        print(ij)
        # print(running_count)
        return running_count


a = Solution()
# a.countTriplets([2,3,1,6,7])
# a.countTriplets([1,2,3,4,5,6])
# a.countTriplets([1,1,1,1,1])
# a.countTriplets([2,3])
# a.countTriplets([1,3,5,7,9])
a.countTriplets([7,11,12,9,5,2,7,17,22])
