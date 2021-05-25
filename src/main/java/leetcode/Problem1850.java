package leetcode;

/**
 * https://leetcode.com/problems/minimum-adjacent-swaps-to-reach-the-kth-smallest-number/
 */
public class Problem1850 {
    public int getMinSwaps(String num, int k) {
        String kthSmallest = getKthSmallest(num, k);
        int start = 0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) != kthSmallest.charAt(i)) {
                start = i;
                break;
            }
        }
        int answer = 0;
        String from = num.substring(start);
        String to = kthSmallest.substring(start);
        while (!from.equals(to)) {
            int i = 0;
            while (i < from.length() && from.charAt(i) != to.charAt(0)) {
                answer++;
                i++;
            }
            from = from.substring(0, i) + from.substring(i + 1);
            to = to.substring(1);
        }
        return answer;
    }

    private String getKthSmallest(String num, int k) {
        String str = num;
        char[] chars = num.toCharArray();
        for (int i = 0; i < k; i++) {
            int j = chars.length - 1;
            while (j - 1 >= 0 && chars[j - 1] >= chars[j]) {
                j--;
            }
            int indexToSwap = j - 1;
            int smallestLargerIndex = -1;
            for (int l = j; l < chars.length; l++) {
                if (chars[indexToSwap] < chars[l]) {
                    if (smallestLargerIndex == -1) {
                        smallestLargerIndex = l;
                    } else if (chars[smallestLargerIndex] >= chars[l]) {
                        smallestLargerIndex = l;
                    }
                }
            }
            swap(chars, indexToSwap, smallestLargerIndex);
            reverse(chars, j, chars.length - 1);
            str = new String(chars);
        }
        return str;
    }

    private static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    private static void reverse(char[] chars, int i, int j) {
        for (int a = i, b = j; a < b; a++, b--) {
            swap(chars, a, b);
        }
    }

    public static void main(String[] args) {
        Problem1850 prob = new Problem1850();
        System.out.println(prob.getMinSwaps("5489355142", 4)); // 2
        System.out.println(prob.getMinSwaps("5489355142", 12)); // 11
        System.out.println(prob.getMinSwaps("11112", 4)); // 4
        System.out.println(prob.getMinSwaps("00123", 1)); // 1
    }
}
