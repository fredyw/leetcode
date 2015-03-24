package leetcode;

/**
 * https://leetcode.com/problems/gas-station/
 */
public class Problem134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        for (int g : gas) {
            totalGas += g;
        }
        for (int c : cost) {
            totalCost += c;
        }
        if (totalCost > totalGas) {
            return -1;
        }
        int[] diff = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            int g = gas[i];
            int c = cost[i];
            int x = g - c;
            diff[i] = x;
        }
        int max = Integer.MIN_VALUE;
        int maxIdx = 0;
        for (int i = 0; i < diff.length; i++) {
            int sum = 0;
            for (int j = i; j < diff.length + i; j++) {
                int k = j;
                if (k >= diff.length) {
                    k = j - diff.length;
                }
                sum += diff[k];
                if (sum < 0) {
                    break;
                }
            }
            if (sum > max) {
                max = sum;
                maxIdx = i;
            }
        }
        return maxIdx;
    }
    
    public static void main(String[] args) {
        Problem134 prob = new Problem134();
        System.out.println(prob.canCompleteCircuit(
            new int[]{1, 2, 3, 3},
            new int[]{2, 1, 5, 1}));
        System.out.println(prob.canCompleteCircuit(
            new int[] {6, 1, 4, 3, 5},
            new int[] {3, 8, 2, 4,2}));
    }
}
