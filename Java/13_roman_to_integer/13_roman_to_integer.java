class Solution {
    public int romanToInt(String s) {
        int result = 0;
        for (int i=0; i<s.length()-1; i++) {
            if (s.charAt(i) == 'I' && s.charAt(i+1) == 'V') {
                i++;
                result += 4;
                if (i == s.length()-1) return result;
            }
            else if (s.charAt(i) == 'I' && s.charAt(i+1) == 'X') {
                i++;
                result += 9;
                if (i == s.length()-1) return result;
            }
            else if (s.charAt(i) == 'X' && s.charAt(i+1) == 'L') {
                i++;
                result += 40;
                if (i == s.length()-1) return result;
            }
            else if (s.charAt(i) == 'X' && s.charAt(i+1) == 'C') {
                i++;
                result += 90;
                if (i == s.length()-1) return result;
            }
            else if (s.charAt(i) == 'C' && s.charAt(i+1) == 'D') {
                i++;
                result += 400;
                if (i == s.length()-1) return result;
            }
            else if (s.charAt(i) == 'C' && s.charAt(i+1) == 'M') {
                i++;
                result += 900;
                if (i == s.length()-1) return result;
            }
            else if (s.charAt(i) == 'I') result += 1;
            else if (s.charAt(i) == 'V') result += 5;
            else if (s.charAt(i) == 'X') result += 10;
            else if (s.charAt(i) == 'L') result += 50;
            else if (s.charAt(i) == 'C') result += 100;
            else if (s.charAt(i) == 'D') result += 500;
            else if (s.charAt(i) == 'M') result += 1000;
        }
        if (s.charAt(s.length()-1) == 'I') result += 1;
        else if (s.charAt(s.length()-1) == 'V') result += 5;
        else if (s.charAt(s.length()-1) == 'X') result += 10;
        else if (s.charAt(s.length()-1) == 'L') result += 50;
        else if (s.charAt(s.length()-1) == 'C') result += 100;
        else if (s.charAt(s.length()-1) == 'D') result += 500;
        else if (s.charAt(s.length()-1) == 'M') result += 1000;

        return result;
    }
}