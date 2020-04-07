from typing import List

# THIS WAS AN ACCEPTED ANSWER. OTHER BRUTE FORCE ATTEMPTS DID NOT WORK. FUCK THIS PROBLEM
class Solution:
    def replaceElements(self, arr: List[int]) -> List[int]:
        answer = []
        copy = arr[:]
        # print(arr)
        copy.sort(reverse=True)
        # print(arr)

        backwards_arr = arr[::-1]


        print(copy)
        for i in range(len(copy)):
            # iterating over sorted array
            ith_index = len(copy) - backwards_arr.index(copy[i])-1 # FIND THE LAST OCCURENCE OF THE MAX
            # print(answer)
            if ith_index > len(answer):
                for _ in range(ith_index-len(answer)):
                    answer.append(copy[i])

            if len(answer) >= len(arr):
                print(answer)
                return(answer)
        answer.append(-1)
        print(answer)
        return(answer)

a = Solution()
a.replaceElements([17,18,5,4,6,1])