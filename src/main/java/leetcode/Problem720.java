package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-word-in-dictionary/
 */
public class Problem720 {
    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> {
            int cmp = Integer.compare(b.length(), a.length());
            if (cmp == 0) {
                return a.compareTo(b);
            }
            return cmp;
        });
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }
        for (String word : words) {
            boolean found = true;
            String tmp = "";
            for (int i = 0; i < word.length(); i++) {
                tmp += word.charAt(i);
                if (!set.contains(tmp)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return word;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Problem720 prob = new Problem720();
        System.out.println(prob.longestWord(new String[]{"w","wo","wor","worl", "world"})); // world
        System.out.println(prob.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"})); // apple
        System.out.println(prob.longestWord(new String[]{"a"})); // a
        System.out.println(prob.longestWord(new String[]{"a", "b"})); // a
        System.out.println(prob.longestWord(new String[]{"m", "mo", "moc", "moch", "mocha", "l", "la", "lat", "latt", "latte", "c", "ca", "cat"})); // latte
        System.out.println(prob.longestWord(new String[]{"ogz","eyj","e","ey","hmn","v","hm","ogznkb","ogzn","hmnm","eyjuo","vuq","ogznk","og","eyjuoi","d"})); // eyj
        System.out.println(prob.longestWord(new String[]{"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"})); // yodn
        System.out.println(prob.longestWord(new String[]{"rac","rs","ra","on","r","otif","o","onpdu","rsf","rs","ot","oti","racy","onpd"})); // otif
    }
}
