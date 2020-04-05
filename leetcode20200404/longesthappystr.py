
# rejected. Was a nice attempt. The logic got pretty complex.
# Im satisfied with my attempt. 6 point problems can be prety challenging, especially in only 45 mins
class Solution:
    def longestDiverseString(self, a: int, b: int, c: int) -> str:

        def within_two(a,b,c):
            if a-b <= 2 and b-a <=2  and a-c <= 2 and c-a <= 2 and b-c <= 2 and c-b <=2:
                return(True)
            else:
                return(False)

        def construct_optimal_string(a,b,c):

            alphabet = [['a', a], ['b', b], ['c',c]]
            alphabet.sort(key=lambda x: x[1])
            # [('b', 0), ('a', 1), ('c', 5)]
            # print(alphabet)

            optimal_string = ''

            # while alphabet[0][1] + alphabet[1][1] + alphabet[2][1] > 0:
            for _ in range(1000):
                if within_two(alphabet[0][1], alphabet[1][1], alphabet[2][1]):
                    print("reached a trivial solution")
                    break

                # LOWER THE GREATEST COUNT AS MUCH AS POSSIBLE 
                if alphabet[-1][1] > alphabet[-2][1] + 2 and alphabet[-1][1] > 0 and alphabet[-2][1] > 0:
                    optimal_string += alphabet[-1][0]*2 + alphabet[-2][0] 
                    alphabet[-1][1] -= 2
                    alphabet[-2][1] -= 1
                    # print(optimal_string)
                    alphabet.sort(key=lambda x: x[1])
                    # print(alphabet)

                # ONE HORSE RACE CONDITION
                if alphabet[-1][1] > 0 and alphabet[-2][1] == 0 and alphabet[-3][1] == 0:
                    print("reached one horse race")
                    if optimal_string[-1] != alphabet[-1][1]:
                        if alphabet[-1][1] > 1:
                            optimal_string += alphabet[-1][0]*2

                            break
                        else:
                            optimal_string += alphabet[-1][0]
                            break
            # print(optimal_string)

            #IF WE REACHED A TRIVIAL SOLUTION
            # print(optimal_string)
            if optimal_string == '':
                optimal_string = alphabet[-1][0]*2
                alphabet[-1][1] -= 2
                alphabet.sort(key=lambda x: x[1])
            while alphabet[0][1] + alphabet[1][1] + alphabet[2][1] > 0:
                if optimal_string[-1] != alphabet[-1][0]:
                    if alphabet[-1][1] > 1:
                        optimal_string += alphabet[-1][0]*2
                        alphabet[-1][1] -=2
                        alphabet.sort(key=lambda x: x[1])
                    else: 
                        optimal_string += alphabet[-1][0]
                        alphabet[-1][1] -= 1
                        alphabet.sort(key=lambda x: x[1])
                else:
                    if alphabet[-2][1] > 1:
                        optimal_string += alphabet[-2][0]*2
                        alphabet[-2][1] -=2
                        alphabet.sort(key=lambda x: x[1])
                    else: 
                        optimal_string += alphabet[-2][0]
                        alphabet[-2][1] -= 1
                        alphabet.sort(key=lambda x: x[1])
            print(optimal_string)
            return(optimal_string)
        return(construct_optimal_string(a,b,c))


# construct_optimal_string(2,2,2)
# construct_optimal_string(2,2,1)
a = Solution()
a.longestDiverseString(1,1,7)


