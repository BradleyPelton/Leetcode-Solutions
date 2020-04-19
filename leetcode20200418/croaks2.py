# Refactor accepted first try. Beautiful refactor by converting frog strings in a list
# to storing the state(e.g. current state of frog 6 is 'cro') of a each frog in a dictionary.


class Solution:
    def minNumberOfFrogs(self, croakOfFrogs: str) -> int:
        """ """

        # Frogs are ints, if we need a new frog, increment current_frog_count
        # Were going to store the frogs in a dictionary, where the key is the last letter of their
        # croak (e.g. frog 6 has current string 'cro' thus, (6 in frogs['o']))
        frogs = dict()
        frogs['c'] = []
        frogs['r'] = []
        frogs['o'] = []
        frogs['a'] = []
        frogs['k'] = []  # STORED AT K, BUT REALISTICALLY current string is blank
        # frogs['k'] means the last letter is k, but really its just frogs that are  ready to start
        # a new croak string

        # interesting observation: It doesnt matter which frog gains a letter. FIFO and FILO works
        # for frogs
        current_frog_count = 0
        for i in range(len(croakOfFrogs)):
            if croakOfFrogs[i] == 'c':
                if len(frogs['k']) == 0:
                    # create a new frog
                    current_frog_count += 1
                    frogs['c'].append(current_frog_count)
                else:
                    pop_frog = frogs['k'].pop()
                    frogs['c'].append(pop_frog)
            elif croakOfFrogs[i] == 'r':
                if len(frogs['c']) == 0:
                    print("FOUND AN INVALID CROAK")
                    return -1
                else:
                    pop_frog = frogs['c'].pop()
                    frogs['r'].append(pop_frog)
            elif croakOfFrogs[i] == 'o':
                if len(frogs['r']) == 0:
                    print("FOUND AN INVALID CROAK")
                    return -1
                else:
                    pop_frog = frogs['r'].pop()
                    frogs['o'].append(pop_frog)
            elif croakOfFrogs[i] == 'a':
                if len(frogs['o']) == 0:
                    print("FOUND AN INVALID CROAK")
                    return -1
                else:
                    pop_frog = frogs['o'].pop()
                    frogs['a'].append(pop_frog)
            elif croakOfFrogs[i] == 'k':
                if len(frogs['a']) == 0:
                    print("FOUND AN INVALID CROAK")
                    return -1
                else:
                    pop_frog = frogs['a'].pop()
                    frogs['k'].append(pop_frog)

        if frogs['c'] or frogs['r'] or frogs['o'] or frogs['a']:
            print(" last step found leftover frogs")
            return -1

        return current_frog_count





a = Solution()
# a.minNumberOfFrogs('croakcroak')
# a.minNumberOfFrogs('crcoakroak')
# a.minNumberOfFrogs('croakcrook')
# a.minNumberOfFrogs('croakcroa')
a.minNumberOfFrogs("aoocrrackk")