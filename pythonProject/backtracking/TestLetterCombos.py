import unittest
from letter_combos_phone_num import Solution

class Tests(unittest.TestCase):

    def test_0digits(self):

        digits = ""
        expected = []
        
        actual = Solution.letter_combinations(digits)
        self.assertEqual(expected, actual)

    def test_1digits(self):

        digits = "2"
        expected = ["a","b", "c"]

        actual = Solution.letter_combinations(digits)
        self.assertEqual(expected, actual)

    def test_2digits(self):
        digits = "23"
        expected = ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        actual = Solution.letter_combinations(digits)
        self.assertEqual(expected, actual)

    def test_3digits(self):
        digits = "237"

        expected = ['adp', 'adq', 'adr', 'ads', 'aep', 'aeq', 'aer', 
                    'aes', 'afp', 'afq', 'afr', 'afs', 'bdp', 'bdq', 
                    'bdr', 'bds', 'bep', 'beq', 'ber', 'bes', 'bfp', 
                    'bfq', 'bfr', 'bfs', 'cdp', 'cdq', 'cdr', 'cds', 
                    'cep', 'ceq', 'cer', 'ces', 'cfp', 'cfq', 'cfr', 
                    'cfs']
        
        actual = Solution.letter_combinations(digits)
        self.assertEqual(expected, actual)

if __name__ == '__main__':
     unittest.main(exit=False)