package leetcode;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/elimination-game/
 */
public class Problem390 {
    public int lastRemaining(int n) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        Iterator<Integer> iterator = list.iterator();
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem390 prob = new Problem390();
        System.out.println(prob.lastRemaining(9)); // 6
    }
}
