'''
You are given two strings word1 and word2. Merge the strings by adding letters 
in alternating order, starting with word1. If a string is longer than the other, 
append the additional letters onto the end of the merged string.

Return the merged string.
'''


class Solution(object):
    def mergeAlternately(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: str
        """
        length1 = len(word1)
        length2 = len(word2)
        length3 = 2 * length1 if length1 >= length2 else 2 * length2

        merged = ""

        for i in range(0, length3):
            if i % 2 == 0 and i/2 < length1:  # if even
                merged += word1[i/2]
            elif i % 2 == 1 and i/2 < length2:  # if odd
                merged += word2[i/2]

        return merged
