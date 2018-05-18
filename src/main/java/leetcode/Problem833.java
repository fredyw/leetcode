package leetcode;

/**
 * https://leetcode.com/problems/find-and-replace-in-string/
 */
public class Problem833 {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indexes.length; i++) {
            String sub = S.substring(indexes[i]);
            int index = sub.indexOf(sources[i]);
            if (index >= 0) {
                sb.append(targets[i]);
            }
            if (i + 1 < indexes.length) {
                sb.append(S.substring(indexes[i] + sources[i].length(), indexes[i + 1]));
            } else if (i + 1 == indexes.length) {
                if (index < 0) {
                    sb.append(S.substring(indexes[i]));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem833 prob = new Problem833();
//        System.out.println(prob.findReplaceString("abcd", new int[]{0, 2}, new String[]{"a", "cd"},
//            new String[]{"eee", "ffff"})); // eeebffff
//        System.out.println(prob.findReplaceString("abcd", new int[]{0, 2}, new String[]{"ab", "ec"},
//            new String[]{"eee", "ffff"})); // eeecd
//        System.out.println(prob.findReplaceString("abcd", new int[]{0, 2}, new String[]{"ab", "fd"},
//            new String[]{"def", "xxx"})); // defcd
//        System.out.println(prob.findReplaceString("ab", new int[]{0, 1}, new String[]{"a", "b"},
//            new String[]{"xxx", "yyy"})); // xxxyyy
        System.out.println(prob.findReplaceString("vmokgggqzp", new int[]{3, 5, 1},
            new String[]{"kg", "ggq", "mo"}, new String[]{"s", "so", "bfr"})); // vbfrssozp
    }
}
