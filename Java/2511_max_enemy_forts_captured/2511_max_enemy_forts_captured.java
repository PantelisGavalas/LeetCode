class Solution {
    public int captureForts(int[] forts) {
        // Check if we have any forts under our command
        boolean noAllyFortYet = true;
        for (int fort : forts) {
            if (fort == 1) noAllyFortYet = false;
        }
        if (noAllyFortYet) return 0;
        
        // We use two pointers to iterate the forts array
        int slow = 0;
        int fastPtr = 0;
        // Move from inital potential zeros
        while (forts[slow] == 0) {
            slow++;
            fastPtr++;
        }

        // Once we find a 1|-1 fort, we start moving fast pointer to see if we reach a -1|1 fort respectively
        // If we do then these are valid enemy forts in between. If we reach again the same type of fort the in between are not valid enemy forts.
        int maxForts = 0;
        int potentialForts = 0;

        for (int fast=fastPtr; fast<forts.length; fast++) {
            // moving through enemy forts potentially to be captured
            if (forts[fast] == 0) {
                potentialForts += 1;
            }
            // found subarray of [1,0,...,0,-1] or [-1,0,...,0,1]
            else if (forts[fast] != forts[slow]) {
                maxForts = Math.max(maxForts, potentialForts);
                potentialForts = 0;
                slow = fast;
            }
            // found subarray of [1,0,...,0,1] or [-1,0,...,0,-1]
            else {
                potentialForts = 0;
                slow = fast;
            }
        }

        return maxForts;
    }
}