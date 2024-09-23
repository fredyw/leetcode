// https://leetcode.com/problems/count-pairs-in-two-arrays/description/
pub fn count_pairs(nums1: Vec<i32>, nums2: Vec<i32>) -> i64 {
    fn greater_than_count(v: &[i32], target: i32) -> i64 {
        let mut low: isize = 0;
        let mut high: isize = v.len() as isize;
        while low <= high {
            let mid = low + (high - low) / 2;
            if mid as usize >= v.len() {
                break;
            }
            if v[mid as usize] <= target {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        v.len() as i64 - low as i64
    }

    // nums1[i] + nums1[j] > nums2[i] + nums2[j]
    // (nums1[i] - nums2[i]) + (nums1[j] - nums2[j]) > 0
    // diff[i] + diff[j] > 0
    let mut diff = vec![0; nums1.len()];
    for i in 0..nums1.len() {
        diff[i] = nums1[i] - nums2[i];
    }
    diff.sort();
    let mut answer = 0;
    for i in 0..diff.len() - 1 {
        if diff[i] > 0 {
            answer += (diff.len() - (i + 1)) as i64;
        } else {
            answer += greater_than_count(&diff[i + 1..], diff[i].abs());
        }
    }
    answer
}

fn main() {
    println!("{}", count_pairs(vec![2, 1, 2, 1], vec![1, 2, 1, 2])); // 1
    println!("{}", count_pairs(vec![1, 10, 6, 2], vec![1, 4, 1, 5])); // 5
}
