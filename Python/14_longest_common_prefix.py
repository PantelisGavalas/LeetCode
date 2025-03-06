class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        strs = sorted(strs)
        for i in range(len(strs[0])):
            pref = strs[0][:len(strs[0])-i]
            if pref == strs[len(strs)-1][:len(pref)]:
                return pref
        return ""