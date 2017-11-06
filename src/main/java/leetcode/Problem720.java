package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/longest-word-in-dictionary/
 */
public class Problem720 {
    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> a.compareTo(b));
        String tmp = "";
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == 1) {
                if (!tmp.isEmpty()) {
                    result.add(tmp);
                }
                tmp = words[i];
            } else {
                if (tmp.length() + 1 == words[i].length() && words[i].startsWith(tmp)) {
                    tmp = words[i];
                }
            }
        }
        result.add(tmp);
        result.sort((a, b) -> {
            if (a.length() < b.length()) {
                return 1;
            } else if (a.length() > b.length()) {
                return -1;
            } else {
                return a.compareTo(b);
            }
        });
        return result.get(0);
    }

    public static void main(String[] args) {
        Problem720 prob = new Problem720();
//        System.out.println(prob.longestWord(new String[]{"w","wo","wor","worl", "world"})); // world
//        System.out.println(prob.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"})); // apple
//        System.out.println(prob.longestWord(new String[]{"a"})); // a
//        System.out.println(prob.longestWord(new String[]{"a", "b"})); // a
//        System.out.println(prob.longestWord(new String[]{"m", "mo", "moc", "moch", "mocha", "l", "la", "lat", "latt", "latte", "c", "ca", "cat"})); // latte
//        System.out.println(prob.longestWord(new String[]{"ogz","eyj","e","ey","hmn","v","hm","ogznkb","ogzn","hmnm","eyjuo","vuq","ogznk","og","eyjuoi","d"})); // eyj
//        System.out.println(prob.longestWord(new String[]{"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"})); // yodn
        System.out.println(prob.longestWord(new String[]{"rac","rs","ra","on","r","otif","o","onpdu","rsf","rs","ot","oti","racy","onpd"})); // otif
    }
}
