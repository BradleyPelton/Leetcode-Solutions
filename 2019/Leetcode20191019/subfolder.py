class Solution:
    def removeSubfolders(self, folder: List[str]) -> List[str]:
        myList = []
        for box in folder:
            box = box.split("/")
            for obj in box:
                if obj:
                    continue
                else:
                    box.remove(obj)
            myList.append(box)
        # print(myList)

        myList.sort(key=lambda x: x[0])         #SORT ALL FILES INTO ALPHABETICAL ORDER VIA THERE ROOT DIRECTORY
        # print(myList)

        copyList = myList[:]

        newList = [] 
        try:
            for i in range(len(myList)):
                j = 1
                while myList[i][0] == myList[i+j][0]: 
                    for k in range(myList[i]]):
                        if myList[i][k] != myList[i+j][k]:
                            newList.append(myList[i+j])
                    j  += 1
        except IndexError:
            pass

        answerList = []
        for obj in copyList:
            myStr = "/" + "/".join(obj)
            answerList.append(myStr)
        print(answerList)
