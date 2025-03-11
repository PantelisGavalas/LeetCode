class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        // If last element of one array is smaller than first of other => no common
        if (nums1[nums1.length-1] < nums2[0] || nums2[nums2.length-1] < nums1[0]) {
            return -1;
        }

        // Use two pointers one for each array.
        // When the current number of one array is smaller move its pointer to the right 
        // until common element found => return that element 
        // or array is over => no common element => return -1
        int ptr1 = 0;
        int ptr2 = 0;
        while (ptr1 < nums1.length && ptr2<nums2.length) {
            if (nums1[ptr1] == nums2[ptr2]) return nums1[ptr1];
            else if (nums1[ptr1] < nums2[ptr2]) ptr1++;
            else ptr2++;
        }
        
        // if we reach this -> no common element
        return -1;

    }
}