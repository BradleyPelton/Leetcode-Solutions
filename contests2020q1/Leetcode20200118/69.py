class contests2020q4.leetcode20201017.Solution:
    def maximum69Number (self, num: int) -> int:
        strnum = str(num)
        print("string num before",strnum)

        if '6' not in strnum:
            return(strnum)
        if '6' not in strnum[:len(strnum)-1]:
            return(     strnum[:len(strnum)-1] +'9')
        for i in range(len(strnum)):
            if strnum[i] == '6':
                strnum = strnum[:i] + '9' +strnum[i+1:]
                break
        return(strnum)