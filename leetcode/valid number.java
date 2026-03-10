class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExponent = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                seenDigit = true;
            } 
            else if (c == '+' || c == '-') {
                // Sign must be at the start OR immediately after 'e/E'
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } 
            else if (c == 'e' || c == 'E') {
                // Exponent needs a digit before it and no previous exponent
                if (seenExponent || !seenDigit) {
                    return false;
                }
                seenExponent = true;
                seenDigit = false; // Reset for the integer after 'e'
            } 
            else if (c == '.') {
                // Dot cannot appear after 'e' or another dot
                if (seenDot || seenExponent) {
                    return false;
                }
                seenDot = true;
            } 
            else {
                // Any other character is invalid
                return false;
            }
        }

        return seenDigit; // Must end with a valid digit sequence
    }
}
