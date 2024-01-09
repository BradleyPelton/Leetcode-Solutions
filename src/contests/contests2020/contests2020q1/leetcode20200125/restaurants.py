from typing import List
class contests2020q4.leetcode20201017.Solution:
    def filterRestaurants(self, restaurants: List[List[int]], veganFriendly: int, maxPrice: int, maxDistance: int) -> List[int]:
        # restaurants[i] = [idi, ratingi, veganFriendlyi, pricei, distancei]

        def vfFilter(list1,veganFriendly):
            copy = list1[:]
            if veganFriendly == 0:
                return(list1)
            for rest in list1:
                if rest[2] == veganFriendly:
                    pass
                else:
                    copy.remove(rest)
            return(copy)
        
        def priceFilter(list1, maxPrice):
            copy = list1[:]
            for rest in list1:
                if rest[3] > maxPrice:
                    copy.remove(rest)
            return(copy)

        def distanceFilter(list1, maxDistance):
            copy = list1[:]
            for obj in list1:
                if obj[4] > maxDistance:
                    copy.remove(obj)
            return(copy)

        def rankFilter(list1):
            list1.sort(key = lambda x:x[1])
            list1.reverse()
            return(list1)
        







        matches_conditions = vfFilter(restaurants, veganFriendly)
        # print(matches_conditions)
        matches_conditions = priceFilter(matches_conditions, maxPrice)
        # print(matches_conditions)
        matches_conditions = distanceFilter(matches_conditions, maxDistance)
        # print(matches_conditions)
        matches_conditions = rankFilter(matches_conditions)

        ans = []
        print(matches_conditions)
        for obj in matches_conditions:
            ans.append(obj[0])
        print(ans)
        return(ans)

a = contests2020q4.leetcode20201017.Solution()
# [[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]]
# a.filterRestaurants([[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]],0,50,10)

a.filterRestaurants([[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]],0,30,3)

# [[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]]
# 0 
# 30
# 3
# 3 SHOULD FAIL BECAUSE VEGAN?NO, 