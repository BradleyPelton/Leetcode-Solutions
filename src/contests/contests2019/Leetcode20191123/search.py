from typing import List

class contests2020q4.leetcode20201017.Solution:
    def suggestedProducts(self, products: List[str], searchWord: str) -> List[List[str]]:
        

        def search(list,keyword,n):
            key = keyword[0:n]
            copylist = list.copy()
            # print(key,copylist)

            for word in list:
                if word[0:n] != key:
                    # print(word[0:n+1],key,"ARE NOT EQUAL")
                    copylist.remove(word)
            return(copylist)


        def choplist(mylist,n):
            """returns the first n items in mylist, LEXIOGRAPHICAL"""
            if not mylist:
                return([])
            mylist.sort()
            if len(mylist) < n:
                return(mylist)
            else:
                return(mylist[:n+1])
    
        for i in range(1,len(searchWord)+1):
            yield(choplist(search(products,searchWord,i),2))





a = contests2020q4.leetcode20201017.Solution()
a.suggestedProducts(["havanna"],"tatiana")