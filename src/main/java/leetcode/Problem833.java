package leetcode;

/**
 * https://leetcode.com/problems/find-and-replace-in-string/
 */
public class Problem833 {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
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
}
