import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        /**
         * n^2 solution
         */
//        for (int i=0; i<nums.length; i++) {
//            for (int j=i+1; j<nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    int[] result = new int[2];
//                    result[0] = i;
//                    result[1] = j;
//                    return result;
//                }
//            }
//        }
//        return new int[0];  // never used

        /**
         * n*logn solution
         */
        // get a sorted array of nums
        int[] sorted_nums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted_nums);

        // for each number binary search if target minus this number is in array
        for (int number : sorted_nums) {
            if (binarySearch(sorted_nums, target-number)) {
                int[] result = new int[2];
                for (int i=0; i<nums.length; i++) {
                    if (nums[i] == number) { result[0] = i; }
                }
                for (int i=0; i<nums.length; i++) {
                    if ((nums[i] == target-number) && (i != result[0])) { result[1] = i; }
                }

                return result;
            }
        }
        return new int[0];  // never used
    }

    // Method to be used to find if number in array in logn time
    private boolean binarySearch(int[] arr, int key) {
        int left = 0, right = arr.length - 1;
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(arr[mid] == key) return true;
            else if (arr[mid] < key) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    // Main method to test functionality from an IDE by running the main method (e.g. IntelliJ)
    public static void main(String[] args) {
        Solution solution = new Solution();     // create instance of Solution

        // Test case 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("Test case 1: [" + result1[0] + ", " + result1[1] + "]");

        // Test case 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println("Test Case 2: [" + result2[0] + ", " + result2[1] + "]");

        // Test case 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println("Test Case 3: [" + result3[0] + ", " + result3[1] + "]");
    }
}