
class contests2020q4.leetcode20201017.Solution:
    def encode(self, num: int) -> str:   
        def convertToZeros(a):
            b = "0"*len(a)
            return(b)
        # print(convertToZeros("1111111"))

        def findFirstZero(a):
            """returns the index of the first zero at the end of a string"""
            for i in range(len(a)-1,-1,-1):
                if a[i] == '1':
                    continue
                elif a[i] == '0':
                    return(i)
                
        mystring = "0"
        target= 1
        while target < num:
            #ADD A DIGIT
            print("Target value is", target, ",mystring is currently", mystring)
            if "0" not in mystring:
                # print("no zero in string")
                mystring = convertToZeros(mystring) + "0"
            else:
                # The logic: find the first zero
                ind = findFirstZero(mystring)



                if ind == len(mystring)-1:
                    # print("last character of the string converted to 0")
                    if mystring == "00":
                        mystring = "01"
                    elif mystring == "0":
                        mystring = "1"
                    elif mystring == "000":
                        mystring = "001"
                    else:
                        mystring = mystring[0:len(mystring)-2] + "1"
                else:
                    # print("reached complicated logic")
                    if mystring == "01":
                        mystring = "10"
                    elif mystring == "10":
                        mystring = "11"
                    else:
                        mystring  = mystring[0:ind-1] + "1" + convertToZeros(mystring[ind+1:])
                    
            target += 1
        print(mystring)



sol = contests2020q4.leetcode20201017.Solution()
sol.encode(6)