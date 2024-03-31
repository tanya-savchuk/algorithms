from typing import List


class Solution:
    @staticmethod
    def remove_element_bf(nums: List[int], val: int) -> int:
        """
        Input: nums = [0,1,2,2,3,0,4,2], val = 2
        Output: 5, nums = [0,1,4,0,3,_,_,_]
        Explanation: Your function should return k = 5,
        with the first five elements of nums containing 0, 0, 1, 3, and 4.
        Note that the five elements can be returned in any order.
        It does not matter what you leave beyond the returned k (hence they are underscores).

        this solution is not efficient, becase every time we pop, we have to shift the array tail
         by one place to the left. This is O(n) complexity.
         The entire loop is O(n^2)
        """
        i = 0
        dummy = -1
        while i < len(nums) and nums[i] != dummy:
            if nums[i] == val:
                nums.pop(i)
                nums.append(dummy)
            else:
                i = i + 1

        return i

    @staticmethod
    def remove_element(nums: List[int], val: int) -> int:
        '''
        Input: nums = [0,1,2,2,3,0,4,2], val = 2
        Output: 5, nums = [0,1,4,0,3,_,_,_]
        Explanation: Your function should return k = 5,
        with the first five elements of nums containing 0, 0, 1, 3, and 4.
        Note that the five elements can be returned in any order.
        It does not matter what you leave beyond the returned k (hence they are underscores).

        Loop:
            if num ia not eq to val, write it into nums array, advance write index i
            if num == val, do nothing

            This will ensure that vals in nums will be overwritten when we find num != val
            O(n)
        '''
        i = 0
        for num in nums:
            if num != val:
                nums[i] = num
                i = i + 1

        return i

    @staticmethod
    def remove_duplicates(nums: List[int]) -> int:
        """
        Input: nums = [0,0,1,1,1,2,2,3,3,4], sorted in non-decreasing order
        Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
        Explanation: function should return k = 5,
        with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
        It does not matter what you leave beyond the returned k (hence they are underscores).
        """
        k = 0
        i = 0 # write at index
        n2check = len(nums) - 1         
        while n2check > 0:            
            if nums[k] == nums[k+1]:
                 pass                       
            else:
                nums[i] = nums[k]
                i = i + 1
            k = k + 1             
            n2check = n2check - 1
        # if the last element is not a dupe, add to the array
        if nums[k-1] != nums[k]:                      
            nums[i] = nums[k] 
            i = i + 1  
        return i

    if __name__ == '__main__':
        nums = [0, 1, 2, 2, 3, 0, 4, 2]
        val = 2
        n = remove_element(nums, val)
        print('n = ', n)
        print('nums = ', nums)

        nums = [0,0,1,1,1,2,2,3,3,4]
        n = remove_duplicates(nums)
        print('n = ', n)
        print('nums = ', nums[0:n])
