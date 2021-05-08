from collections import Counter
class contests2020q4.leetcode20201017.Solution:
    def maxDiff(self, num: int) -> int:
        # FIND THE SMALLEST NUM AFTER REPLACEMENT
        # FIND THE LARGEST NUM AFTER REPLACEMENT
        # RETURN THEIR DIFFERENCE
        num_as_str = str(num)

        # EDGE CASES
        if len(Counter(num_as_str)) == 1:
            print("num conists of all the same digits, return 9999-1111")
            nines = '9'*len(num_as_str)
            ones = '1'*len(num_as_str)
            answer = int(nines) - int(ones)
            print(answer)
            return(answer)

        if num_as_str == '1' + '0'*(len(num_as_str)-1):
            answer = '8' + '0'*(len(num_as_str)-1)
            ans = int(answer)
            print(ans)
            return(ans)

        def make_smaller(num):
            num_as_str = str(num)
            # print(num_as_str)

            if num_as_str[0] == '1':
                # find the first digit not equal to 0 and replace it with 0
                for digit in num_as_str[1:]:
                    if digit != '0':
                        # print(digit)
                        first_non_zero = digit
                        # print(digit)
                        break
                num_after_smallest = num_as_str.replace(str(first_non_zero), '0')
                # print(num_after_smallest)
            else:
                # if the first digit not 1, replace it with 1
                first_digit = num_as_str[0]
                num_after_smallest = num_as_str.replace(str(first_digit), '1')
                # print(num_after_smallest)
            return(num_after_smallest)

        def make_larger(num):
            num_as_str = str(num)
            # print(num_as_str)
            for digit in num_as_str:
                if digit != '9':
                    first_non_nine = digit
                    break

            num_after_largest = num_as_str.replace(str(first_non_nine), '9')
            return(num_after_largest)

        print(f"number before is {num}")
        first_smallest = make_smaller(num)
        first_largest = make_larger(num)

        new_num = int(first_largest) - int(first_smallest)
        print(new_num)
        return(new_num)

        # print(f"FINAL ANSWER {second_largest} - {second_smallest}")
        # print(int(second_largest)-int(second_smallest))
        # return(int(second_largest)-int(second_smallest))



a = contests2020q4.leetcode20201017.Solution()
# a.maxDiff(123456)
a.maxDiff(10000)

