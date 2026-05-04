import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int lineLength = words[i].length();
            int last = i + 1;

            // Group words for the current line
            while (last < words.length) {
                if (lineLength + 1 + words[last].length() > maxWidth) break;
                lineLength += 1 + words[last].length();
                last++;
            }

            StringBuilder sb = new StringBuilder();
            int numWords = last - i;
            int numSpaces = maxWidth - (lineLength - (numWords - 1));

            // Case 1: Last line or only one word in line (Left-justify)
            if (last == words.length || numWords == 1) {
                for (int j = i; j < last; j++) {
                    sb.append(words[j]);
                    if (j < last - 1) sb.append(' ');
                }
                while (sb.length() < maxWidth) sb.append(' ');
            } 
            // Case 2: Middle line (Fully-justify)
            else {
                int spacesBetween = numSpaces / (numWords - 1);
                int extraSpaces = numSpaces % (numWords - 1);

                for (int j = i; j < last; j++) {
                    sb.append(words[j]);
                    if (j < last - 1) {
                        int spacesToApply = spacesBetween + (j - i < extraSpaces ? 1 : 0);
                        for (int k = 0; k < spacesToApply; k++) sb.append(' ');
                    }
                }
            }

            result.add(sb.toString());
            i = last;
        }

        return result;
    }
}
