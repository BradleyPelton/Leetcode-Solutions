from typing import List

### solved after 21 minutes
### I really amazed myself with this. 50 lines of a decently complex logic WORKED FLAWLESSLY 
### All test cases passed without editing a single line. I wrote this perfectly the first time without having to edit anything..
### Super proud. Amazing feeling

class Solution:
    def getMaxLen(self, nums: List[int]) -> int:
        
        curr_arr = []
        nonzero_subarrays= []
        for i in range(len(nums)):
            if nums[i] == 0:
                nonzero_subarrays.append(curr_arr)
                curr_arr = []
            else:
                curr_arr.append(nums[i])
        nonzero_subarrays.append(curr_arr)
        
        # print(nonzero_subarrays)

        max_lengths = []

        for subarr in nonzero_subarrays:
            number_of_negatives = 0
            number_of_positives = 0
            first_negative = -1
            last_negative = 0
            for j in range(len(subarr)):
                if subarr[j] < 0:
                    if first_negative != -1:
                        number_of_negatives += 1
                        last_negative = j
                    else:
                        number_of_negatives +=1
                        first_negative = j
                        last_negative = j
                else:
                    number_of_positives += 1

            # print(f"for subarr, {subarr}, number of pos is {number_of_positives}, number of negatives is {number_of_negatives}")
            # print(f"first negative is {first_negative}, last negative is {last_negative}")

            # If no negatives
            if first_negative == -1:
                max_lengths.append(len(subarr))
                continue
            
            # If even number of negatives
            if number_of_negatives % 2 == 0:
                max_lengths.append(len(subarr))
                continue

            # If odd number of negatives 
            # print("reached cut logic")
            first_cut = subarr[first_negative+1:]
            last_cut = subarr[:last_negative]

            if len(first_cut) > len(last_cut):
                max_lengths.append(len(first_cut))
                continue
            else:
                max_lengths.append(len(last_cut))
                continue
        
        print(max_lengths)
        ans = max(max_lengths)
        # print(ans)
        return ans
            


a = Solution()
# a.getMaxLen(nums = [1,-2,-3,4])  # Expected 4
# a.getMaxLen(nums = [0,1,-2,-3,-4])  # Expected 3
# a.getMaxLen(nums = [-1,-2,-3,0,1])  # Expected 2
# a.getMaxLen(nums = [-1,2])  # Expected 1
# a.getMaxLen(nums = [1,2,3,5,-6,4,0,10])  # Expected 4