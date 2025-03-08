class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int number : nums) {
            if (i<1 || number > nums[i-1]) {
                nums[i] = number;
                i++;
            }
        }

        return i;
    }
}