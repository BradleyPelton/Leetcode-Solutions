from typing import List

# accepted on second attempt. First attempt I was indexing against the sorted favoriteCompanies
# list isntead of indexing against the original order haha
# solved at 1hr 2 minute mark


class contests2020q4.leetcode20201017.Solution:
    def peopleIndexes(self, favoriteCompanies: List[List[str]]) -> List[int]:
        """ """

        # all_companies = set()
        # for fav in favoriteCompanies:
        #     all_companies.update(fav)
        # print(all_companies)

        fav_copy = favoriteCompanies.copy()
        print(favoriteCompanies)
        favoriteCompanies.sort(key=lambda x: len(x), reverse=True)
        # print(favoriteCompanies)

        uniques = []
        for fav in favoriteCompanies:
            # print(f"currently testing {fav}")
            for uni in uniques:
                # for each unique company list in uniques
                # print(f"against {uni}")
                if set(fav).difference(set(uni)) == set():
                    # print("found a proper subset")
                    break
            else:
                # print(f"this is not a proper subset {fav}")
                uniques.append(fav)
        print(uniques)

        inds = [fav_copy.index(x) for x in uniques]
        inds.sort()
        print(inds)
        return inds


a = contests2020q4.leetcode20201017.Solution()
# a.peopleIndexes([["leetcode","google","facebook"],["google","microsoft"],["google","facebook"],["google"],["amazon"]])
# a.peopleIndexes([["leetcode","google","facebook"],["leetcode","amazon"],["facebook","google"]])
a.peopleIndexes([["leetcode"],["google"],["facebook"],["amazon"]])
# a.peopleIndexes([
#     ["arrtztkotazhufrsfczr","knzgidixqgtnahamebxf","zibvccaoayyihidztflj"],
#     ["cffiqfviuwjowkppdajm","owqvnrhuzwqohquamvsz"],
#     ["knzgidixqgtnahamebxf","owqvnrhuzwqohquamvsz","qzeqyrgnbplsrgqnplnl"],
#     ["arrtztkotazhufrsfczr","cffiqfviuwjowkppdajm"],
#     ["arrtztkotazhufrsfczr","knzgidixqgtnahamebxf","owqvnrhuzwqohquamvsz","qzeqyrgnbplsrgqnplnl","zibvccaoayyihidztflj"]])
# a.peopleIndexes([
#     ["a","k","z"],
#     ["c","o"],
#     ["k","o","q"],
#     ["a","c"],
#     ["a","k","o","q","z"]])