package leetcode;

/**
 * https://leetcode.com/problems/1-bit-and-2-bit-characters/
 */
public class Problem717 {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        boolean found = false;
        while (i < bits.length) {
            if (bits[i] == 1) {
               i += 2;
               found = false;
            } else {
                i++;
                found = true;
            }
        }
        return found;
    }
}
