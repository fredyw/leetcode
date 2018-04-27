package leetcode;

/**
 * https://leetcode.com/problems/short-encoding-of-words/
 */
public class Problem820 {
    public int minimumLengthEncoding(String[] words) {
        Node[] nodes = new Node[26];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int idx = word.length() - 1;
            char ch = word.charAt(idx);
            if (nodes[ch - 'a'] == null) {
                nodes[ch - 'a'] = new Node();
            }
            add(nodes[ch - 'a'], word, idx - 1);
        }
        int result = 0;
        for (Node node : nodes) {
            if (node != null) {
                result += count(node, 0);
            }
        }
        return result;
    }

    private static int count(Node node, int accu) {
        int count = 0;
        for (Node child : node.children) {
            if (child != null) {
                count++;
            }
        }
        if (count == 0) {
            return accu;
        }
        int result = 0;
        if (count > 0) {
            for (Node child : node.children) {
                if (child != null) {
                    result += count(child, count + 1) + 1;
                }
            }
        }
        return result;
    }

    private static void add(Node node, String word, int idx) {
        if (idx < 0) {
            return;
        }
        char ch = word.charAt(idx);
        if (node.children[ch - 'a'] == null) {
            node.children[ch - 'a'] = new Node();
        }
        add(node.children[ch - 'a'], word, idx - 1);
    }

    private static class Node {
        private final Node[] children = new Node[26];
    }

    public static void main(String[] args) {
        Problem820 prob = new Problem820();
//        System.out.println(prob.minimumLengthEncoding(new String[]{"time", "me", "bell"})); // 10
//        System.out.println(prob.minimumLengthEncoding(new String[]{"me", "bell", "time"})); // 10
        System.out.println(prob.minimumLengthEncoding(new String[]{"me", "bell", "time", "tame"})); // 15
//        System.out.println(prob.minimumLengthEncoding(new String[]{"time", "men"})); // 9
//        System.out.println(prob.minimumLengthEncoding(new String[]{"time", "tim"})); // 9
//        System.out.println(prob.minimumLengthEncoding(new String[]{"time", "im"})); // 8
//        System.out.println(prob.minimumLengthEncoding(new String[]{"me", "time"})); // 5
    }
}
