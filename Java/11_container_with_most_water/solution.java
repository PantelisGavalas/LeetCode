class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;

        while (left < right) {
            int currWater = (right - left) * Math.min(height[right], height[left]);
            maxWater = Math.max(maxWater, currWater);
            if (height[left] < height[right]) left++;
            else right--;
        }

        return maxWater;
    }
}