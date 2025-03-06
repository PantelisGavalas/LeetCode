class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """

        
        def is_Palindrome (my_str):
            for i in range(0, int(len(my_str)/2) + 1):
                if my_str[i] != my_str[len(my_str)-1-i]:
                    return False
            return True
        
        return is_Palindrome(str(x))
        

        #rev_str = str(x)[::-1]
        #return rev_str == str(x)