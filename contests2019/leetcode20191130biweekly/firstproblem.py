class contests2020q4.leetcode20201017.Solution:
    def toHexspeak(self, num: str) -> str:
        hexnum = hex(int(num))[2:]
        for i in range(len(hexnum)):
            if hexnum[i] == '0':
                hexnum = hexnum[:i] +'O' + hexnum[i+1:]
            elif hexnum[i] == '1':
                hexnum = hexnum[:i] +'I' + hexnum[i+1:]
        print(hexnum)

        # the check
        thechars = {"A","B","C","D","E","F","I","O"}
        hexnum = hexnum.upper()
        for char in hexnum:
            if char not in thechars:
                print(char)
                return "ERROR"
            else:
                pass
        return(hexnum)




a = contests2020q4.leetcode20201017.Solution()
a.toHexspeak("747823223228")