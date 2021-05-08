
## Accepted after 24 minutes and an output limit exceeded error.
# Very frustrating problem. Should not be this hard.

class contests2020q4.leetcode20201017.Solution:
    def makeGood(self, s: str) -> str:

        print(f"string before is {s}")
        new_string = s
        for _ in range(100):
            exclud = []
            for i in range(0, len(new_string)-1):
                if new_string[i].upper() == new_string[i+1].upper():
                    if new_string[i] != new_string[i+1]:
                        if i not in exclud and i+1 not in exclud:
                            exclud.append(i)
                            exclud.append(i+1)
            new_string_list = [new_string[i] for i in range(len(new_string)) if i not in exclud]
            new_string = "".join(new_string_list)
            # print(f"after round{_}, newstring is {new_string}")

        # print(f"after all {new_string}")
        return new_string

a = contests2020q4.leetcode20201017.Solution()
a.makeGood("leEeetcode")
# a.makeGood("abBAcC")
