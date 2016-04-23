package leetcode;

/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 */
public class Problem345 {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int leftIdx = 0;
        int rightIdx = chars.length - 1;
        int leftVowelIdx = 0;
        int rightVowelIdx = rightIdx;
        while (leftIdx <= rightIdx) {
            boolean leftVowel = false;
            while (leftIdx <= rightIdx) {
                if (isVowel(chars[leftIdx])) {
                    leftVowel = true;
                    leftVowelIdx = leftIdx;
                    break;
                }
                leftIdx++;
            }
            boolean rightVowel = false;
            while (rightIdx >= leftIdx) {
                if (isVowel(chars[rightIdx])) {
                    rightVowel = true;
                    rightVowelIdx = rightIdx;
                    break;
                }
                rightIdx--;
            }
            if (leftVowel && rightVowel) {
                char tmp = chars[leftVowelIdx];
                chars[leftVowelIdx] = chars[rightIdx];
                chars[rightVowelIdx] = tmp;
            }
            leftIdx++;
            rightIdx--;
        }
        return new String(chars);
    }

    private boolean isVowel(char c) {
        return (c == 'a' || c == 'i' || c == 'u' || c == 'e' || c == 'o' ||
                c == 'A' || c == 'I' || c == 'U' || c == 'E' || c == 'O');
    }
}
