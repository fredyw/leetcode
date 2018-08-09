package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-ladder-ii/
 */
public class Problem126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();
        Min min = new Min();
        findLadders(beginWord, endWord, words, new ArrayList<>(), min, result);
        Iterator<List<String>> iter = result.iterator();
        while (iter.hasNext()) {
            List<String> list = iter.next();
            if (list.size() != min.val) {
                iter.remove();
            }
        }
        return result;
    }

    private static class Min {
        private int val = Integer.MAX_VALUE;
    }

    private static void findLadders(String startWord,
                                    String endWord,
                                    Set<String> words,
                                    List<String> accu,
                                    Min min,
                                    List<List<String>> result) {
        accu.add(startWord);
        for (int i = 0; i < startWord.length(); i++) {
            char[] chars = startWord.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String newString = new String(chars);
                if (newString.equals(endWord) && words.contains(endWord)) {
                    accu.add(endWord);
                    result.add(accu);
                    min.val = Math.min(min.val, accu.size());
                    return;
                }
                if (words.contains(newString)) {
                    List<String> newAccu = new ArrayList<>(accu);
                    words.remove(newString);
                    findLadders(newString, endWord, words, newAccu, min, result);
                    words.add(newString);
                }
            }
        }
    }

    public static void main(String[] args) {
        Problem126 prob = new Problem126();

//        System.out.println(prob.findLadders("foo", "baz", Arrays.asList(
//            "buz", "bug", "bud", "bar", "fuz", "foz", "faz", "gaz", "boz", "baz"))); // [[foo, foz, boz, baz], [foo, foz, faz, baz]]
//
//        System.out.println(prob.findLadders("bar", "baz", Arrays.asList(
//            "buz", "bug", "bud", "bar", "fuz", "foz", "faz", "gaz", "boz", "baz"))); // [[bar, baz]]
//
//        System.out.println(prob.findLadders("hit", "cog", Arrays.asList(
//            "hot", "dot", "dog", "lot", "log", "cog"))); // [["hit","hot","dot","dog","cog"], ["hit","hot","lot","log","cog"]]
//
//        System.out.println(prob.findLadders("hit", "cog", Arrays.asList(
//            "hot", "dot", "dog", "lot", "log"))); // []

        System.out.println(prob.findLadders("qa", "sq", Arrays.asList(
            "si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av",
            "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr",
            "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as",
            "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz",
            "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st",
            "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr",
            "pa", "he", "lr", "sq", "ye"))); // [["qa","pa","pt","st","sq"],["qa","la","lt","st","sq"],["qa","ma","mt","st","sq"],["qa","ca","cr","sr","sq"],["qa","la","lr","sr","sq"],["qa","fa","fr","sr","sq"],["qa","ba","br","sr","sq"],["qa","ma","mr","sr","sq"],["qa","ca","ci","si","sq"],["qa","na","ni","si","sq"],["qa","la","li","si","sq"],["qa","ta","ti","si","sq"],["qa","pa","pi","si","sq"],["qa","ba","bi","si","sq"],["qa","ha","hi","si","sq"],["qa","ma","mi","si","sq"],["qa","pa","ph","sh","sq"],["qa","ra","rh","sh","sq"],["qa","ta","th","sh","sq"],["qa","ca","co","so","sq"],["qa","ga","go","so","sq"],["qa","ta","to","so","sq"],["qa","na","no","so","sq"],["qa","la","lo","so","sq"],["qa","pa","po","so","sq"],["qa","ya","yo","so","sq"],["qa","ma","mo","so","sq"],["qa","ha","ho","so","sq"],["qa","la","ln","sn","sq"],["qa","ra","rn","sn","sq"],["qa","ma","mn","sn","sq"],["qa","ca","cm","sm","sq"],["qa","ta","tm","sm","sq"],["qa","pa","pm","sm","sq"],["qa","fa","fm","sm","sq"],["qa","ta","tc","sc","sq"],["qa","na","nb","sb","sq"],["qa","pa","pb","sb","sq"],["qa","ra","rb","sb","sq"],["qa","ya","yb","sb","sq"],["qa","ma","mb","sb","sq"],["qa","ta","tb","sb","sq"],["qa","ga","ge","se","sq"],["qa","la","le","se","sq"],["qa","na","ne","se","sq"],["qa","ra","re","se","sq"],["qa","ba","be","se","sq"],["qa","ya","ye","se","sq"],["qa","fa","fe","se","sq"],["qa","ha","he","se","sq"],["qa","ma","me","se","sq"]]

    }
}
