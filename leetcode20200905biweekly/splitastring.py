
### Accepted after third attempt
### This was an interesting problem. The edge (all zeroes) was harder to think of a solution than
### the typical case where we just split the stirng up into different parts
### I failed to find an equation for zero_ans , but I created a tiny recursive list to create one


class Solution:
    def numWays(self, s: str) -> int:
        

        total_ones = s.count("1")
        # print(total_ones)

        if total_ones % 3 != 0:
            print("not possible")
            return 0
        if total_ones == 0:
            zero_list = [3,6,10]
            for e in range(len(s)):
                new_zero = zero_list[-1] + (zero_list[-1] - zero_list[-2] + 1)
                zero_list.append(new_zero)
            # print(zero_list)
            zero_ans = zero_list[len(s) - 4]
            zero_ans = zero_ans % (10**9 + 7)
            print(f"zero ans is {zero_ans}")
            return zero_ans

        ones_so_far = 0
        first_partition = 0
        for i in range(len(s)):
            if s[i] == '1':
                ones_so_far += 1

            if ones_so_far == total_ones/3:
                first_partition = i
            
            if ones_so_far == 2*total_ones/3:
                second_partition = i
                break
        
        # print(first_partition)
        first_substring = s[0:first_partition+1]
        # print(first_substring)

        middle_substring = s[first_partition+1:second_partition+1]
        # print(middle_substring)

        final_substring = s[second_partition+1:]
        # print(final_substring)

        assert first_substring + middle_substring + final_substring == s

        # FIRST BUNCH OF ZEROES
        number_of_zeroes_between_one_and_middle = 0
        for j in range(len(first_substring)-1,-1,-1):
            # print(first_substring[j])
            if first_substring[j] == '0':
                number_of_zeroes_between_one_and_middle += 1
            else:
                break
        # print(number_of_zeroes_between_one_and_middle)

        for k in range(len(middle_substring)):
            if middle_substring[k] == '0':
                number_of_zeroes_between_one_and_middle += 1
            else:
                break
        # print(number_of_zeroes_between_one_and_middle)


        # SECOND BUNCH OF ZEROES
        number_of_zeroes_between_middle_and_final = 0
        for j in range(len(middle_substring)-1,-1,-1):
            # print(first_substring[j])
            if middle_substring[j] == '0':
                number_of_zeroes_between_middle_and_final += 1
            else:
                break
        # print(number_of_zeroes_between_middle_and_final)

        for k in range(len(final_substring)):
            if final_substring[k] == '0':
                number_of_zeroes_between_middle_and_final += 1
            else:
                break
        # print(number_of_zeroes_between_middle_and_final)


        ans = (number_of_zeroes_between_one_and_middle + 1) * (number_of_zeroes_between_middle_and_final +1)
        ans = ans % (10**9 + 7)

        print(ans)
        return ans

a = Solution()
# a.numWays(s = "10101")  # Expected 4
# a.numWays(s = "1001")  # Expected 0
a.numWays(s = "0000")  # Expected 3
a.numWays(s = "00000")  # Expected 3
a.numWays(s = "000000")  # Expected 3
a.numWays(s = "0000000")  # Expected 3
a.numWays(s = "00000000")  # Expected 3
a.numWays(s = "000000000")  # Expected 3
# a.numWays(s = "000000000000000000000000000000000000")  # Expected 3
# a.numWays(s = "100100010100110")  # Expected 12