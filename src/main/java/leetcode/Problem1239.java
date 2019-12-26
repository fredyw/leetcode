package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
 */
public class Problem1239 {
    public int maxLength(List<String> arr) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1239 prob = new Problem1239();
        System.out.println(prob.maxLength(Arrays.asList("un","iq","ue"))); // 4
        System.out.println(prob.maxLength(Arrays.asList("cha","r","act","ers"))); // 6
        System.out.println(prob.maxLength(Arrays.asList("abcdefghijklmnopqrstuvwxyz"))); // 26
    }
}
