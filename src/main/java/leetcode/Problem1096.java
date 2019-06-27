package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/brace-expansion-ii/
 */
public class Problem1096 {
    public List<String> braceExpansionII(String expression) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1096 prob = new Problem1096();
        System.out.println(prob.braceExpansionII("{a{b,c}d{e,f}}")); // ["abde",abdf","acde","acdf"]
//        System.out.println(prob.braceExpansionII("a{b,c}")); // ["ab","ac"]
//        System.out.println(prob.braceExpansionII("{c{d,e}f}")); // ["cdf","cef"]
//        System.out.println(prob.braceExpansionII("{a,b}{c{d,e}}")); // ["acd","ace","bcd","bce"]
//        System.out.println(prob.braceExpansionII("{{a,z},a{b,c},{ab,z}}")); // ["a","ab","ac","z"]
//        System.out.println(prob.braceExpansionII("{a,b,c}")); // ["a","b","c"]
//        System.out.println(prob.braceExpansionII("{{a,b},{b,c}}")); // ["a","b","c"]
//        System.out.println(prob.braceExpansionII("{a,b}{c,d}")); // ["ac","ad","bc","bd"]
//        System.out.println(prob.braceExpansionII("{a{b,c}}{{d,e}f{g,h}}")); // ["abdfg", "abdfh", "abefg", "abefh", "acdfg", "acdfh", "acefg", "acefh"]
    }
}
