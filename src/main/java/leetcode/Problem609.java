package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://leetcode.com/problems/find-duplicate-file-in-system/
 */
public class Problem609 {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        Pattern pattern = Pattern.compile("(.*)(\\(.*\\))");
        for (String path : paths) {
            String[] split = path.split(" ");
            for (int i = 1; i < split.length; i++) {
                Matcher matcher = pattern.matcher(split[i]);
                if (matcher.matches()) {
                    String file = matcher.group(1);
                    String content = matcher.group(2);
                    String fullPath = split[0] + "/" + file;
                    if (!map.containsKey(content)) {
                        List<String> list = new ArrayList<>();
                        list.add(fullPath);
                        map.put(content, list);
                    } else {
                        map.get(content).add(fullPath);
                    }
                }
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                result.add(entry.getValue());
            }
        }
        return result;
    }
}
