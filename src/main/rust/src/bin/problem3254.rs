// https://leetcode.com/problems/find-the-power-of-k-size-subarrays-i/description/
pub fn results_array(nums: Vec<i32>, k: i32) -> Vec<i32> {
    if k == 1 {
        return nums;
    }
    let mut answer = vec![-1; nums.len() - k as usize + 1];
    let mut count = 1;
    for i in 0..nums.len() - 1 {
        if nums[i] + 1 == nums[i + 1] {
            count += 1;
        } else {
            count = 1;
        }
        if count >= k {
            answer[(i as i32 - k + 2) as usize] = nums[i + 1];
        }
    }
    answer
}

fn main() {
    println!("{:?}", results_array(vec![1, 2, 3, 4, 3, 2, 5], 3)); // [3,4,-1,-1,-1]
    println!("{:?}", results_array(vec![2, 2, 2, 2, 2], 4)); // [-1,-1]
    println!("{:?}", results_array(vec![3, 2, 3, 2, 3, 2], 2)); // [-1,3,-1,3,-1]
    println!("{:?}", results_array(vec![3, 2, 3, 4, 2, 3, 4, 2], 3)); // [-1,4,-1,-1,4,-1]
    println!("{:?}", results_array(vec![1, 2, 3, 4, 5, 6, 7, 8], 3)); // [3,4,5,6,7,8]
    println!("{:?}", results_array(vec![1, 2, 3, 4, 5], 1)); // [1,2,3,4,5]
}
