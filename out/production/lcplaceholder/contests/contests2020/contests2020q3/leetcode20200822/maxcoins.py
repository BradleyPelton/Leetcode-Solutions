from typing import List
from collections import deque

## Accepted after 15 mintues after 2 attempts.
## Slopily forgot to change for _ in range(100) to  while loop or a for loop with adequate number
## of iterants. wasted 5 minutes debugging why my solution was wrong but it wasnt


class contests2020q4.leetcode20201017.Solution:
    def maxCoins(self, piles: List[int]) -> int:
        """ """
        piles.sort()
        print(piles)
        curr_piles = deque(piles[:])

        ans = 0
        for _ in range(len(piles)):
            try:
                lowest = curr_piles.popleft()
                highest = curr_piles.pop()
                next_highest = curr_piles.pop()
                ans += next_highest
                # print(lowest,next_highest,highest)
            except IndexError:
                break
        print(ans)
        return ans

            





a = contests2020q4.leetcode20201017.Solution()
# a.maxCoins(piles = [2,4,1,2,7,8])
# a.maxCoins(piles = [2,4,5])
# a.maxCoins(piles = [9,8,7,6,5,1,2,3,4])
a.maxCoins(piles=[871,817,329,543,660,674,378,748,229,451,551,570,259,66,969,705,261,725,666,867,713,551,171,854,656,680,315,746,411,692,931,48,169,449,816,666,611,785,626,605,405,334,502,398,292,117,968,911,889,213,882,982,169,803,717,477,603,355,574,991,612,785,685,295,898,634,372,155,406,813,760,777,308,850,547,197,4,834,987,578,863,457,619,372,859,525,274,636,284,553,698,578,918,488,354,801,655,953,212,565,852,740,995,332,497,330,375,554,992,666,795,638,923,740,796,151,702,316,397,469,10,584,144,851,192,94,641,947,133,585,897,742,598,396,888,768,255,336,710,531,912,958,550,619,289,942,663,59,993,84,654,224,663,981,71,541,211,896,755,253,853,27,377,532,122,356,684,820,792,32,351,293,380,704,185,765,12,765,922,713,157,307,895,796,583,983,837,935,598,751,69,634,679,862,894,564,375,450,977,621,557,25,656,438,572,414,832,981,535,193,547,520,180,138,790,149,109,250,270,676,567,485,999,480,274,758,419,140,104,815,842,877,160,985,42,197,436,204,575,613,220,590,659,15,510,233,238,552,999,730,699,311,167,59,782,746,42,604,639,468,679,946,948,978,143,906,513,770,582,585,734,392,146,587,59,888,661,685,480,13,644,58,994,233,582,700,180,294,374,399,984,262,60,243,718,790,265,681,957,727,90,238,531,340,511,895,855,455,42,256,880,934,421,565,569,571,905,665,616,718,23,912,446,774,368,216,566,999,994,877,528,237,893,635,650,273,968,857,405,408,536,181,442,883,255,935,709,580,13,749,50,386,833,549,300,424,167,331,631,282,60,375,459,783,839,846,836,822,205,724,514,131,508,199,998,67,245,426,464,46,380,508,295,977,741,544,588,931,262,53,15,90,821,795,56,124,729,585,535,623,919,319,939,811,79,178,676,147,933,679,501,664,252,536,266,550,406,617,835,905,83,380,770,959,58,261,428,857,669,902,197,953,52,234,649,717,576,848,591,286,49,526,430,474,172,286,409,262,781,880,446,985,857,926,802,250,991,95,411,340,45,34,598,650,659,575,644,356,193,256,701,650,149,746,811,2,415,93,321,609,461,425,91,976,404,699,452,513,905,514,650,685,815,198,638,269,400,69,366,996,978,162,368,418,949,500,632,786,102,968,408,814,322,54,671,634,874,332,717,334,297,20,539,783,41,333,307,61,612,1000,359,189,74,632,131,287,615,101,435,564,911,582,70,422,167,873,182,680,356,214,902,683,906,297,333,540,455,174,356,754,840,416,5,686,59,961,535,942,446,668,660,311,246,389,320,235,718,3,915,128,860,809,587,948,652,217,989,28,41,6,962,70,719,950,816,374,931,901,968,647,65,846,15,128,65,942,663,378,610,966,280,307,781,910,199,779,748,971,168,761,698,705,396,511,505,37,780,609,231,366,552,244,975,749,628,768,296,799,788,566,358,543,833,58,877,162,972,539,698,850,544,64,705,497,636,616,304,644,989,330,968,767,248,684,692,619,212,341,528,106,829,590,160,674,206,772,616,4,509,130,936,739,771,253,46,458,739,929,391,899,531,459,245,859,563,878,793,834,33,439,296,584,547,562,83,16,498,52,715,158,994,369,741,992,458,95,409,538,389,201,130,31,111])
# expected 167630