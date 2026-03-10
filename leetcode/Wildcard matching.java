class Solution {
    public boolean isMatch(String s, String p) {
        int sIdx = 0, pIdx = 0;
        int sLen = s.length(), pLen = p.length();
        int lastWildcardIdx = -1, sBacktrackIdx = -1;

        while (sIdx < sLen) {
            // 1. Characters match or pattern has '?'
            if (pIdx < pLen && (p.charAt(pIdx) == s.charAt(sIdx) || p.charAt(pIdx) == '?')) {
                sIdx++;
                pIdx++;
            } 
            // 2. Pattern has '*', mark position for potential backtracking
            else if (pIdx < pLen && p.charAt(pIdx) == '*') {
                lastWildcardIdx = pIdx;
                sBacktrackIdx = sIdx;
                pIdx++;
            } 
            // 3. Mismatch occurs, but we can backtrack to the last '*'
            else if (lastWildcardIdx != -1) {
                pIdx = lastWildcardIdx + 1;
                sBacktrackIdx++;
                sIdx = sBacktrackIdx;
            } 
            // 4. No match and no wildcard to save us
            else {
                return false;
            }
        }

        // Check if remaining characters in pattern are all '*'
        while (pIdx < pLen && p.charAt(pIdx) == '*') {
            pIdx++;
        }

        return pIdx == pLen;
    }
}
