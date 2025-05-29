// https://leetcode.com/problems/smallest-subarray-to-sort-in-every-sliding-window/description/
pub fn min_subarray_sort(nums: Vec<i32>, k: i32) -> Vec<i32> {
    let mut answer = vec![];
    let mut i = 0;
    while (i + k as usize) <= nums.len() {
        let mut sorted: Vec<i32> = (&nums[i..i + k as usize]).iter().copied().collect();
        sorted.sort();
        let sub = &nums[i..i + k as usize];
        let mut j = 0;
        while j < sorted.len() && sorted[j] == sub[j] {
            j += 1;
        }
        let mut k = sub.len() as isize - 1;
        while k >= 0 && sorted[k as usize] == sub[k as usize] {
            k -= 1;
        }
        if k >= 0 && j < sub.len() {
            answer.push(k as i32 - j as i32 + 1);
        } else {
            answer.push(0);
        }
        i += 1;
    }
    answer
}

fn main() {
    println!("{:?}", min_subarray_sort(vec![1, 3, 2, 4, 5], 3)); // [2,2,0]
    println!("{:?}", min_subarray_sort(vec![5, 4, 3, 2, 1], 4)); // [4,4]
    println!("{:?}", min_subarray_sort(vec![3, 2, 1], 3)); // [3]
}
