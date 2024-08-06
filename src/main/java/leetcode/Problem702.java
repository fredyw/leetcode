package leetcode;

// https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/description/
public class Problem702 {
    public interface ArrayReader {
        int get(int index);
    }

    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 1;
        while (reader.get(right) < target) {
            left = right;
            right <<= 1;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (reader.get(mid) == target) {
                return mid;
            }
            if (reader.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
