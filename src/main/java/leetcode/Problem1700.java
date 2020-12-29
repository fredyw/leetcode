package leetcode;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
 */
public class Problem1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        LinkedList<Integer> studentList = new LinkedList<>();
        int zeroCount = 0;
        int oneCount = 0;
        for (int student : students) {
            if (student == 0) {
                zeroCount++;
            } else {
                oneCount++;
            }
            studentList.addLast(student);
        }
        int index = 0;
        while (index < sandwiches.length) {
            if ((zeroCount == 0 && sandwiches[index] == 0) ||
                (oneCount == 0 && sandwiches[index] == 1)) {
                break;
            }
            if (studentList.peekFirst() == sandwiches[index]) {
                int student = studentList.removeFirst();
                if (student == 0) {
                    zeroCount--;
                } else {
                    oneCount--;
                }
                index++;
            } else {
                studentList.addLast(studentList.removeFirst());
            }
        }
        return studentList.size();
    }
}
