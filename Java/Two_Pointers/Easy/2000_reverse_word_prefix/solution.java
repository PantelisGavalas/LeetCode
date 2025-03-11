class Solution {
    public String reversePrefix(String word, char ch) {
        // First me make the string into a char array
        char[] characters = word.toCharArray();
        // We check in O(n) if character ch is in the array
        // and store the position that it is found
        int chPosition = 0;
        for (char c : characters) {
            if (c == ch) break;
            chPosition++;
        }
        if (chPosition >= word.length()) return word;

        // We put two pointers at positions 0 and chPosition and reverse the between 
        // characters by moving the two pointers towards each other in each repetition
        int left = 0;
        int right = chPosition;
        char temp;
        while (left < right) {
            temp = characters[left];
            characters[left] = characters[right];
            characters[right] = temp;
            left++;
            right--;
        }

        // Our array now stores the correct characters for the result string
        return new String(characters);
    }
}