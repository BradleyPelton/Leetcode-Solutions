from collections import defaultdict
# sloppy work. Accepted on second try, forgot to exclude i= 0 line 6
class contests2020q4.leetcode20201017.Solution:
    def countLargestGroup(self, n: int) -> int:
        
        hash_map = {i: sum([int(j) for j in list(str(i))]) for i in range(1,n+1)}
        # print(hash_map)

        grouped_dict = defaultdict(list)
        for k, v in hash_map.items():
            grouped_dict[v].append(k)
        # print(grouped_dict)

        length_list = [(k, len(v)) for k, v in grouped_dict.items()]
        # print(length_list)

        sorted_length_list = sorted(length_list, key=lambda x: x[1])
        print(sorted_length_list)

        longest = sorted_length_list.pop()

        total_count = 0
        for obj in length_list:
            if obj[1] == longest[1]:
                total_count += 1
        print(total_count)
        return(total_count)
a = contests2020q4.leetcode20201017.Solution()
a.countLargestGroup(2)
