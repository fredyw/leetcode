package leetcode;

public class Problem55 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        for (int i = 0; i < nums.length; i++) {
            if (canJump(nums, i)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean canJump(int[] nums, int idx) {
        int i = idx;
        while (i < nums.length) {
            if (nums[i] == 0) {
                return false;
            }
            int val = (nums.length-1) - i - nums[i];
            if (val == 0) {
                return true;
            }
            i += nums[i];
        }
        return false;
    }
    
    public static void main(String[] args) {
        Problem55 prob = new Problem55();
        System.out.println(prob.canJump(new int[]{2,3,1,1,4}));
        System.out.println(prob.canJump(new int[]{3,2,1,0,4}));
        System.out.println(prob.canJump(new int[]{2,0}));
        System.out.println(prob.canJump(new int[]{0}));
    }
}
