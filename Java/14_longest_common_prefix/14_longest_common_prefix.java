class Solution {
    public String longestCommonPrefix(String[] strs) {
        // get the smallest string
        String minStr = strs[0];
        for (String str : strs) {
            if (str.length() < minStr.length()) minStr = str;
        }

        // check if shrinking smallest string is prefix for all string in String array
        Boolean flag = true;
        for (int i=minStr.length(); i>0; i--) {
            for (String str : strs) {
                if (!str.startsWith(minStr.substring(0, i))) {
                    flag = false;
                    break;
                }
            }
            if (flag) return minStr.substring(0, i);
            else flag = true;
        }

        // if nothing common
        return "";
    }
}