
### Accepted first attemtp

class contests2020q4.leetcode20201017.Solution:
    def defangIPaddr(self, address: str) -> str:
        """ """
        new_address = address.replace(".","[.]")
        return new_address



a = contests2020q4.leetcode20201017.Solution()
a.defangIPaddr("1.1.1.1")