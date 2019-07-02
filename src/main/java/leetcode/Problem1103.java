package leetcode;

/**
 * https://leetcode.com/problems/distribute-candies-to-people/
 */
public class Problem1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] answer = new int[num_people];
        int i = 0;
        while (candies >= 0) {
            int index = i % num_people;
            int val = i + 1;
            if (val <= candies) {
                answer[index] += val;
            } else {
                answer[index] += candies;
            }
            candies -= val;
            i++;
        }
        return answer;
    }
}
