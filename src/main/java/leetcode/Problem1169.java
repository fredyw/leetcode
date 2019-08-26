package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/invalid-transactions/
 */
public class Problem1169 {
    public List<String> invalidTransactions(String[] transactions) {
        Transaction[] trans = new Transaction[transactions.length];
        for (int i = 0; i < transactions.length; i++) {
            String[] t1 = transactions[i].split(",");
            String name = t1[0];
            int time = Integer.parseInt(t1[1]);
            int amount = Integer.parseInt(t1[2]);
            String city = t1[3];
            trans[i] = new Transaction(name, time, amount, city);
        }
        Set<Integer> invalid = new HashSet<>();
        for (int i = 0; i < trans.length; i++) {
            if (trans[i].amount > 1000) {
                invalid.add(i);
            }
            for (int j = i + 1; j < trans.length; j++) {
                if (trans[i].name.equals(trans[j].name) &&
                    !trans[i].city.equals(trans[j].city) &&
                    Math.abs(trans[i].time - trans[j].time) <= 60) {
                    invalid.add(i);
                    invalid.add(j);
                }
            }
        }
        List<String> answer = new ArrayList<>();
        for (int i : invalid) {
            answer.add(transactions[i]);
        }
        return answer;
    }

    private static class Transaction {
        private final String name;
        private final int time;
        private final int amount;
        private final String city;

        public Transaction(String name, int time, int amount, String city) {
            this.name = name;
            this.time = time;
            this.amount = amount;
            this.city = city;
        }
    }
}
