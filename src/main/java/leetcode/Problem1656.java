package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/design-an-ordered-stream/
 */
public class Problem1656 {
    static class OrderedStream {
        public OrderedStream(int n) {
            // TODO
        }

        public List<String> insert(int id, String value) {
            // TODO
            return null;
        }
    }


    public static void main(String[] args) {
        OrderedStream os= new OrderedStream(5);
        os.insert(3, "ccccc"); // Inserts (3, "ccccc"), returns [].
        os.insert(1, "aaaaa"); // Inserts (1, "aaaaa"), returns ["aaaaa"].
        os.insert(2, "bbbbb"); // Inserts (2, "bbbbb"), returns ["bbbbb", "ccccc"].
        os.insert(5, "eeeee"); // Inserts (5, "eeeee"), returns [].
        os.insert(4, "ddddd"); // Inserts (4, "ddddd"), returns ["ddddd", "eeeee"].
    }
}
