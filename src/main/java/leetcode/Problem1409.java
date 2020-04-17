package leetcode;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/queries-on-a-permutation-with-key/
 */
public class Problem1409 {
    public int[] processQueries(int[] queries, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            list.add(i + 1);
        }
        int[] answer = new int[queries.length];
        int index = 0;
        for (int query : queries) {
            Iterator<Integer> iterator = list.iterator();
            int i = 0;
            while (iterator.hasNext()) {
                int n = iterator.next();
                if (n == query) {
                    iterator.remove();
                    list.addFirst(n);
                    answer[index++] = i;
                    break;
                }
                i++;
            }
        }
        return answer;
    }
}
