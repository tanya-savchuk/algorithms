from typing import List


class Solution:    
    def __init__(self):
        pass
    
    def transpose(self, matrix: List[List[int]]) -> None:
        """
        transpose matrix
        """

        n = len(matrix)
        m = len(matrix[0])

        i = 0
        j = 0

        while i < n :
            while j < m:
                tmp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = tmp
                j = j + 1

            i = i + 1
            j = i   

    
    def reflect(self, matrix: List[List[int]]) -> None:
        """
        reflect matrix across vertical line
        """

        n = len(matrix)
        m = len(matrix[0])

        i = 0
        j = 0

        while i < n :
            while j < m//2:
                tmp = matrix[i][j]
                matrix[i][j] = matrix[i][n-1-j]
                matrix[i][n-1-j] = tmp
                j = j + 1

            i = i + 1
            j = 0   

    
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

        You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
        DO NOT allocate another 2D matrix and do the rotation.
        Do not return anything, modify matrix in-place instead.
        """
        self.transpose(matrix)
        self.reflect(matrix)
        

if __name__ == '__main__':


    x = Solution()
    matrix = [[1,2,3],[4,5,6],[7,8,9]]    
    x.transpose(matrix)
    x.reflect(matrix)
    print(matrix)    

    matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
    x.rotate(matrix)
    print(matrix)
        