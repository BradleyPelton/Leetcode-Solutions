
# Accepted after 10 mintues on first try. Soemhow this was easier than the easy problem.

class Solution:
    def findKthBit(self, n: int, k: int) -> str:
        
        def invert(s):
            new_s = ''
            for char in s:
                if char == '0':
                    new_s += '1'
                else:
                    new_s += '0'
            return new_s

        def reverse(s):
            new_s = s[::-1]
            return new_s
        


        sequences = ["0"]
        for i in range(1, n+1):
            ith_seq = sequences[i-1] + "1" + reverse(invert(sequences[i-1]))
            sequences.append(ith_seq)
            # print(sequences)

        ans = sequences[n][k-1]
        print(ans)
        return ans


a = Solution()
# a.findKthBit(n = 3, k = 1)
# a.findKthBit(n = 4, k = 11)
# a.findKthBit(n = 1, k = 1)
# a.findKthBit(n = 2, k = 3)