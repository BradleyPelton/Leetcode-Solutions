from typing import List
from collections import defaultdict
class contests2020q4.leetcode20201017.Solution:
    def checkIfPrerequisite(self, n: int, prerequisites: List[List[int]], queries: List[List[int]]) -> List[bool]:
        
        course_prereqs = defaultdict(list)

        for prereq in prerequisites:
            course_prereqs[prereq[0]].extend(prereq[1:])
        
        print("COURSES BEFORE INDIRECT")
        print(course_prereqs)

        for course in course_prereqs.keys():
            for c1 in course_prereqs.keys():
                for subcourse in course_prereqs[c1]:
                    if subcourse not in course_prereqs[course]:
                        course_prereqs[course].append(subcourse)
        

        print("COURSES AFTER INDIRECT")
        print(course_prereqs)
        ans_list = []
        
        for q in queries:
            if q[0] in course_prereqs[q[1]]:
                ans_list.append(True)
            else:
                ans_list.append(False)
        print(ans_list)
        

a = contests2020q4.leetcode20201017.Solution()
a.checkIfPrerequisite(3,[[1,2],[1,0],[2,0]],[[1,0],[1,2]])
# a.checkIfPrerequisite(5,[[0,1],[1,2],[2,3],[3,4]], [[0,4],[4,0],[1,3],[3,0]])