board = [
"abcde", 
"fghij", 
"klmno", 
"pqrst", 
"uvwxy", 
"z"]

#U,D,L,R,!(select)

abet = "abcdefghijklmnopqrstuvwxyz"

class contests2020q4.leetcode20201017.Solution:
    def alphabetBoardPath(self, target):
        directionsStr = ""
        # directionStr += Solutin.find_letter(target[0])
        xcoor = 0
        ycoor = 0
        for char in target:
            directionsStr += contests2020q4.leetcode20201017.Solution.find_letter(self,char,ycoor,xcoor)


            aindex = abet.index(char)

            mydivmod = divmod(aindex,5)
            #print("current position is ",mydivmod)
            xcoor = mydivmod[1]
            ycoor = mydivmod[0]
        return(directionsStr)



    def find_letter(self,character,ycoor = 0,xcoor = 0,answerStr = ""):
        """x,ycoor are the current positions"""
        aindex = abet.index(character)
        # print(aindex)
        mydivmod = divmod(aindex,5)
        # print(mydivmod)
        # print(board[mydivmod[0]][mydivmod[1]])

        if ycoor < mydivmod[0]:
            while ycoor < mydivmod[0]:
                answerStr += "D"
                ycoor += 1

        elif ycoor > mydivmod[0]:
            while ycoor > mydivmod[0]:
                answerStr += "U"
                ycoor -= 1


        if xcoor < mydivmod[1]:
            while xcoor < mydivmod[1]:
                answerStr += "R"
                xcoor += 1

        elif xcoor > mydivmod[1]:
            while xcoor > mydivmod[1]:
                answerStr += "L"
                xcoor -= 1

        if character == board[ycoor][xcoor]:
            answerStr += "!"
        return(answerStr)
