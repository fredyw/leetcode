package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/employee-importance/
 */
public class Problem690 {
    private static class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        private int id;
        // the importance value of this employee
        private int importance;
        // the id of direct subordinates
        private List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    };

    public int getImportance(List<Employee> employees, int id) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem690 prob = new Problem690();
        System.out.println(prob.getImportance(Arrays.asList(
            new Employee(1, 5, Arrays.asList(2, 3)),
            new Employee(2, 3, Collections.emptyList()),
            new Employee(3, 3, Collections.emptyList())),
            1)); // 11
    }
}
