import java.util.*;

class Solution {
    private int xSum(int[] nums, int left, int right, int x) {
        // if x is bigger or equal than the array size
        // return the sum of all array elements
        if (x >= right+1-left) {
            int sum = 0;
            for (int i=left; i<right+1; i++) {
                sum += nums[i];
            }
            return sum;
        }
        // create a map of how frequently we see a number in the array
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i=left; i<right+1; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        // We create a minHeap that prioritizes primarily based on the
        // frequency of the elements and secondarily by their value
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> {
            int freqComparison = a.getValue() - b.getValue();
            if (freqComparison != 0) return freqComparison;
            else return a.getKey() - b.getKey(); // Corrected line
        });
        // add entries to the minHeap
        for (Map.Entry<Integer, Integer> mapEntry : freqMap.entrySet()) {
            minHeap.add(mapEntry);
        }

        // Now while the size of the Heap is bigger than X we remove entries from the minHeap
        while (minHeap.size() > x) {
            minHeap.remove();
        }
        // For remaining Heap items, we add the numbers (as many times as they appear based on their frequency)
        int arrayXSum = 0;
        for (Map.Entry<Integer, Integer> mapEntry : minHeap) {
            arrayXSum += mapEntry.getKey() * mapEntry.getValue();
        }

        return arrayXSum;
    }

    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n-k+1];
        // call xSum function for each K-Long subarray of nums
        for (int i=0; i<n-k+1; i++) {
            result[i] = xSum(nums, i, i+k-1, x);
        }

        return result;
    }
}