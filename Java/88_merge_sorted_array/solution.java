class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // We use Two Pointers one for each of the two arrays.
        int ptr1 = 0;
        int ptr2 = 0;
        int resultIndex = 0;
        int[] helperNums1 = new int[m];
        for (int i=0; i<m; i++) {
            helperNums1[i] = nums1[i];
        }

        while (ptr1 < m && ptr2 < n) {
            if (helperNums1[ptr1] <= nums2[ptr2]) {
                nums1[resultIndex] = helperNums1[ptr1];
                resultIndex++;
                ptr1++;
            }
            else {
                nums1[resultIndex] = nums2[ptr2];
                resultIndex++;
                ptr2++;
            }
        }
        if (ptr1 == m) {
            while (ptr2 < n) {
                nums1[resultIndex] = nums2[ptr2];
                resultIndex++;
                ptr2++;
            }
        }
        else {
            while (ptr1 < m) {
                nums1[resultIndex] = helperNums1[ptr1];
                resultIndex++;
                ptr1++;
            }
        }
    }
}