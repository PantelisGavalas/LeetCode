class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        // Two Pointers approach for O(n) complexity
        // We iterate through the loop from indexDifference until the end
        // In each iteration, we keep the minimum and maximum so far in the array 
        // from elements of indexDifference distance before our current element
        // Then we compare them with our current element to see if they have difference bigger
        // or equal to valueDifference
        int minIndex = 0; 
        int maxIndex = 0;
        for (int right=indexDifference; right<nums.length; right++) {
            // find the minimum and maximum in the first right-indexDifference elements
            if (nums[right-indexDifference] < nums[minIndex]) minIndex = right-indexDifference;
            if (nums[right-indexDifference] > nums[maxIndex]) maxIndex = right-indexDifference;

            // see if current element satisfies condition with any of so far known minimum or maximum
            if (nums[right] - nums[minIndex] >= valueDifference) return new int[]{minIndex, right};
            if (nums[maxIndex] - nums[right] >= valueDifference) return new int[]{maxIndex, right};
        }

        // if we reach here no elemets satisfy condition => [-1, -1]
        return new int[]{-1, -1};
    }
}