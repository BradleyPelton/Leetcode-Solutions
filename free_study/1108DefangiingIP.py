
### Accepted first attemtp

class Solution:
    def defangIPaddr(self, address: str) -> str:
        """ """
        new_address = address.replace(".","[.]")
        return new_address



a = Solution()
a.defangIPaddr("1.1.1.1")