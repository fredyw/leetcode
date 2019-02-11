package leetcode;

/**
 * https://leetcode.com/problems/satisfiability-of-equality-equations/
 */
public class Problem990 {
    public boolean equationsPossible(String[] equations) {
        int[] nums = new int[26];
        int num = 1;
        for (String equation : equations) {
            char left = equation.charAt(0);
            char right = equation.charAt(3);
            if (equation.substring(1, 3).equals("==")) {
                if (nums[left - 'a'] == 0 && nums[right - 'a'] == 0) {
                    nums[left - 'a'] = num;
                    nums[right - 'a'] = num++;
                } else if (nums[left - 'a'] == 0) {
                    nums[left - 'a'] = nums[right - 'a'];
                } else if (nums[right - 'a'] == 0) {
                    nums[right - 'a'] = nums[left - 'a'];
                }
                if (nums[left - 'a'] != nums[right - 'a']) {
                    return false;
                }
            } else {
                if (nums[left - 'a'] == 0 && nums[right - 'a'] == 0) {
                    nums[left - 'a'] = num++;
                    nums[right - 'a'] = num++;
                } else if (nums[left - 'a'] == 0) {
                    nums[left - 'a'] = num++;
                } else if (nums[right - 'a'] == 0) {
                    nums[right - 'a'] = num++;
                }
                if (nums[left - 'a'] == nums[right - 'a']) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem990 prob = new Problem990();
//        System.out.println(prob.equationsPossible(new String[]{"a==b", "b!=a"})); // false
//        System.out.println(prob.equationsPossible(new String[]{"b==a", "a==b"})); // true
//        System.out.println(prob.equationsPossible(new String[]{"a==b", "b==c", "a==c"})); // true
//        System.out.println(prob.equationsPossible(new String[]{"a==b", "b!=c", "c==a"})); // false
//        System.out.println(prob.equationsPossible(new String[]{"c==c", "b==d", "x!=z"})); // true
        System.out.println(prob.equationsPossible(new String[]{"c==c", "f!=a", "f==b", "b==c"})); // true
    }
}
