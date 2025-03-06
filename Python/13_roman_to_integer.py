class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """

        '''
        my_dict = { 'I': 1, 'V': 5, 'X': 10,'L': 50, 'C': 100, 'D': 500, 'M': 1000}
        my_twins = {'IV': 4,'IX': 9, 'XL': 40, 'XC': 90, 'CD': 400, 'CM': 900}

        my_list = list(s)
        my_sum = 0

        i = 0
        while i < len(my_list):
            if i == len(my_list) - 1:
                my_sum += my_dict[my_list[i]]
                i +=1 
            elif my_list[i] + my_list[i+1] in my_twins.keys():
                my_sum += my_twins[my_list[i] + my_list[i+1]]
                i += 2
            else:
                my_sum += my_dict[my_list[i]]
                i +=1 

        return my_sum
        '''

        d = {'I':1, 'V':5, 'X':10, 'L':50, 'C':100, 'D':500, 'M':1000}
        n = len(s)
        i = 0
        result = 0
        while i < n:
            if i < n - 1 and d[s[i]] < d[s[i + 1]]:
                result += d[s[i + 1]] - d[s[i]]
                i += 2
            else:
                result += d[s[i]]
                i += 1
        return result