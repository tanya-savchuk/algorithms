from typing import List


class Solution:
    
    dict = {
            "2": ["a","b", "c"],
            "3": ["d","e","f"],
            "4": ["g","h","i"],
            "5": ["j","k","l"],
            "6": ["m", "n", "o"],
            "7": ["p","q","r","s"],
            "8": ["t","u","v"],
            "9": ["w","x","y","z"]
        }
        
    def letter_combinations(digits: str) -> List[str]:
        """
        Medium

        17. Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. 
        Return the answer in any order.
        A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

        0 <= digits.length <= 4
        digits[i] is a digit in the range ['2', '9'].
        """
        
        res = []        
        if digits == "":
            return []
        elif len(digits) == 1:            
            return Solution.dict[digits]
        
        digits_1n = digits[1:]
             
        list_1n = Solution.letter_combinations(digits_1n)
        digit_0 = digits[0]   
        for letter in Solution.dict[digit_0]:
            for item in list_1n:
                res.append(letter + item)            

        return res
    
if __name__ == '__main__':
    digits = "23"
    res = ["ad","ae","af","bd","be","bf","cd","ce","cf"]
    res2 = Solution.letter_combinations(digits)
    print(res2)

    digits = "237"
    
    res2 = Solution.letter_combinations(digits)
    print(res2)

