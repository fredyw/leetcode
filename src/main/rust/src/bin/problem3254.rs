// https://leetcode.com/problems/find-the-power-of-k-size-subarrays-i/description/
pub fn results_array(nums: Vec<i32>, k: i32) -> Vec<i32> {
    let mut answer = vec![];
    let mut i = 0;
    while i < nums.len() - k as usize + 1 {
        let mut is_sorted = true;
        let mut j = i;
        while i + (k as usize) - 1 < nums.len() && j < i + k as usize - 1 {
            if nums[j] + 1 != nums[j + 1] {
                is_sorted = false;
                break;
            }
            j += 1;
        }
        if is_sorted {
            answer.push(nums[j]);
        } else {
            answer.push(-1);
        }
        i += 1;
    }
    answer
}

fn main() {
    println!("{:?}", results_array(vec![1, 2, 3, 4, 3, 2, 5], 3)); // [3,4,-1,-1,-1]
    println!("{:?}", results_array(vec![2, 2, 2, 2, 2], 4)); // [-1,-1]
    println!("{:?}", results_array(vec![3, 2, 3, 2, 3, 2], 2)); // [-1,3,-1,3,-1]
}
