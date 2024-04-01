import unittest
from remove_element import Solution

class Tests(unittest.TestCase):    

    def test_remove_element_1(self):
        nums = [0, 1, 2, 2, 3, 0, 4, 2]
        val = 2
        actual = Solution.remove_element(nums,val)
        expected_n = 5
        expected_nums = [0,1,3,0,4]
        self.assertEqual(actual,expected_n)
        
        self.assertEqual(nums[0:actual],expected_nums)


if __name__ == '__main__':
    unittest.main(exit=False)

    # nums = [0,0,1,1,1,2,2,3,3,4]
    # n = remove_duplicates(nums)
    # print('n = ', n)
    # print('nums = ', nums[0:n])
