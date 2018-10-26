package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/online-election/
 */
public class Problem911 {
    private static class TopVotedCandidate {
        private final int[] times;
        private final int[] timePerson;

        public TopVotedCandidate(int[] persons, int[] times) {
            this.times = times;
            int maxPerson = 0;
            timePerson = new int[times.length];
            Map<Integer /*person*/, Integer /*count*/> personCount = new HashMap<>();
            for (int i = 0; i < times.length; i++) {
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
                timePerson[i] = maxPerson;
            }
        }

        public int q(int t) {
            int index = Arrays.binarySearch(times, t);
            if (index < 0) {
                index = -index - 2;
            }
            return timePerson[index];
        }
    }
}
