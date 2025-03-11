class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        // Naive O(n^2) solution
        int difference;
        for(int left=0; left<nums.length-indexDifference; left++) {
            for (int right=indexDifference+left; right<nums.length; right++) {
                difference = Math.abs(nums[left] - nums[right]);
                if (difference >= valueDifference) {
                    return new int[]{left, right};
                }
            }
        }

        return new int[]{-1, -1};
    }
}