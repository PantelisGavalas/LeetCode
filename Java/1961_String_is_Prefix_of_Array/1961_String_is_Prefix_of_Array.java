class Solution {
    public boolean isPrefixString(String s, String[] words) {
        // We ensure that some K number of words are the same size as String s
        // If not return false
        int stringSize = s.length();
        int wordsSize = 0;
        for (int i=0; i<words.length; i++) {
            wordsSize += words[i].length();
            if (wordsSize == stringSize) break;
            else if (wordsSize > stringSize) return false;
        }

        // Create a single String from words array
        // If it starts with our String s return true
        String wordsConcatString = String.join("", words);
        if(wordsConcatString.startsWith(s)) return true;
        else return false;
    }
}