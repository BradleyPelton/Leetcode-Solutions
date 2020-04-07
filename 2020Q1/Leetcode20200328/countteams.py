from typing import List

# accepted second try.
# I'm really surprised brute force worked here
# I guess its not brute force since I split the requirements on i<j<k<n
# and then ran another if statement for rating[i] < rating[j] < rating[k]
# Brings up a great question. How does python evaluate multiple conditionals?
# There might not have even been a speed increase if it the same as JAVASCRIPT
# && or || (evaluate 1, if fail, stop, else evaluate 2)
class Solution:
    def numTeams(self, rating: List[int]) -> int:
        """
        choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
        A team is valid if:  (rating[i] < rating[j] < rating[k]) or 
        (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
        """

        # [2,5,3,4,1]
        # [2(0),5(1),3(2),4(3),1(4)]
        ans = 0
        for i in range(len(rating)):
            for j in range(len(rating)):
                for k in range(len(rating)):
                    if (i < j and j < k and k < len(rating)):
                        if (rating[i] < rating[j] and rating[j] < rating[k]):
                            # print(rating[i],rating[j],rating[k])
                            ans += 1
                        if (rating[i] > rating[j] and rating[j] > rating[k]):
                            # print(rating[i],rating[j],rating[k])
                            ans += 1
        print(ans)
        return(ans)


a = Solution()
a.numTeams([2,5,3,4,1])

            