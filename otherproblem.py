class Solution(object):
    def twoCitySchedCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        a_costs = []
        b_costs []
        for i in range(len(costs)-1):
            a_costs.append(costs[i][0])
        for i in range(len(costs)-1):
            b_costs.append(costs[i][1])
        







"""
There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], 
and the cost of flying the i-th person to city B is costs[i][1].

Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
"""
### the ith person is a 2x1 matrix with the first entry being cost to A, second cost to B [x,y]