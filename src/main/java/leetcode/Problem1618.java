package leetcode;

// https://leetcode.com/problems/maximum-font-to-fit-a-sentence-in-a-screen/
public class Problem1618 {
    public interface FontInfo {
        // Return the width of char ch when fontSize is used.
        int getWidth(int fontSize, char ch);

        // Return Height of any char when fontSize is used.
        int getHeight(int fontSize);
    }

    public int maxFont(String text, int w, int h, int[] fonts, FontInfo fontInfo) {
        int left = 0;
        int right = fonts.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int height = fontInfo.getHeight(fonts[mid]);
            int totalWidth = getTotalWidth(text, fonts[mid], fontInfo);
            if (height <= h && totalWidth <= w) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right < 0 ? -1 : fonts[right];
    }

    private static int getTotalWidth(String text, int fontSize, FontInfo fontInfo) {
        return text.chars().map(c -> fontInfo.getWidth(fontSize, (char) c)).sum();
    }
}
