package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/delete-columns-to-make-sorted-ii/
 */
public class Problem955 {
    public int minDeletionSize(String[] A) {
        int n = A[0].length();
        int answer = 0;
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            boolean done = true;
            boolean remove = false;
            if (map.isEmpty()) {
                int prevIdx = 0;
                char prevValue = ' ';
                boolean first = true;
                for (int j = 0; j < A.length; j++) {
                    if (first) {
                        first = false;
                    } else {
                        if (prevValue > A[j].charAt(i)) {
                            remove = true;
                            map.clear();
                            done = false;
                            break;
                        } else if (prevValue == A[j].charAt(i)) {
                            List<Integer> list = map.get(prevValue);
                            if (list == null) {
                                list = new ArrayList<>();
                                map.put(prevValue, list);
                            }
                            // TODO
                            list.add(prevIdx);
                            list.add(j);
                            done = false;
                        }
                    }
                    prevIdx = j;
                    prevValue = A[j].charAt(i);
                }
                System.out.println(map);
            } else {
                Map<Character, List<Integer>> tmpMap = new HashMap<>();
                outer:
                for (List<Integer> indexes : map.values()) {
                    int prevIdx = 0;
                    char prevValue = ' ';
                    boolean first = true;
                    for (int idx : indexes) {
                        if (first) {
                            first = false;
                        } else {
                            if (prevValue > A[idx].charAt(i)) {
                                remove = true;
                                done = false;
                                break outer;
                            } else if (prevValue == A[idx].charAt(i)) {
                                List<Integer> list = tmpMap.get(prevValue);
                                if (list == null) {
                                    list = new ArrayList<>();
                                    tmpMap.put(prevValue, list);
                                }
                                // TODO
                                list.add(prevIdx);
                                list.add(idx);
                                done = false;
                            }
                        }
                        prevIdx = idx;
                        prevValue = A[idx].charAt(i);
                    }
                }
                map = tmpMap;
                System.out.println(map);
            }
            if (remove) {
                answer++;
            }
            if (done) {
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem955 prob = new Problem955();
//        System.out.println(prob.minDeletionSize(new String[]{"ca", "bb", "ac"})); // 1
//        System.out.println(prob.minDeletionSize(new String[]{"xc", "yb", "za"})); // 0
//        System.out.println(prob.minDeletionSize(new String[]{"zyx","wvu","tsr"})); // 3
//        System.out.println(prob.minDeletionSize(new String[]{"abcdef", "uvwxyz"})); // 0
//        System.out.println(prob.minDeletionSize(new String[]{"xga", "xfb", "yfa"})); // 1
//        System.out.println(prob.minDeletionSize(new String[]{"xac", "xbb", "yax"})); // 0
        System.out.println(prob.minDeletionSize(new String[]{"abx", "agz", "bgc", "bfc"})); // 1
//        System.out.println(prob.minDeletionSize(new String[]{"aby", "abx", "bcy", "bcx"})); // 1
    }
}
