package leetcode;

/**
 * https://leetcode.com/problems/nim-game/
 */
public class Problem292 {
    public boolean canWinNim(int n) {
        // https://en.wikipedia.org/wiki/Nim
        return !((n % 4) == 0);
    }
}
