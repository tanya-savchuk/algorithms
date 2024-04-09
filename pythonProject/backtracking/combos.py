from typing import List


class Solution:
    def __init__(self):
        pass
    
    def combine(self, n: int, k: int) -> List[List[int]]:
        """
        #77

        Medium

        Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
        You may return the answer in any order.

        Example 1:
        Input: n = 4, k = 2
        Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
        Explanation: There are 4 choose 2 = 6 total combinations.
        Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
        Example 2:

        Input: n = 1, k = 1
        Output: [[1]]
        Explanation: There is 1 choose 1 = 1 total combination.        

        Constraints:

        1 <= n <= 20
        1 <= k <= n
        """
        res = []
        if n == 1:
            return res.append([1]) 

        if k == n:
            return res.append(range(1,k))
        
        if k == 1:
            return res.append([item] for item in range(1,n+1))

        n_list = list(range(1,n))
        return Solution.combine(n-1,k)
    
        # k = 2:  [1,4] [2,4] [3,4]
        #         [1,3] [2,3]
        #         [1,2]
        # k = 3 : [1,2,4] [1,3,4] 
        #         [2,3,4]
        #         [1,2,3]  

        
        return res
    
    def all_combos(self, list_n):
        if len(list_n) == 0: 
            return [[]]
        
        firstEl = list_n[0]
        rest = list_n[1:]

        combs_wo_first = Solution.all_combos(self, rest)
        combs_w_first = []        

        for item in combs_wo_first:            
            combs_w_first.append([*item, firstEl])
        return [*combs_w_first, *combs_wo_first]
    
if __name__ == '__main__':
    sol = Solution()
    n = 3
    list_n = list(range(1,n+1))
    res = sol.all_combos(list_n)
    print(res)

    # n = 4
    # k = 2
    # Solution.combine(4,2)