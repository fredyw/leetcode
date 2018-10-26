package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/online-election/
 */
public class Problem911 {
    private static class TopVotedCandidate {
        private final Map<Integer /*time*/, Integer /*person*/> timePerson = new HashMap<>();
        private final TreeSet<Integer> timeSet = new TreeSet<>();

        public TopVotedCandidate(int[] persons, int[] times) {
            int maxPerson = 0;
            Map<Integer /*person*/, Integer /*count*/> personCount = new HashMap<>();
            for (int i = 0; i < times.length; i++) {
                timeSet.add(times[i]);
                int count = 0;
                if (!personCount.containsKey(persons[i])) {
                    count = 1;
                } else {
                    count = personCount.get(persons[i]) + 1;
                }
                personCount.put(persons[i], count);
                if (personCount.get(maxPerson) <= count) {
                    maxPerson = persons[i];
                }
                timePerson.put(times[i], maxPerson);
            }
        }

        public int q(int t) {
            Integer time = timeSet.floor(t);
            if (time == null) {
                time = timeSet.first();
            }
            return timePerson.get(time);
        }
    }

    public static void main(String[] args) {
        TopVotedCandidate candidate = new TopVotedCandidate(new int[]{0, 1, 1, 0, 0, 1, 0},
            new int[]{0, 5, 10, 15, 20, 25, 30});
        System.out.println(candidate.q(0)); // 0
        System.out.println(candidate.q(3)); // 0
        System.out.println(candidate.q(12)); // 1
        System.out.println(candidate.q(25)); // 1
        System.out.println(candidate.q(15)); // 0
        System.out.println(candidate.q(24)); // 0
        System.out.println(candidate.q(8)); // 1
        System.out.println(candidate.q(30)); // 0
        System.out.println(candidate.q(35)); // 0
    }
}
