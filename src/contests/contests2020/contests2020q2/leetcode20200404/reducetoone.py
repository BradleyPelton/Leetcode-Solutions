
# first submission failed case = s = "1111011110000011100000110001011011110010111001010111110001"
# returned 82 when answer was 85

# INTERESTING. SOLUTION WAS ACCEPTED AFTER CHANGING LINE 18 
# FROM decimal /= 2 to decimal //= 2
class contests2020q4.leetcode20201017.Solution:
    def numSteps(self, s: str) -> int:
        
        decimal = int(s, 2)
        # print(decimal)

        steps = 0
        while decimal > 1:
            if decimal % 2 == 1:
                decimal += 1
                steps += 1
            else:
                decimal //= 2
                steps += 1
            print(decimal)
        print(steps)
        return(steps)


a = contests2020q4.leetcode20201017.Solution()
# a.numSteps('1101')
# a.numSteps('10')
# a.numSteps('1')
a.numSteps("1111011110000011100000110001011011110010111001010111110001")