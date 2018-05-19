package leetcode;

/**
 * https://leetcode.com/problems/find-and-replace-in-string/
 */
public class Problem833 {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < indexes.length; i++) {
//            String sub = S.substring(indexes[i]);
//            int index = sub.indexOf(sources[i]);
//            if (index >= 0) {
//                sb.append(targets[i]);
//            }
//            if (i + 1 < indexes.length) {
//                sb.append(S.substring(indexes[i] + sources[i].length(), indexes[i + 1]));
//            } else if (i + 1 == indexes.length) {
//                if (index < 0) {
//                    sb.append(S.substring(indexes[i]));
//                }
//            }
//        }
        SourceTarget[] array = new SourceTarget[S.length()];
        for (int i = 0; i < indexes.length; i++) {
            array[indexes[i]] = new SourceTarget(sources[i], targets[i]);
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < S.length()) {
            if (array[i] != null) {
                SourceTarget st = array[i];
                String sub = S.substring(i);
                if (sub.startsWith(st.source)) {
                    sb.append(st.target);
                    i += st.source.length();
                } else {
                    sb.append(S.charAt(i++));
                }
            } else {
                sb.append(S.charAt(i++));
            }
        }
        return sb.toString();
    }

    private static class SourceTarget {
        private final String source;
        private final String target;

        public SourceTarget(String source, String target) {
            this.source = source;
            this.target = target;
        }
    }

    public static void main(String[] args) {
        Problem833 prob = new Problem833();
        System.out.println(prob.findReplaceString("abcd", new int[]{0, 2}, new String[]{"a", "cd"},
            new String[]{"eee", "ffff"})); // eeebffff
        System.out.println(prob.findReplaceString("abcd", new int[]{0, 2}, new String[]{"ab", "ec"},
            new String[]{"eee", "ffff"})); // eeecd
        System.out.println(prob.findReplaceString("abcd", new int[]{0, 2}, new String[]{"ab", "fd"},
            new String[]{"def", "xxx"})); // defcd
        System.out.println(prob.findReplaceString("ab", new int[]{0, 1}, new String[]{"a", "b"},
            new String[]{"xxx", "yyy"})); // xxxyyy
        System.out.println(prob.findReplaceString("vmokgggqzp", new int[]{3, 5, 1},
            new String[]{"kg", "ggq", "mo"}, new String[]{"s", "so", "bfr"})); // vbfrssozp
    }
}
