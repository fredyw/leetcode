package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/text-justification/
 */
public class Problem68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int width = 0;
        int originalWidth = 0;
        int beg = 0;
        int end = 0;
        while (end < words.length) {
            originalWidth += words[end].length();
            width += words[end].length();
            if (width < maxWidth) { // for a space
                width++;
            }
            boolean skipEndIncrement = false;
            if (width >= maxWidth) {
                if (width != maxWidth) {
                    originalWidth -= words[end].length();
                } else {
                    skipEndIncrement = true;
                    end++;
                }
                String line = "";
                int diff = maxWidth - originalWidth;
                int sections = end - beg - 1;
                if (sections == 0) {
                    for (int i = beg; i < end; i++) {
                        line += words[i];
                        if (i < end - 1) {
                            line += " ";
                        }
                    }
                } else {
                    int spaces = diff / sections;
                    int spaceRemainder = diff % sections;
                    for (int i = beg; i < end; i++) {
                        line += words[i];
                        if (i < end - 1) {
                            for (int space = 0; space < spaces; space++) {
                                line += " ";
                            }
                            if (spaceRemainder > 0) {
                                line += " ";
                                spaceRemainder--;
                            }
                        }
                    }
                }
                while (line.length() < maxWidth) {
                    line += " ";
                }
                result.add(line);
                if (width != maxWidth) {
                    width = words[end].length();
                    if (width < maxWidth) {
                        width++;
                    }
                    originalWidth = words[end].length();
                } else {
                    width = 0;
                    originalWidth = 0;
                }
                beg = end;
            }
            if (!skipEndIncrement) {
                end++;
            }
        }
        String line = "";
        if (beg < end) {
            for (int i = beg; i < end; i++) {
                line += words[i];
                if (i < end - 1) {
                    line += " ";
                }
            }
            while (line.length() < maxWidth) {
                line += " ";
            }
            result.add(line);
        }
        return result;
    }
}
