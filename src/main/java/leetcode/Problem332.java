package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/reconstruct-itinerary/
 */
public class Problem332 {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, TreeSet<Ticket>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            if (!map.containsKey(from)) {
                Ticket t = new Ticket(from, to);
                TreeSet<Ticket> set = new TreeSet<>();
                set.add(t);
                map.put(from, set);
            } else {
                map.get(from).add(new Ticket(from, to));
            }
        }
        List<String> result = new ArrayList<>();
        findItinerary(map, tickets.length, "JFK", 0, new HashSet<>(), result);
        result.add("JFK");
        Collections.reverse(result);
        return result;
    }

    private boolean findItinerary(Map<String, TreeSet<Ticket>> map, int max, String name,
                                  int count, Set<Ticket> visited, List<String> result) {
        if (count == max) {
            return true;
        }
        TreeSet<Ticket> tickets = map.get(name);
        if (tickets != null) {
            for (Ticket ticket : tickets) {
                if (visited.contains(ticket)) {
                    continue;
                }
                visited.add(ticket);
                boolean add = findItinerary(map, max, ticket.to, count + 1, visited, result);
                if (add) {
                    result.add(ticket.to);
                    return true;
                } else {
                    visited.remove(ticket);
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

    public static void main(String[] args) {
        Problem332 prob = new Problem332();
        System.out.println(prob.findItinerary(new String[][]{
            {"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}
        })); // [JFK, MUC, LHR, SFO, SJC]
        System.out.println(prob.findItinerary(new String[][]{
            {"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}
        })); // [JFK, ATL, JFK, SFO, ATL, SFO]
        System.out.println(prob.findItinerary(new String[][]{
            {"JFK", "KUL"}, {"JFK", "NRT"}, {"NRT", "JFK"}
        })); // [JFK, NRT, JFK, KUL]
    }
}
