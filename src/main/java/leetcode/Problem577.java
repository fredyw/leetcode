package leetcode;

/**
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/#/description
 */
public class Problem577 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem577 prob = new Problem577();
        System.out.println(prob.findRestaurant(
            new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
            new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"})); // Shogun
        System.out.println(prob.findRestaurant(
            new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
            new String[]{"KFC", "Shogun", "Burger King"})); // Shogun
    }
}
