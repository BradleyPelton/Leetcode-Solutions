class Solution(object):
    def largestValsFromLabels(self, values, labels, num_wanted, use_limit):

        oxford = dict()
        for i in range(len(values)):
            if values[i] in oxford:
                oxford[values[i]] = max(labels[i],oxford[values[i]])
            else:
                oxford[values[i]] = labels[i]
        #print(oxford)

        myList = list(oxford.keys())
        myList.sort(reverse =True)
        #print(myList)

        List2 = []
        temp_wanted = num_wanted
        for i in range(len(myList)):
            #print(myList[i])
            if oxford[myList[i]] <= use_limit:
                List2.append(myList[i])
                temp_wanted -= 1
            if temp_wanted == 0:
                break
        #print(List2)
        return(sum(List2))
