class Solution {
    private String reverseString(char[] charArray) {
        int left = 0;
        int right = charArray.length - 1;
        char temp;
        while(left < right) {
            temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        return new String(charArray);
    }

    public String reverseWords(String s) {
        // Split string into array of String words
        String[] words = s.split(" ");
        for (int i=0; i<words.length; i++) {
            words[i] = reverseString(words[i].toCharArray());
        }

        String result = String.join(" ", words);

        return result;
    }
}