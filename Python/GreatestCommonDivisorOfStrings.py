class Solution(object):
    def gcdOfStrings(self, str1, str2):
        """
        :type str1: str
        :type str2: str
        :rtype: str
        """

        CommonWords = [
            ""
        ]

        # (1) find all common letters/words
        # check for 1 letter words
        for i in range(0, len(str1)):
            for j in range(0, len(str2)):
                if (str1[i] == str2[j]):
                    CommonWords += str1[i]

        # (2) find longest word
        GCD = ""
        for i in range(0, len(CommonWords)):
            if len(CommonWords[i]) > GCD:
                GCD = CommonWords[i]

        # (3) return the longest word
        return GCD
