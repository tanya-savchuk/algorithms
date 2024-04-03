from typing import List


class Solution:

    @staticmethod
    def isValidSudoku_1(board: List[List[str]]) -> bool:
        """
        Medium 

        Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

        Each row must contain the digits 1-9 without repetition.
        Each column must contain the digits 1-9 without repetition.
        Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

        Input: board = 
        [["5","3",".",".","7",".",".",".","."]
        ,["6",".",".","1","9","5",".",".","."]
        ,[".","9","8",".",".",".",".","6","."]
        ,["8",".",".",".","6",".",".",".","3"]
        ,["4",".",".","8",".","3",".",".","1"]
        ,["7",".",".",".","2",".",".",".","6"]
        ,[".","6",".",".",".",".","2","8","."]
        ,[".",".",".","4","1","9",".",".","5"]
        ,[".",".",".",".","8",".",".","7","9"]]
        Output: true

        Example 2:
        Input: board = 
        [["8","3",".",".","7",".",".",".","."]
        ,["6",".",".","1","9","5",".",".","."]
        ,[".","9","8",".",".",".",".","6","."]
        ,["8",".",".",".","6",".",".",".","3"]
        ,["4",".",".","8",".","3",".",".","1"]
        ,["7",".",".",".","2",".",".",".","6"]
        ,[".","6",".",".",".",".","2","8","."]
        ,[".",".",".","4","1","9",".",".","5"]
        ,[".",".",".",".","8",".",".","7","9"]]
        Output: false
        """       

        val_dict = {}       

        for i in range(0,9):
            
            for j in range(0,9):
                
                current_val = board[i][j]
                if current_val != ".":
                    val_dict.setdefault(current_val,{"row":[], "column":[], "square":[]})
                    val_dict[current_val]["row"].append(str(i))
                    val_dict[current_val]["column"].append(str(j))                    
                    val_dict[current_val]["square"].append((i//3,j//3))   

        for item in val_dict:
            for jtem in val_dict[item]:
                tmp = val_dict[item][jtem]
                if len( set(tmp) ) != len( tmp ):
                    return False

        return True
    
    def isValidSudoku(board: List[List[str]]) -> bool:
        """
        same as above, but without dictionary
        storing board in an array of tuples
        [(element, row_idx), (col_idx, element), (element, row_idx, col_idx)]
        then compare len( set (resulting array) ) to len(resulting array)    
        """
        res = []
        for i in range(0,9):
            for j in range(0,9):
                cur_val = board[i][j]
                if cur_val != ".":
                    res.append((cur_val,i))
                    res.append((j,cur_val))
                    res.append((cur_val, i//3, j//3))

        return len (set ( res ) ) == len(res)
    
    if __name__ == '__main__':
        board = \
                [["8","3",".",  ".","7",".",  ".",".","."]
                ,["6",".",".",  "1","9","5",  ".",".","."]
                ,[".","9","8",  ".",".",".",  ".","6","."]

                ,["8",".",".",  ".","6",".",  ".",".","3"]
                ,["4",".",".",  "8",".","3",  ".",".","1"]
                ,["7",".",".",  ".","2",".",  ".",".","6"]

                ,[".","6",".",  ".",".",".",  "2","8","."]
                ,[".",".",".",  "4","1","9",  ".",".","5"]
                ,[".",".",".",  ".","8",".",  ".","7","9"]]
        
        res = isValidSudoku(board)
        print('expected False, actual: ', res)

        board = \
                [["5","3",".", ".","7",".", ".",".","."]
                ,["6",".",".", "1","9","5", ".",".","."]
                ,[".","9","8", ".",".",".", ".","6","."]

                ,["8",".",".", ".","6",".", ".",".","3"]
                ,["4",".",".", "8",".","3", ".",".","1"]
                ,["7",".",".", ".","2",".", ".",".","6"]

                ,[".","6",".", ".",".",".", "2","8","."]
                ,[".",".",".", "4","1","9", ".",".","5"]
                ,[".",".",".", ".","8",".", ".","7","9"]]
        
        res = isValidSudoku(board)
        print('expected True, actual: ', res)