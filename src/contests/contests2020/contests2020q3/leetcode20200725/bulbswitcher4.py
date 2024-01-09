
# first attempt - time limit exceeded
# switching to bulb2

class contests2020q4.leetcode20201017.Solution:
    def minFlips(self, target: str) -> int:
        # ones_list = target.split("0")
        # print(ones_list)
        # print(len(ones_list))

        def flip_substring(substring):
            if substring == '' or substring is None:
                return ''

            ans = ""
            for c in substring:
                if c == '1':
                    ans += '0'
                else:
                    ans += '1'
            return ans


        current_string = "0"*len(target)
        print(current_string)

        flip_count = 0

        for i in range(len(target)):
            if target[i] == '1':
                # print(f"gate one at {i}")
                if current_string[i] == '0':
                    flip_count += 1
                    current_string = current_string[:i] + flip_substring(current_string[i:])
            elif target[i] == '0':
                # print(f"gate zero at {i}")
                if current_string[i] == '1':
                    flip_count += 1
                    current_string = current_string[:i] + flip_substring(current_string[i:])
            # print(f"current string is {current_string} after {i}")
        # print(target, current_string)
        # print(f"flip count is {flip_count}")
        print(flip_count)
        return flip_count

a = contests2020q4.leetcode20201017.Solution()
# a.minFlips("10111")  # Expected 3
# a.minFlips("101")  # Expected 3
# a.minFlips("00000")  # Expected 0 
a.minFlips("001011101")  # Expected 5