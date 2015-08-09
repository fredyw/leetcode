package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Problem55 {
    public boolean canJump(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        stack.add(0);
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            if (idx == nums.length-1) {
                return true;
            }
            int val = nums[idx];
            for (int i = idx+1; i <= idx+val; i++) {
                if (i == nums.length-1) {
                    return true;
                }
                if (set.contains(i)) {
                    continue;
                }
                set.add(i);
                stack.push(i);
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        Problem55 prob = new Problem55();
        System.out.println(prob.canJump(new int[]{2,3,1,1,4})); // true
        System.out.println(prob.canJump(new int[]{3,2,1,0,4})); // false
        System.out.println(prob.canJump(new int[]{2,0})); // true
        System.out.println(prob.canJump(new int[]{0})); // true
        System.out.println(prob.canJump(new int[]{0,2,3})); // false
        System.out.println(prob.canJump(new int[]{1,0,1,0})); // false
    }
}
