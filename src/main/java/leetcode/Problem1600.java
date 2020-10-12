package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/throne-inheritance/
 */
public class Problem1600 {
    static class ThroneInheritance {
        public ThroneInheritance(String kingName) {
            // TODO
        }

        public void birth(String parentName, String childName) {
            // TODO
        }

        public void death(String name) {
            // TODO
        }

        public List<String> getInheritanceOrder() {
            // TODO
            return null;
        }
    }

    public static void main(String[] args) {
        Problem1600 prob = new Problem1600();
        ThroneInheritance t= new ThroneInheritance("king"); // order: king
        t.birth("king", "andy"); // order: king > andy
        t.birth("king", "bob"); // order: king > andy > bob
        t.birth("king", "catherine"); // order: king > andy > bob > catherine
        t.birth("andy", "matthew"); // order: king > andy > matthew > bob > catherine
        t.birth("bob", "alex"); // order: king > andy > matthew > bob > alex > catherine
        t.birth("bob", "asha"); // order: king > andy > matthew > bob > alex > asha > catherine
        System.out.println(t.getInheritanceOrder()); // return ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"]
        t.death("bob"); // order: king > andy > matthew > bob > alex > asha > catherine
        System.out.println(t.getInheritanceOrder()); // return ["king", "andy", "matthew", "alex", "asha", "catherine"]
    }
}
