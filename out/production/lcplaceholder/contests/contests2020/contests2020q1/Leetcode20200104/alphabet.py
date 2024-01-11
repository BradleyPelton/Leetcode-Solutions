
class contests2020q4.leetcode20201017.Solution:
    def freqAlphabets(self, s: str) -> str:
        alphadict = {'a':'1','b':'2','c':'3','d':'4','e':'5','f':'6','g':'7','h':'8',
        'i':'9','j':'10#','k':'11#','l':'12#','m':'13#','n':'14#','o':'15#','p':'16#','q':'17#',
        'r':'18#','s':'19#','t':'20#','u':'21#','v':'22#','w':'23#','x':'24#','y':'25#','z':'26#'
        }

        alpha2 = dict([(value, key) for key, value in alphadict.items()])

        # print(alpha2)


        pretty = []

        for i in range(len(s)-2):
            try:
                if s[i+2] == '#':
                    pretty.append(s[i]+s[i+1]+s[i+2])
                elif s[i+1] == '#':
                    pass
                elif s[i] == '#':
                    pass
                else:
                    pretty.append(s[i])
            except IndexError:
                pass
        
        
        if s[-2] == '#':
            pretty.append(s[-1])
        elif s[-1] == '#':
            pass
        else:
            pretty.append(s[-2])
            pretty.append(s[-1])       
                 
        # if '#' in s[-2]+s[-1]:
        #     pass
        # else:
        #     pretty.append(s[-2])
        #     pretty.append(s[-1])
        print(pretty)


        res = ''
        for char in pretty:
            # print(char,alpha2[char])
            res = res + alpha2[char]
        print(res)
        return(res)



a = contests2020q4.leetcode20201017.Solution()
# a.freqAlphabets("10#11#12")
# a.freqAlphabets("1326#")
# a.freqAlphabets("25#")
a.freqAlphabets("26#11#418#5")
# a.freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#")





