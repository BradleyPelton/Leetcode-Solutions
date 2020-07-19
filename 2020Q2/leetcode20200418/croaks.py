from collections import Counter
# First submission failed due to assertion error, I miscalculated the edge case INVALID CROAK
# Second submission Timed Out, moving to croaks2
class Solution:
    def minNumberOfFrogs(self, croakOfFrogs: str) -> int:
        """ """
        croak_counter = dict(Counter(croakOfFrogs))
        # print(croak_counter)
        c_list = [val for key, val in croak_counter.items()]
        if len(set(c_list)) > 1:
            print("INVALID CROAKOFFROGS")
            return -1


        frogs = []
        # frog[i] = [i, 'cro']

        current_frog_count = 0
        for i in range(len(croakOfFrogs)):
            if croakOfFrogs[i] == 'c':
                for frog in frogs:
                    if frog[1] == '':
                        frog[1] = 'c'
                        break
                else:   
                    # create a new frog
                    current_frog_count += 1
                    frogs.append([current_frog_count, 'c'])
            elif croakOfFrogs[i] == 'r':
                for frog in frogs:
                    if frog[1] == 'c':
                        frog[1] = 'cr'
                        break
                else:
                    print("FOUND AN INVALID CROAK")
                    return -1
            elif croakOfFrogs[i] == 'o':
                for frog in frogs:
                    if frog[1] == 'cr':
                        frog[1] = 'cro'
                        break
                else:
                    print("FOUND AN INVALID CROAK")
                    return -1
            elif croakOfFrogs[i] == 'a':
                for frog in frogs:
                    if frog[1] == 'cro':
                        frog[1] = 'croa'
                        break
                else:
                    print("FOUND AN INVALID CROAK")
                    return -1
            elif croakOfFrogs[i] == 'k':
                for frog in frogs:
                    if frog[1] == 'croa':
                        # add the k, then the frog finished croaking, reset forg
                        frog[1] = ''
                        break
                else:
                    print("FOUND AN INVALID CROAK")
                    return -1
        # assert every frog finished croaking
        assert len(list(set([frog[1] for frog in frogs]))) == 1

        print(len(frogs))
        return(len(frogs))





a = Solution()
# a.minNumberOfFrogs('croakcroak')
# a.minNumberOfFrogs('crcoakroak')
# a.minNumberOfFrogs('croakcrook')
# a.minNumberOfFrogs('croakcroa')
# a.minNumberOfFrogs("aoocrrackk")