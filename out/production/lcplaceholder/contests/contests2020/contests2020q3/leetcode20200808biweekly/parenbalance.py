
# My logic messed up. I liked this problem, but it was pretty difficult 


class contests2020q4.leetcode20201017.Solution:
    def minInsertions(self, s: str) -> int:
        # First observation, it doesnt matter where the added parens are added to balance
        

        # starting_lefts = s.count("(")
        # starting_rights = len(s) - starting_lefts
        # print(f"starting lefts = {starting_lefts}, starting_rights = {starting_rights}")

        # if starting_lefts*2 < starting_rights:
        #     number_of_lefts_needed = starting_rights - (starting_lefts*2)
        #     print(f"need lefts, {number_of_lefts_needed}")
        # elif starting_lefts*2 > starting_rights:
        #     number_of_rights_needed = starting_lefts*2 - starting_rights
        #     print(f"need rights, {number_of_rights_needed}")
        # else:
        #     print("balanced, as all things should be")

        ans = 0

        left_surplus = 0
        right_surplus = 0
        for i in range(len(s)):

            if s[i] == '(':
                left_surplus += 1
            else:
                right_surplus += 1

            # add an extra left 
            if right_surplus > 0 and left_surplus == 0:
                ans += 1
                left_surplus += 1
            
            if left_surplus > 0 and right_surplus > 1:
                left_surplus -= 1
                right_surplus -= 2

        
        print(f"surpluses after first pass {left_surplus}, {right_surplus}")
        print(f"ans before accounting for extras {ans}")

        # account for extra lefts at the end
        if left_surplus > 0:
            print(f"found left surplus at the end, {left_surplus}. Adding {left_surplus*2}")
            ans += (left_surplus*2 - right_surplus)
        
        # account for extra rights at the end
        elif right_surplus == 1:
            print("single right left, adding left and right")
            ans += 2
        elif right_surplus == 2:
            print("single left being added")
            ans += 1
        elif right_surplus > 2:
            print("bannana")
            if right_surplus % 2 == 1:
                # have to add an extra right 
                ans += 1
            assert right_surplus % 2 == 0
            # adding x/2 lefts 
            ans += right_surplus//2
        

        print(ans)
        return ans


a = contests2020q4.leetcode20201017.Solution()
a.minInsertions(s = "(()))") # 1
a.minInsertions(s = "())") # 0
a.minInsertions(s = "))())(") # 3
# a.minInsertions("((((((") # expected 12
# a.minInsertions(")))))))") #xpected 5