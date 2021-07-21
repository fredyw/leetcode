package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-the-winner-of-the-circular-game/
 */
public class Problem1823 {
    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int i = 0;
        while (list.size() > 1) {
            i = (i + k - 1) % list.size();
            list.remove(i);
        }
        return list.get(0);
    }
}
