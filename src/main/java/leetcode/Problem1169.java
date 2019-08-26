package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/invalid-transactions/
 */
public class Problem1169 {
    public List<String> invalidTransactions(String[] transactions) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1169 prob = new Problem1169();
        System.out.println(prob.invalidTransactions(new String[]{
            "alice,20,800,mtv","alice,50,100,beijing"})); // ["alice,20,800,mtv","alice,50,100,beijing"]
        System.out.println(prob.invalidTransactions(new String[]{
            "alice,20,800,mtv","alice,50,100,beijing","alice,5,100,beijing"})); // ["alice,20,800,mtv","alice,50,100,beijing","alice,5,100,beijing"]
        System.out.println(prob.invalidTransactions(new String[]{
            "alice,20,800,mtv","alice,50,1200,mtv"})); // ["alice,50,1200,mtv"]
        System.out.println(prob.invalidTransactions(new String[]{
            "alice,20,800,mtv","bob,50,1200,mtv"})); // ["bob,50,1200,mtv"]
    }
}
