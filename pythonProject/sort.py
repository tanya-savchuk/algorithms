from typing import List

class Solution:
    @staticmethod
    def merge(nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Merge nums1 and nums2 into a single array sorted in non-decreasing order.

        Example 1:
        Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        Output: [1,2,2,3,5,6]
        Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
        The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

        iterate over the arrays in reverse order, starting from last elements.
        if there are still elements in both arrays, and current elements in num1
        is greater than current element in num2, place it at the current write_index, and decre
        Compare the last unplaced elements of the two arrays,
        and insert the largest element at the last index.
        Decrement the index of the array containing the largest element
        (to compare two largest unplaced numbers).
        Decrement the write_index.
        """
        a, b, write_index = m - 1, n - 1, m + n - 1

        while b >= 0:
            if a >= 0 and nums1[a] > nums2[b]:
                nums1[write_index] = nums1[a]
                a -= 1
            else:
                nums1[write_index] = nums2[b]
                b -= 1

            write_index -= 1

    if __name__ == '__main__':
        nums1 = [1, 2, 3, 0, 0, 0]
        m = 3
        nums2 = [2, 5, 6]
        n = 3
        # Expected Output: [1, 2, 2, 3, 5, 6]
        merge(nums1, m, nums2, n)

        nums1, m, nums2, n = [1], 1, [], 0
        merge(nums1, m, nums2, n)

        # Expected output: [1]
        nums1, m, nums2, n = [0], 0, [1], 1
        merge(nums1, m, nums2, n)

        end = 'just a stop line'

