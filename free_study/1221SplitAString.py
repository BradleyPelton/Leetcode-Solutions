## Accepted after first attempt. this brought up an interesting subject: "Avoid using += for string
# concatenation".

### GOOGLES REASONING FOR AVOIDING STRING +=
# Since strings are immutable, this creates unnecessary temporary objects and results
# in quadratic rather than linear running time



### BELOW ARE BOTH SOLUTIONS USINg EITHER METHOD. 



# class Solution:
#     def balancedStringSplit(self, s: str) -> int:
#         """ """

#         total_count = 0

#         current_list = []
#         for i in range(len(s)):
#             current_list.append(s[i])

#             L_count = current_list.count("L")
#             R_count = current_list.count("R")

#             if L_count == R_count:
#                 # print(f"found a working string, {current_list}")
#                 total_count += 1
#                 current_list = []

#         # print(total_count)
#         return total_count

# class Solution:
#     def balancedStringSplit(self, s: str) -> int:
#         """ """

#         total_count = 0

#         current_string = ''
#         for i in range(len(s)):
#             current_string += s[i]

#             L_count = current_string.count("L")
#             R_count = current_string.count("R")

#             if L_count == R_count:
#                 # print(f"found a working string, {current_list}")
#                 total_count += 1
#                 current_string = []

#         # print(total_count)
#         return total_count




a = Solution()
a.balancedStringSplit(s = "RLRRLLRLRL")
a.balancedStringSplit(s = "RLLLLRRRLR")
a.balancedStringSplit(s = "LLLLRRRR")