import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i = 0;
        
        while (i < words.length) {
            int lineLen = words[i].length();
            int last = i + 1;
            
            // Step 1: Find how many words fit in the current line
            while (last < words.length) {
                if (lineLen + 1 + words[last].length() > maxWidth) break;
                lineLen += 1 + words[last].length();
                last++;
            }
            
            StringBuilder sb = new StringBuilder();
            int wordCount = last - i;
            
            // Step 2: Last line OR only one word (Left Justify)
            if (last == words.length || wordCount == 1) {
                for (int j = i; j < last; j++) {
                    sb.append(words[j]);
                    if (j < last - 1) sb.append(" ");
                }
                while (sb.length() < maxWidth) sb.append(" ");
            } 
            // Step 3: Regular line (Full Justify)
            else {
                int spaces = maxWidth - (lineLen - (wordCount - 1));
                int spacesBetween = spaces / (wordCount - 1);
                int extraSpaces = spaces % (wordCount - 1);
                
                for (int j = i; j < last; j++) {
                    sb.append(words[j]);
                    if (j < last - 1) {
                        int currentSpaces = spacesBetween + (j - i < extraSpaces ? 1 : 0);
                        for (int k = 0; k < currentSpaces; k++) sb.append(" ");
                    }
                }
            }
            
            res.add(sb.toString());
            i = last;
        }
        
        return res;
    }
}
