package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/print-words-vertically/
 */
public class Problem1324 {
    public List<String> printVertically(String s) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1324 prob = new Problem1324();
        System.out.println(prob.printVertically("HOW ARE YOU")); // ["HAY","ORO","WEU"]
        System.out.println(prob.printVertically("TO BE OR NOT TO BE")); // ["TBONTB","OEROOE","   T"]
        System.out.println(prob.printVertically("CONTEST IS COMING")); // ["CIC","OSO","N M","T I","E N","S G","T"]
    }
}
