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
        Integer last = null;
        boolean delete = true;
        boolean asc = true;
        while (iterator.hasNext()) {
            while (iterator.hasNext()) {
                last = iterator.next();
                if (delete) {
                    iterator.remove();
                }
                delete = !delete;
            }
            if (asc) {
                iterator = list.descendingIterator();
            } else {
                iterator = list.iterator();
            }
            asc = !asc;
            delete = true;
        }
        return last;
    }

    public static void main(String[] args) {
        Problem390 prob = new Problem390();
        System.out.println(prob.lastRemaining(9)); // 6
        System.out.println(prob.lastRemaining(10)); // 8
        System.out.println(prob.lastRemaining(5)); // 2
        System.out.println(prob.lastRemaining(10000000)); // 6150102
    }
}
