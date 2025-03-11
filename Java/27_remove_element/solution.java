class Solution {
    public int removeElement(int[] nums, int val) {
        // Used the "Two Pointers - Fast & Slow pointers" method
        // slow pointer moving under satisfied condition
        int i = 0;
        // fast pointer iterating our int[] array
        for (int number : nums) {
            if (number != val) {
                nums[i++] = number;
            }
        }

        return i;
    }
}