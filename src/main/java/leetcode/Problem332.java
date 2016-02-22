package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * https://leetcode.com/problems/reconstruct-itinerary/
 */
public class Problem332 {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, List<Ticket>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            if (!map.containsKey(from)) {
                Ticket t = new Ticket(from, to);
                List<Ticket> list = new ArrayList<>();
                list.add(t);
                map.put(from, list);
            } else {
                map.get(from).add(new Ticket(from, to));
            }
        }
        for (Map.Entry<String, List<Ticket>> entry : map.entrySet()) {
            Collections.sort(entry.getValue());
        }
        List<String> result = new ArrayList<>();
        findItinerary(map, tickets.length, "JFK", 0, result);
        result.add("JFK");
        Collections.reverse(result);
        return result;
    }

    private boolean findItinerary(Map<String, List<Ticket>> map, int max, String name,
                                  int count, List<String> result) {
        if (count == max) {
            return true;
        }
        List<Ticket> tickets = map.get(name);
        if (tickets != null) {
            for (int i = 0; i < tickets.size(); i++) {
                Ticket ticket = tickets.remove(i);
                boolean add = findItinerary(map, max, ticket.to, count + 1, result);
                if (add) {
                    result.add(ticket.to);
                    return true;
                } else {
                    tickets.add(i, ticket);
                }
            }
        }
        return false;
    }

    private static class Ticket implements Comparable<Ticket> {
        private final String from;
        private final String to;

        public Ticket(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public int compareTo(Ticket o) {
            return to.compareTo(o.to);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Ticket ticket = (Ticket) o;
            return Objects.equals(from, ticket.from) &&
                Objects.equals(to, ticket.to);
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, to);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("[").append(from).append(", ").append(to).append("]");
            return sb.toString();
        }
    }
}
