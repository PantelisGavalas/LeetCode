class Solution {
    
    // Function to reverse substring of a string from left to right
    private StringBuilder reversePart(StringBuilder s, int left, int right) {
        char temp;
        while (left < right) {
            temp = s.charAt(left);
            s.setCharAt(left, s.charAt(right));
            s.setCharAt(right, temp);
            left++;
            right--;
        }
        return s;
    }

    public String reverseStr(String s, int k) {
        /** 
            Idea is to alternate between using Two-Pointers to reverse the part of length K and leaving it as it is. 
            We will use a boolean to alternate between these two states and respectively in a for loop reverse the ones
            that have to be reversed. 
            On last part that remains we check the boolean flag to see if it also needs to stay as is or needs reversing.
        */

        // StringBuilder result to be returned (mutable)
        StringBuilder result = new StringBuilder(s);
        // find how many parts of size K exist in the string
        int numOf_K_Parts = s.length() / k;
        // reversing need flag
        boolean reversePart = true;
        // Two Pointers used to reverse each appropriate K part
        int left, right;

        // for all whole K parts reverse the ones needed
        for (int i=0; i<numOf_K_Parts; i++) {
            if (reversePart) {
                left = k * i;
                right = k*i + (k-1);
                result = reversePart(result, left, right);

                reversePart = !reversePart;
            }
            else reversePart = !reversePart;
        }

        // for remaining of the string reverse if needed
        if (reversePart) {
            left = k * numOf_K_Parts;
            right = s.length() - 1;
            result = reversePart(result, left, right);
        }
        
        return result.toString();
    }
}