package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/repeated-dna-sequences/
 */
public class Problem187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        // TODO
        return result;
    }

    public static void main(String[] args) {
        Problem187 prob = new Problem187();
//                                                             CCCCCAAAAA CCCCCAAAAA
//                                                       AAAAACCCCC AAAAACCCCC
        System.out.println(prob.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
