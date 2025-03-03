package leetcode;

// https://leetcode.com/problems/maximum-font-to-fit-a-sentence-in-a-screen/
public class Problem1618 {
    interface FontInfo {
        // Return the width of char ch when fontSize is used.
        int getWidth(int fontSize, char ch);

        // Return Height of any char when fontSize is used.
        int getHeight(int fontSize);
    }

    public int maxFont(String text, int w, int h, int[] fonts, FontInfo fontInfo) {
        // TODO
        return 0;
    }
}
