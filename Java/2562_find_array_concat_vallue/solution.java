class Solution {
    private long concatTwoNumbers (int num1, int num2) {
        int num2Digits = (int) Math.log10(num2) + 1;
        int multFactor = (int) Math.pow(10, num2Digits);
        long concatNum = num1*multFactor + num2;
        return concatNum;
    }

    public long findTheArrayConcVal(int[] nums) {
        // We have two pointers at start and end of array.
        // We take the array values at the pointers. To concatenate them, we multiply the first with 
        // the power of 10 as many digits are in the right number, and we add the second number
        // If nums size is odd we also add the middle nums number in the end.
        int left = 0;
        int right = nums.length - 1;
        long concatValue = 0;

        while (left < right) {
            concatValue += concatTwoNumbers(nums[left], nums[right]);
            left++;
            right--;
        }

        // if odd number of elements in nums array
        if (nums.length % 2 == 1) {
            concatValue += nums[(int) nums.length / 2];
        }

        return concatValue;
    }
}