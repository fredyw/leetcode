// https://leetcode.com/problems/maximum-product-pair-with-target-sum/description/
pub fn max_product_pair(nums: Vec<i32>, target: i32) -> Vec<i32> {
    let mut answer = (-1, -1);
    for i in 0..nums.len() {
        for j in (i + 1)..nums.len() {
            if (nums[i] + nums[j]) == target && nums[i] != nums[j] {
                if answer.0 == -1 && answer.1 == -1 {
                    answer = (i as i32, j as i32);
                } else if nums[answer.0 as usize] * nums[answer.1 as usize] < nums[i] * nums[j] {
                    answer = (i as i32, j as i32);
                }
            }
        }
    }
    if answer.0 == -1 && answer.0 == -1 {
        vec![-1, -1]
    } else if nums[answer.0 as usize] < nums[answer.1 as usize] {
        vec![answer.1, answer.0]
    } else {
        vec![answer.0, answer.1]
    }
}

fn main() {
    println!("{:?}", max_product_pair(vec![1, 2, 3, 4], 5)); // [2,1]
    println!("{:?}", max_product_pair(vec![-3, -1, 4, 2], 1)); // [3,1]
    println!("{:?}", max_product_pair(vec![3, 3, 5], 6)); // [-1,-1]
    println!("{:?}", max_product_pair(vec![1, -6], -5)); // [0,1]
}
