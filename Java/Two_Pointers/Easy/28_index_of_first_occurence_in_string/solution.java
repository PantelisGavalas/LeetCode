import java.util.*;

class Solution {
    public int strStr(String haystack, String needle) {
        // Ensure that the needle is smaller than the haystack
        if (haystack.length() < needle.length()) return -1;

        // we will turn the string into arrays to easier compare each character
        // We will make use of Two Pointers. The fast pointer will be moving as long as
        // it is finding the needle word. If needle not found the slow pointer goes to 
        // the next start of the needle word stored in a Queue.
        // If needle found we return the slow pointer (sits at beggining of the needle)
        // If not found at all we return -1.

        // turn strings to char arrays
        char[] haystackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();
        // find and add in a Queue all occurences of beggining of needle
        Queue<Integer> needleStartPoints = new LinkedList<>();
        for (int i=0; i<haystackArray.length; i++) {
            if (haystackArray[i] == needleArray[0]) needleStartPoints.add(i);
        }
        // if Queue is empty => no potential needle => return -1
        if (needleStartPoints.isEmpty()) return -1;

        // we start from first potential needle occurence
        int slow = needleStartPoints.poll();
        int fast = slow;
        int charCount = 0;
        // Start moving the pointers accordingly until needle found or end of string
        for (; fast<haystackArray.length; fast++) {
            if (haystackArray[fast] == needleArray[fast-slow]) {
                charCount++;
                // if whole needle found
                if (charCount == needle.length()) return slow;
            }
            else {
                // needle not found yet so move pointers to next potential needle 
                // (next needle start stored in the Queue)
                // if at any point Queue is empty => no other potential needle => return -1
                if (needleStartPoints.isEmpty()) return -1;
                charCount = 0;
                slow = needleStartPoints.poll();
                fast = slow - 1;
            }
        }

        // if we reach here no needle in the haystack
        return -1;
    }
}