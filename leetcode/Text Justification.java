import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int lineLength = words[i].length();
            int last = i + 1;
            
            // 1. Find how many words fit in the current line
            while (last < words.length) {
                if (lineLength + 1 + words[last].length() > maxWidth) break;
                lineLength += 1 + words[last].length();
                last++;
            }

            StringBuilder sb = new StringBuilder();
            int wordCount = last - i;
            int totalSpaces = maxWidth - (lineLength - (wordCount - 1));

            // 2. Case: Last line or only one word in the line (Left-Justified)
            if (last == words.length || wordCount == 1) {
                for (int j = i; j < last; j++) {
                    sb.append(words[j]);
                    if (j < last - 1) sb.append(" ");
                }
                while (sb.length() < maxWidth) sb.append(" ");
            } 
            // 3. Case: Normal line (Fully-Justified)
            else {
                int spacesBetween = totalSpaces / (wordCount - 1);
                int extraSpaces = totalSpaces % (wordCount - 1);

                for (int j = i; j < last; j++) {
                    sb.append(words[j]);
                    if (j < last - 1) {
                        int spacesToApply = spacesBetween + (j - i < extraSpaces ? 1 : 0);
                        for (int s = 0; s < spacesToApply; s++) sb.append(" ");
                    }
                }
            }

            result.add(sb.toString());
            i = last; // Move to the next set of words
        }

        return result;
    }
}
