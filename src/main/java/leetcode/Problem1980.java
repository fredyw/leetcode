package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/find-unique-binary-string/
 */
public class Problem1980 {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<>();
        for (String num : nums) {
            set.add(num);
        }
        return findDifferentBinaryString(set, 0, new char[nums.length]);
    }

    private static String findDifferentBinaryString(Set<String> nums, int index, char[] chars) {
        if (index == nums.size()) {
            String s = new String(chars);
            if (nums.contains(s)) {
                return null;
            }
            return s;
        }
        for (char c : new char[]{'0', '1'}){
            char tmp = chars[index];
            chars[index] = c;
            String s = findDifferentBinaryString(nums, index + 1, chars);
            if (s != null) {
                return s;
            }
            chars[index] = tmp; // Backtrack.
        }
        return null;
    }
}
