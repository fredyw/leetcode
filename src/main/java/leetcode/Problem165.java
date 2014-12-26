package leetcode;

/**
 * https://oj.leetcode.com/problems/compare-version-numbers/
 */
public class Problem165 {
    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        
        for (int i = 0; i < Math.max(ver1.length, ver2.length); i++) {
            int v1 = (i >= ver1.length) ? 0 : Integer.parseInt(ver1[i]);
            int v2 = (i >= ver2.length) ? 0 : Integer.parseInt(ver2[i]);
            System.out.println(v1 + " " + v2);
            if (v1 < v2) {
                return -1;
            } else if (v1 > v2) {
                return 1;
            }
        }
        return 0;
    }
}
