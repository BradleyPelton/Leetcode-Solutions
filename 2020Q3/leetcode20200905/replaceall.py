

class Solution:
    def modifyString(self, s: str) -> str:
        full_alpha = 'abcdefghijklmnopqrstuvwxyz'

        output_list = []
        for i in range(len(s)):
            if s[i] == '?':
                if i == 0:
                    # print("first charater")
                    next_char = s[i+1]
                    if next_char == 'a':
                        output_list.append('z')
                    else:
                        output_list.append('a')
                    


                elif i == len(s)-1:
                    # print("last character")

                    prev_char = output_list[-1]
                    if prev_char == 'a':
                        output_list.append('b')
                    elif prev_char == 'b':
                        output_list.append('a')

                else:
                    # middle character that is a question mark
                    prev_char = output_list[-1]
                    next_char = s[i+1]

                    if next_char == '?':
                        if prev_char == 'a':
                            output_list.append('b')
                        elif prev_char == 'b':
                            output_list.append('a')
                    else:
                        if prev_char == 'a' and next_char == 'b':
                            output_list.append('c')
                        elif prev_char == 'a' and next_char != 'b':
                            output_list.append('b')
            else:
                # Not a question mark
                output_list.append(s[i])



        # print(output_list)
        ans = "".join(output_list)
        print(ans)
        return ans


a = Solution()
# a.modifyString(s = "?zs")
a.modifyString(s = "ubv?w")
# a.modifyString(s = "j?qg??b")
# a.modifyString(s="??yw?ipkj?")
                    

