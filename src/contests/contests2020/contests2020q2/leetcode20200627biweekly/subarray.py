from typing import List

## FIrst attemtp rejected, edge case [1,0,0,0,0]
# Accepted after second attempt, forgot to handle the edge case where candidate_lengths was empty

# I liked this problem, but I'm sure my approach was barbaric. 85 lines is pretty long.


class contests2020q4.leetcode20201017.Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        if nums.count(0) == 0:
            print("all ones edge case")
            return len(nums) - 1
        if nums.count(1) == 0:
            print("all zeroes edge case")
            return 0

        def all_one_substrings(binlist):
            """Return a list of tuples of the form (i,j) where [i:j] is a sublist of all ones.
            EXAMPLE INPUT: [1,1,0,0,1,1,1,0,1]
            EXAMPLE OUTPUT: [(0, 2), (4, 7), (8, 9)]
            """
            all_substrings = []
            current_substring = tuple()

            for i in range(len(binlist)):
                if binlist[i] == 1:
                    if current_substring == tuple():
                        # create a new substring with start equal to i
                        current_substring = (i,)
                elif binlist[i] == 0:
                    if current_substring == tuple():
                        # We arent working within a ones substring
                        pass
                    else:
                        # Our ones substring ended, add it to the list of substrings to return
                        current_substring = (current_substring[0], i)
                        all_substrings.append(current_substring)
                        current_substring = tuple()
            if current_substring != tuple():
                # if the last substring didnt end, end it
                current_substring = (current_substring[0], len(binlist))
                all_substrings.append(current_substring)

            return all_substrings

        one_subs = all_one_substrings(nums)

        # find the largest length of '1' substrings before we remove any elements
        longest_before_removing = max([j - i for (i, j) in one_subs])
        # print(f"longest length before removing is {longest_before_removing}")

        candidate_lengths = []

        for i in range(len(one_subs)-1):
            # Iterate through the list of substrings and find the substrings that are separated by a zero
            left_substring = one_subs[i]
            right_substring = one_subs[i+1]
            # print(left_substring, right_substring)

            length_of_left = left_substring[1] - left_substring[0]
            length_of_right = right_substring[1] - right_substring[0]
            # print(length_of_left, length_of_right)

            if length_of_left + length_of_right > longest_before_removing:
                # There is no need to consider substrings that arent together longer than the longest_before_removing value
                if right_substring[0] - left_substring[1] == 1:
                    # if there is only a single gap between the left and right substring
                    if nums[left_substring[1]] == 0:
                        # if the gap between the substrings is a zero. In hindsight, it has to be a zero
                        # because otherwise left+right would be a one substring. This step was unnecessary
                        candidate_lengths.append(length_of_left + length_of_right)

        if candidate_lengths == []:
            print("couldnt find any candidate lengths, the answer is longest_before_removing")
            return longest_before_removing

        answer = max(candidate_lengths)
        return answer


a = contests2020q4.leetcode20201017.Solution()
a.longestSubarray([1,1,0,1])
a.longestSubarray([0,1,1,1,0,1,1,0,1])
a.longestSubarray([1,1,1])
a.longestSubarray([1,1,0,0,1,1,1,0,1])
a.longestSubarray([1,0,0,0,0])