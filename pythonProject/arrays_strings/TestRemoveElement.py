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

    def test_remove_element_2(self):

        nums = [3,2,2,3]
        val = 3
        actual = Solution.remove_element(nums,val)

        expected_n = 2
        expected_nums = [2,2]

        self.assertEqual(actual,expected_n)        
        self.assertEqual(nums[0:actual],expected_nums)

    def test_remove_element_3(self):

        nums = [3,3,3]
        val = 3
        actual = Solution.remove_element(nums,val)

        expected_n = 0
        expected_nums = []

        self.assertEqual(actual,expected_n)        
        self.assertEqual(nums[0:actual],expected_nums)

    def test_remove_element_4(self):

        nums = [3,3,3]
        val = 1
        actual = Solution.remove_element(nums,val)

        expected_n = 3
        expected_nums = [3,3,3]

        self.assertEqual(actual,expected_n)        
        self.assertEqual(nums[0:actual],expected_nums)
    

    def test_remove_duplicates_1(self):

        nums = [0,0,1,1,1,2,2,3,3,4]
        actual = Solution.remove_duplicates(nums)

        expected_n = 5
        expected_nums = [0,1,2,3,4]

        self.assertEqual(actual,expected_n)        
        self.assertEqual(nums[0:actual],expected_nums)



if __name__ == '__main__':

    unittest.main(exit=False)

