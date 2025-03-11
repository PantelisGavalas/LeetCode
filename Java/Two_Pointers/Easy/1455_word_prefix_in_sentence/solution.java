class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        // keep words in an array
        String[] words = sentence.split(" ");

        // search in each word to see if it starts with wanted prefix
        for (int i=0; i<words.length; i++) {
            // if word starts with wanted prefix
            if (words[i].startsWith(searchWord)) {
                return ++i;     // we want it 1-indexed hence the ++i
            }
        }
        
        // we reach here if none words starts with wanted prefix
        return -1;
    }
}