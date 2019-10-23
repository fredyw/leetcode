package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/
 */
public class Problem1233 {
    public List<String> removeSubfolders(String[] folder) {
        Set<String> answer = new HashSet<>();
        for (String f : folder) {
            answer.add(f);
        }
        for (String f : folder) {
            String[] split = f.split("/");
            String tmp = "";
            for (int i = 1; i < split.length; i++) {
                tmp += "/" + split[i];
                if (!tmp.equals(f) && answer.contains(tmp)) {
                    answer.remove(f);
                    break;
                }
            }
        }
        return new ArrayList<>(answer);
    }
}
