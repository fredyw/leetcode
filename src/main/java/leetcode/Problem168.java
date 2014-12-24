package leetcode;

public class Problem168 {
    public String convertToTitle(int n) {
        char[] alphabets = new char[26];
        for (int i = 0; i < alphabets.length; i++) {
            alphabets[i] = (char) (65 + i);
        }
        String result = "";
        int x = n;
        while (x != 0) {
            int y = x % alphabets.length;
            if (y == 0) {
                result = alphabets[alphabets.length-1] + result;
                x = (x / alphabets.length) - 1;
            } else {
                result = alphabets[y-1] + result;
                x = x / alphabets.length;
            }
        }
        return result;
    }
}
