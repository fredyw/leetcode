package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/invalid-transactions/
 */
public class Problem1169 {
    public List<String> invalidTransactions(String[] transactions) {
        Set<Integer> invalid = new HashSet<>();
        TreeSet<Transaction> set = new TreeSet<>();
        for (int i = 0; i < transactions.length; i++) {
            String[] t = transactions[i].split(",");
            String name = t[0];
            int time = Integer.parseInt(t[1]);
            int amount = Integer.parseInt(t[2]);
            String city = t[3];
            set.add(new Transaction(i, name, time, amount, city));
            if (amount > 1000) {
                invalid.add(i);
            }
        }
        for (Transaction t1 : set) {
            NavigableSet<Transaction> within60Mins = set.subSet(
                t1, true, /* we only care about t1.time + 60 */
                new Transaction(0, "", t1.time + 60, 0, ""), true);
            for (Transaction t2 : within60Mins) {
                if (t1.name.equals(t2.name) && !t1.city.equals(t2.city)) {
                    invalid.add(t1.index);
                    invalid.add(t2.index);
                }
            }
        }
        List<String> answer = new ArrayList<>();
        for (int i : invalid) {
            answer.add(transactions[i]);
        }
        return answer;
    }

    private static class Transaction implements Comparable<Transaction> {
        private final int index;
        private final String name;
        private final int time;
        private final int amount;
        private final String city;

        public Transaction(int index, String name, int time, int amount, String city) {
            this.index = index;
            this.name = name;
            this.time = time;
            this.amount = amount;
            this.city = city;
        }

        @Override
        public int compareTo(Transaction o) {
            return Integer.compare(time, o.time);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Transaction that = (Transaction) o;
            return index == that.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index);
        }
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
        System.out.println(prob.invalidTransactions(new String[]{
            "alice,5,100,beijing","alice,50,100,beijing"})); // []
        System.out.println(prob.invalidTransactions(new String[]{
            "alice,5,100,beijing","alice,50,100,beijing","alice,80,800,mtv"})); // ["alice,50,100,beijing","alice,80,800,mtv"]
    }
}
