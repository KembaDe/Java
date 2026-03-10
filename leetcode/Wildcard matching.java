#include <string>
using namespace std;

class Solution {
public:
    bool isMatch(string s, string p) {
        int sIdx = 0, pIdx = 0, lastWildcardIdx = -1, sBacktrackIdx = -1;
        int sLen = s.length(), pLen = p.length();

        while (sIdx < sLen) {
            // Case 1: Characters match or pattern has '?'
            if (pIdx < pLen && (p[pIdx] == s[sIdx] || p[pIdx] == '?')) {
                sIdx++;
                pIdx++;
            }
            // Case 2: Pattern has '*', mark this spot for potential backtracking
            else if (pIdx < pLen && p[pIdx] == '*') {
                lastWildcardIdx = pIdx;
                sBacktrackIdx = sIdx;
                pIdx++; // Move pattern pointer, assume '*' matches empty sequence for now
            }
            // Case 3: Mismatch, but we saw a '*' earlier
            else if (lastWildcardIdx != -1) {
                pIdx = lastWildcardIdx + 1; // Reset pattern to just after the '*'
                sBacktrackIdx++;            // Increase the scope of the '*' match
                sIdx = sBacktrackIdx;       // Restart string matching from new backtrack point
            }
            // Case 4: Mismatch and no '*' to save us
            else {
                return false;
            }
        }

        // Check for remaining characters in pattern (only '*' can remain)
        while (pIdx < pLen && p[pIdx] == '*') {
            pIdx++;
        }

        return pIdx == pLen;
    }
};
