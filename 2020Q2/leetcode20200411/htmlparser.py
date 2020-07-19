
# Solved in 9 minutes. How is this a 5 point problem?
# Probably really hard in other languages? Who knows
# I initially thought this was going to be a regex problem but a simple str.replace worked
# Regex could have been another solution
class Solution:
    def entityParser(self, text: str) -> str:
        """ """
        text = text.replace("&amp;", "&")
        text = text.replace("&quot;", "\"")
        text = text.replace("&apos;", "\'")
        text = text.replace("&gt;", ">")
        text = text.replace("&lt;", "<")
        text = text.replace("&frasl;", "/")

        print(text)
        return(text)



a = Solution()
# a.entityParser("&amp; is an HTML entity but &ambassador; is not.")
a.entityParser("leetcode.com&frasl;problemset&frasl;all")