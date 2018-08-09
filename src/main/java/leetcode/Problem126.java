package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-ladder-ii/
 */
public class Problem126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        Map<String, List<String>> path = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            String word = queue.remove();
            visited.add(word);
            List<String> neighbors = new ArrayList<>();
            for (int i = 0; i < word.length(); i++) {
                char[] chars = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    chars[i] = c;
                    String newWord = new String(chars);
                    if (words.contains(newWord) && !visited.contains(newWord)) {
                        neighbors.add(newWord);
                        queue.add(newWord);
                        List<String> list = path.get(newWord);
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(word);
                        path.put(newWord, list);
                    }
                }
            }
        }
        List<List<String>> result = new ArrayList<>();
        if (path.get(endWord) == null) {
            return result;
        }
        buildResult(path, endWord, Arrays.asList(endWord), result);
        return result;
    }

    private static void buildResult(Map<String, List<String>> path,
                                    String word,
                                    List<String> accu,
                                    List<List<String>> result) {
        List<String> words = path.get(word);
        if (words == null) {
            Collections.reverse(accu);
            result.add(accu);
            return;
        }
        for (String w : words) {
            List<String> newAccu = new ArrayList<>(accu);
            newAccu.add(w);
            buildResult(path, w, newAccu, result);
        }
    }

    public static void main(String[] args) {
        Problem126 prob = new Problem126();

        System.out.println(prob.findLadders("foo", "baz", Arrays.asList(
            "buz", "bug", "bud", "bar", "fuz", "foz", "faz", "gaz", "boz", "baz", "hoo"))); // [[foo, foz, boz, baz], [foo, foz, faz, baz]]
//
        System.out.println(prob.findLadders("bar", "baz", Arrays.asList(
            "buz", "bug", "bud", "bar", "fuz", "foz", "faz", "gaz", "boz", "baz"))); // [[bar, baz]]

        System.out.println(prob.findLadders("hit", "cog", Arrays.asList(
            "hot", "dot", "dog", "lot", "log", "cog"))); // [["hit","hot","dot","dog","cog"], ["hit","hot","lot","log","cog"]]

        System.out.println(prob.findLadders("hit", "cog", Arrays.asList(
            "hot", "dot", "dog", "lot", "log"))); // []

//        System.out.println(prob.findLadders("qa", "sq", Arrays.asList(
//            "si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av",
//            "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr",
//            "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as",
//            "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz",
//            "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st",
//            "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr",
//            "pa", "he", "lr", "sq", "ye"))); // [["qa","pa","pt","st","sq"],["qa","la","lt","st","sq"],["qa","ma","mt","st","sq"],["qa","ca","cr","sr","sq"],["qa","la","lr","sr","sq"],["qa","fa","fr","sr","sq"],["qa","ba","br","sr","sq"],["qa","ma","mr","sr","sq"],["qa","ca","ci","si","sq"],["qa","na","ni","si","sq"],["qa","la","li","si","sq"],["qa","ta","ti","si","sq"],["qa","pa","pi","si","sq"],["qa","ba","bi","si","sq"],["qa","ha","hi","si","sq"],["qa","ma","mi","si","sq"],["qa","pa","ph","sh","sq"],["qa","ra","rh","sh","sq"],["qa","ta","th","sh","sq"],["qa","ca","co","so","sq"],["qa","ga","go","so","sq"],["qa","ta","to","so","sq"],["qa","na","no","so","sq"],["qa","la","lo","so","sq"],["qa","pa","po","so","sq"],["qa","ya","yo","so","sq"],["qa","ma","mo","so","sq"],["qa","ha","ho","so","sq"],["qa","la","ln","sn","sq"],["qa","ra","rn","sn","sq"],["qa","ma","mn","sn","sq"],["qa","ca","cm","sm","sq"],["qa","ta","tm","sm","sq"],["qa","pa","pm","sm","sq"],["qa","fa","fm","sm","sq"],["qa","ta","tc","sc","sq"],["qa","na","nb","sb","sq"],["qa","pa","pb","sb","sq"],["qa","ra","rb","sb","sq"],["qa","ya","yb","sb","sq"],["qa","ma","mb","sb","sq"],["qa","ta","tb","sb","sq"],["qa","ga","ge","se","sq"],["qa","la","le","se","sq"],["qa","na","ne","se","sq"],["qa","ra","re","se","sq"],["qa","ba","be","se","sq"],["qa","ya","ye","se","sq"],["qa","fa","fe","se","sq"],["qa","ha","he","se","sq"],["qa","ma","me","se","sq"]]

    }
}
