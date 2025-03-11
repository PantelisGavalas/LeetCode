import java.util.*;

class Solution {
    public int distinctAverages(int[] nums) {
        // Set to store the distinct averages
        Set<Double> distinctAverages = new HashSet<>();

        // We sort the array to use first and last elements in each iteration
        Arrays.sort(nums);

        // Two pointers at start and end of array
        int left = 0;
        int right = nums.length - 1;

        // Calculate and store in set the average each time
        while (left < right) {
            double average = (double) (nums[left] + nums[right]) / 2;
            distinctAverages.add(average);
            left++;
            right--;
        }

        // return the size of the set => distinct average values
        return distinctAverages.size();
    }
}