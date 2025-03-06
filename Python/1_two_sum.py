class Solution(object):
    _binSearchBool = 0
    def binSearch(self, nums, target):
        if len(nums) == 1 and target == nums[0]:
            Solution._binSearchBool = 1
        elif len(nums) == 1 and target != nums[0]:
            Solution._binSearchBool = 0
        else:
            if target == nums[len(nums)/2]:
                Solution._binSearchBool = 1
            elif target < nums[len(nums)/2]:
                Solution.binSearch(self, nums[:len(nums)/2], target)
            else:
                Solution.binSearch(self, nums[len(nums)/2:], target)
    
    
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        # sort my numbers
        sorted_list = sorted(nums)

        for number in sorted_list:
            diff = target - number
            #if diff not in sorted_list:    # binary search this since its sorted for O(n*logn)  
            #if not sorted_list.__contains__(diff):
            Solution.binSearch(self, sorted_list, diff)
            if Solution._binSearchBool == 1:
                for i in range(0, len(nums)):
                    #print ('index1 effort for ' + str(i))
                    if nums[i] == number:
                        index1 = i
                        break
                for i in range(0, len(nums)):
                    #print ('index2 effort for ' + str(i))
                    if nums[i] == diff and i != index1:
                        index2 = i
                        break
                break
        
        return [min(index1, index2), max(index1, index2)]
        