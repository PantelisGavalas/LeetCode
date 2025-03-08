class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int number : nums) {
            if (number != val) {
                nums[i++] = number;
            }
        }

        return i;
    }
}